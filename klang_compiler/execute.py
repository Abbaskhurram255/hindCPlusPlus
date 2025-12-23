import re
from sys import argv
from numbers import Number
from typing import *
from types import *
import importlib
import KL_Py
# ^ the import above is a MANDATORY imoort, and so is the following:
from KL_Py import *

def add_module(module_name: str, namespace: dict) -> None:
	module = importlib.import_module(module_name)
	for name in dir(module):
		if name.startswith("__"):
		    continue
		namespace[name] = getattr(module, name)
        
def fix_indent(file):
    indentation_level = 0
    indentation_sign = "    "
    str_indented = ""
    for line in file.readlines():
        # Search for comments, and remove for now. Re-add them before writing to
        # result string
        regex_to_match_comments: str = r"[^\"']*[ \t]*[^\"']*((?<![\"'])#[^\"']*$)"
        m = re.search(regex_to_match_comments, line)
        # Make sure # sign is not inside quotations. Delete match object if it is
        if m is not None:
            m2 = re.search(r"[\"'][^\"']*#[^\"']*[\"']", m.group(0))
            if m2 is not None:
                m = None
        if m is not None:
            add_comment = m.group(0)
            line = re.sub(regex_to_match_comments, "", line)
        else:
            add_comment = ""
        # skip empty lines:
        if line.strip() in ('\n', '\r\n', ''):
            str_indented += indentation_level*indentation_sign + add_comment.lstrip() + "\n"
            continue
        # remove existing whitespace:
        line = line.lstrip()
        # Check for reduced indent level
        for char in list(line):
            if char in ("}", ";"):
                indentation_level -= 1
        # Add indentation
        for char in range(indentation_level):
            line = indentation_sign + line
        # Check for increased indentation
        for char in list(line):
            if char in ("{", ":"):
                indentation_level += 1
        # Replace { with : and remove }
        line = re.sub(r"[\t ]*{[ \t]*", ":", line)
        line = re.sub(r"}[ \t]*", "", line)
        line = re.sub(r"\n:", ":", line)
        str_indented += line + add_comment
    return str_indented

