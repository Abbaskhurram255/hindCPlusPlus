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
        

def execute(filename: str) -> None:
    keys = {
        # functions, and classes
        "cls": "class",
        "_ctr": "def __init__",
        "Ctr": "None",
        "_constr": "def __init__",
        "Constr": "None",
        "_make": "def __init__",
        "_init": "def __init__",
        "_str": "def __str__",
        "this": "self",
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
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "\"$k\": $v,")
        # handling optionality, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<type>:\s*\w+)(?<optionalityoperator>\?)", "$type|None")
        code = replace(code, r"\bnone\b", "None")
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
        class FinalizedVariableException(Exception):
        	...
        class Final:
        	def __init__(self, fieldname: str, fieldvalue: Any):
        		super().__setattr__("fieldname", fieldname)
        		super().__setattr__("fieldvalue", fieldvalue)
        	def __setattr__(self, newfieldname: str, newfieldvalue: Any):
        		raise FinalizedVariableException(f"Final variable {name} cannot be reassigned!")
        #finalfieldmatches: list[str] = find_matches(code, r"\bfinal (?<val>\w+)")
        xzz: Match|None = re.match(r"\bfinal (?P<val>\w+)", code)
        if xzz:
        	print(xzz.group("val"))
        code = replace(code, r"\bfinal\s(?=\w+)", "")
        for key, value in keys.items():
            code = re.sub(r"(?<!(?:arz|var)\s)\b(" + re.escape(key) + r"(?!\s?:\s?\w+))\b", value, code)
        # Restore strings
        for j, string in enumerate(strings):
            code = code.replace(f"__STRING_{j}__", string)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        namespace: dict = {"Number": Number, "__name__": "__main__"}
        add_module("KL_Py", namespace)
        exec(code, namespace)
        global_variables: dict = {}
        for name, obj in namespace.items():
        	if name.startswith("__"):
        		continue
        	global_variables[name] = obj
        if "main" in global_variables and callable(global_variables["main"]):
        	global_variables["main"]()
        	
# let's try, and avoid some multi-main function conflict
if main:
	del main
# if a main function (FROM another module got leaked through), delete it
#declare a new main for this file
sys.tracebacklimit=0
# we need this to minimize  the stack trace, and TO ADD EMPHASIS on the actual problem
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
    		msg += f"\n    yani yaha: \"\n\t {e.args[1][3].strip()}\n    \"            ({e.args[0]}) ^^^\n\t\t\t        |||"
    	raise BuraSyntaxError(msg) from None
    except NameError as e:
    	msg = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
    	msg = f"\n\tVariable \"{msg}\" is scope me mojud nahi"
    	raise VariableNaMojudError(msg) from None

if __name__ == "__main__":
    main()