def execute(filename: str) -> None:
    keys = {
        # functions, and classes
        "cls": "class",
        "__ctr": "__init__",
        "Ctr": "Self",
        "__constr": "__init__",
        "Constr": "Self",
        "This": "Self",
        "this": "self",
        "It": "Self",
        "it": "self",
        "its": "self",
        "my": "self",
        "super": "super()",
        "mom": "super()",
        "ma": "super()",
        "call": "__init__",
        "fc": "def",
        "act": "def",
        "ret": "return",
        # math
        "div": "/",
        "times": "*",
        "tms": "*",
        "mul": "*",
        "plus": "+",
        "pls": "+",
        "minus": "-",
        "mns": "-",
        # other
        "agar": "if",
        "warna agar": "elif",
        "warnagar": "elif",
        "warna": "elif",
        "aur": "and",
        "ya": "or",
        "nahi": "not",
        "he": "==",
        "har": "for",
        "every": "for",
        "andar": "in",
        "under": "in",
        "within": "in",
        "until": "in rng",
        "limit": "range",
        "ke": "",
        "ruko": "break",
        "ignore": "continue",
        # types
        "final ": "",
        "var ": "",
        "farz ": "",
        "lafz": "str",
        "jumla": "str",
        "nr": "Number",
        "Yes": "True",
        "yes": "True",
        "Sach": "True",
        "sach": "True",
        "Ha": "True",
        "ha": "True",
        "true": "True",
        "No": "False",
        "no": "False",
        "Jhoot": "False",
        "jhoot": "False",
        "Na": "False",
        "na": "False",
        "false": "False",
    }
    with open(filename, "r") as file:
        code = file.read()
        # Remove strings
        strings = find_matches(code, r"\"[^\"]*\"")
        for i, string in enumerate(strings):
            code = code.replace(string, f"__STRING_{i}__")
        # Replace keywords
        #code = replace(code, r"\b(start)\:", "if __name__ == \"__main__\":")
        # handling import cases
        # sequence matters!
        code = replace(code, r"\bsurat (?<alias>\w+) mangao (?<function>\w+) (?<module>[\w\.]+) (me)?[_\s]?se\b", "from $module import $function as $alias")
        code = replace(code, r"\b(?<module>[\w\.]+) (me)?[_\s]?se mangao (?<functions>(\w+(,\s)?)+)\b", "from $module import $functions")
        code = replace(code, r"\bsurat (?<alias>\w+) mangao (?<module>[\w\.]+)\b", "import $module as $alias")
        code = replace(code, r"\bmangao (?<module>[\w\.]+)\b", "import $module")
        # sequence matters!
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^\s*(?<B>\-?\d*\.?\d+)", "$A ** $B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{3}", "$A ** 3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{2}", "$A ** 2")
        # SEQUENCE MATTERS
        # handling `A me B`, and `A B me` cases
        code = replace(code, r"(?<B>\S+) (?<A>(\w+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\'])) me", "$B in $A")
        code = replace(code, r"(?<A>(\w+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\'])) me (?<B>\S+) ", "$B in $A")
        # handle (?<=cls )`B (of|from|>|ext(ends)?|is_?an?) A` cases
        code = replace(code, r"\bcls\b", "class")
        code = replace(code, r"(?<=\bclass\s)(?<B>\w+)\s(of|from|<|ext(ends)?|is[\s_]?an?)?\s?(?<A>(\w+(,\s*)?)+)\b", "$B($A)")
        # handle (?<=cls )`A [\.>] B` cases
        code = replace(code, r"(?<=\bclass\s)(?<A>(\w+(,\s*)?)+)\s*[\.>]\s*(?<B>\w+)\b", "$B($A)")
        code = replace(code, r"\benum\s(?<enumclassname>\w+)", "class $enumclassname(Enum)")
        code = replace(code, r"(?<varname>\w+)\.(?<method>replace(?:_first)?)\(", "$method($varname, ")
        code = replace(code, r"(?<varname>\w+)\.(?:ki_?)?(len(?:gth)?|lambai|size)(?:\(\))?", "len($varname)")
        code = replace(code, r"(?<A>\w+) (instance[\s_]?of|(?:is[\s_]?)?an?|(he_?)?ek|(is|has|of)?[\s_]?type(of)?) (?<B>\w+)", "isinstance($A, $B)")
        #code = replace(code, r"((?<k>\w+),\s*(?<v>\w+))\s*(in|andar)\b\s*(?!enumerate)", "$1 in enumerate")
        #code = replace(code, r"(?<k>\w+),\s*(?<v>\w+)\s*(of|from|:)\b\s*", "$k, $v in enumerate")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        code = replace(code, r"(\{\s*[\"']?[\w.\-]+[\"']?\s*:\s*[^\}]+\})", "KL_Py.obj($1)")
        # sequence matters
        # __str, __eq -> __str__, __eq__
        code = replace(code, r"(?<=\b\_\_)([A-Za-z0-9]+)\b", "$1__")
        code = replace(code, r"@[Oo]ver(?:writ{1,2}e|rid{1,2}e)[sn]?\s{1}", "")
        """
        final_variable_match_found = re.search(r"\bfinal ((?P<k>\w+(?:\s*:\s*\w+\?)?)\s*=\s*(?P<v>\S+))", code)
        final_vars: list[str, Any] = {}
        if final_variable_match_found:
        	k, v = final_variable_match_found.group("k"), final_variable_match_found.group("v")
        	if is_flt_like(v):
        		v = float(v)
        	elif is_int_like(v):
        		v = int(v)
        	elif is_bool_like(v):
        		v = True if v == "True" else False
        	print(f"{k=}, {v=}")
        	if k not in final_vars:
        		final_vars[k] = v
        		code = replace(code, final_variable_match_found.group(), final_variable_match_found.group(1))
        """
        # `type x=` = `x: type=`
        # handling optionality, and null cases
        # <type>? means the type is optional
        # sequence matters
        code = replace(code, r";", "")
        code = replace(code, r"(?<type>\w+)\?", "$type|None")
        code = replace(code, r"\bnone\b", "None")
        code = replace(code, r"(?<!\w)\?(?!\w)", "None")
        # announce :=
        """
        multi_assigment_regex: str = r"(?<k>\w+)\s*:=\s*\(?<v>[^)]+\)"
        multi_assigments: str|None = re.match(multi_assigment_regex, code)
        if multi_assignments is not None:
        	multi_assigments = multi_assigments.
        
        for occurence in multi_assigments:
        	code = replace(code, occurrence, "$k = ": ")
        
        a := (1, 2, 3)
        """
        for key, value in keys.items():
            code = re.sub(r"\b(" + re.escape(key) + r"(?!\s?:\s?\w+))\b", value, code)
        # watch the sequence
        # relies ultimately on the positive lookahead (?=\s?\=)
        code = replace(code, r"(?<type>\w+)\s(?<varname>\w+)\s?\={1}(?!\=)", "$varname: $type =")
        # Restore strings
        for j, string in enumerate(strings):
            code = code.replace(f"__STRING_{j}__", string)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        builtins: dict[str, Any] = {"Number": Number, "__name__": "__main__"}
        add_module("KL_Py", builtins)
        namespace: dict[str, Any] = builtins | {}
        exec(code, namespace)
        for name, obj in namespace.items():
        	if name.startswith("__"):
        		continue
        	if isinstance(obj, dict):
        		obj = KL_Py.obj(obj)
        	namespace[name] = obj
        if "main" in namespace and callable(namespace["main"]):
        	namespace["main"]()
        	
# let's try, and avoid some multi-main function conflict
if main:
	del main
# if a main function (FROM another module got leaked through), delete it
#declare a new main for this file
sys.tracebacklimit=0
# we need this to minimize  the stack trace, and TO ADD EMPHASIS on the actual problem
# handling ERRORS
class BuraSyntaxError(NameError):
	def __int__(self, name: str, message: str = " expected"):
		self.name = name
		self.message = message
		super().__init__(name, message)
class VariableNaMojudError(NameError):
	def __int__(self, name: str, message: str = " is undefined in this scope"):
		self.name = name
		self.message = message
		super().__init__(name, message)
		
		
		
def main() -> None:
    arg: str
    arg = argv[0] if len(argv) != 0 else "test.klang"
    if not arg.endswith(".klang"):
    	arg += ".klang"
    if not File(arg).is_file():
    	if len(argv) != 0:
    		arg = argv[0]
    if not File(arg).is_file():
    	arg = "main.klang"
    try:
    	execute(arg)
    except FileNotFoundError:
    	print("No entry point was found. Please pass in a valid filename.")
    except SyntaxError as e:
    	msg = replace(e.args[0], r"expected [\"\'](?<fix>\S+)[\"\']", "\"$fix\" ki umeed thi")
    	msg = f"\n    {msg} line {e.lineno} pe"
    	if len(e.args) >= 2 and isinstance(e.args[1], tuple) and len(e.args[1]) >= 4:
    		msg += f"\n    karib yaha: \"\n\t {e.args[1][3].strip()}\n    \"            ({e.args[0]}) ^^^\n\t\t\t        |||"
    	raise BuraSyntaxError(msg) from None
    except NameError as e:
    	msg = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
    	msg = f"\n\tVariable \"{msg}\" is scope me mojud nahi"
    	raise VariableNaMojudError(msg) from None

if __name__ == "__main__":
    main()