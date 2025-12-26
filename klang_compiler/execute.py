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
		
def find_executable_path() -> str:
    filename: str = "klang.exe"
    if platform.system() == 'Windows':
        # Windows approach (slow)
        for root, dirs, files in os.walk('C:\\'):
            if filename in files:
                return os.path.join(root, filename)
    else:
        # Unix-like (use `locate` command if available)
        try:
            output = shutil.which('locate')
            if output:
                import subprocess
                result = subprocess.run(['locate', filename], capture_output=True, text=True)
                paths = result.stdout.strip().split('\n')
                if paths:
                    return paths[0]
        except Exception:
            return ""
    return ""

def execute(filename: str) -> None:
    keys: dict[str, str] = {
        # functions, and classes
        "cls": "class",
        "__ctr__": "__init__",
        "Ctr": "Self",
        "__constr__": "__init__",
        "Constr": "Self",
        "This": "Self",
        "this": "self",
        "It": "Self",
        "it": "self",
        "its": "self",
        "Me": "Self",
        "me": "self",
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
        "guna": "*",
        "plus": "+",
        "pls": "+",
        "minus": "-",
        "mns": "-",
        # other
        "kaho": "print",
        "agar": "if",
        r"warna?[_\s]?agar": "elif",
        # ATTENTION: the `r` is needed here,
        # as unlike all the other keys,
        # this one has un escaped characters
        "warna": "else",
        "aur": "and",
        "either": "",
        "yato": "",
        "k[aeio]": "",
        "ya": "or",
        # sequence
        r"na(?:hi)?[\s_]?(he|ba?ra?ba?r)": "!=",
        # sequence
        r"he|ba?ra?ba?r": "==",
        # sequence
        "nahi": "not",
        "har": "for",
        "every": "for",
        "andar": "in",
        "under": "in",
        "within": "in",
        "until": "in rng",
        "limit": "range",
        "ruko": "break",
        "ignore": "continue",
        "with_index|numbered": "enumerate",
        r"(final|var|farz)\s": "",
        "lafz": "str",
        "jumla": "str",
        # "jumle": "list[str]",
        "flt|d(?:ou)?ble?": "float",
        # "flts": "list[float]",
        # "floats": "list[float]",
        "nr": "Number",
        # "nrs": "list[Number]",
        "bln|filha{1,2}l": "bool",
        r"[Yy]es|[Ss]ach|[Hh]a|true": "True",
        r"[Nn]o|[Jj]hoot|[Nn]a|false": "False",
        r"k(lang)?__help": "print('Not implemented yet')",
        r"k(lang)?__name": "print('Klang version 0.8')",
        r"k(lang)?__about": r"print('\\nK    K    L             A    NNN   N      GGGG\\nK  K      L            A A     NN   N    G    G\\nKK        L           A  A     N N   N   G\\nK K       L          A AAA     N  N  N   G  GGGG\\nK   K     L         A    A     N   N N   G     G\\nK     K   LLLLLLL  A     AA   NN    N     GGGGGG\\n\\n\tversion 0.8\\n__________________________________________________\\n\\nCredits:\\n\t  Core developer\\n\t\t@ KhurramAli \t\t  \\n\t\t\t\t\\n__________________________________________________')",
        r"k(lang)?__version": "print('Klang v0.8')",
        # € implement help later
        r"throw": "raise",
        r"na(?:ya|i|ew)": "",
        r"koshish(?=:)": "try",
        r"(error(?:\s(by|(?:ki|ba|ka)[\s_]?(waja|zaria|sabab)))|(fail(?:ure|ed)|naka{1,2}mi?)(?:\s(by|(?:ki|ba|ka)[\s_]?(?:waja((?:\she)?\sagar(?:\she)?)?|zaria|sabab)))?)(?=[^\:\n\t]+\:)": "except",
        r"tor": "as",
        # Error aliases
        "FileNaMojudError": "FileNotFoundError",
    }
    with open_case_ins(filename, "r") as file:
        code = file.read()
        # Remove strings
        strings = find_matches(code, r"\"[^\"]*\"")
        for i, string in enumerate(strings):
            code = code.replace(string, f"__STRING_{i}__")
        # Replace keywords
        #code = replace(code, r"\b(start)\:", "if __name__ == \"__main__\":")
        # handling import cases
        # sequence matters!
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<function>\w+) (?<module>[\w\.]+) (me)?[_\s]?se\b", "from $module import $function as $alias")
        code = replace(code, r"\b(?<module>[\w\.]+) (me)?[_\s]?se mangao (?<functions>(\w+(,\s)?)+)\b", "from $module import $functions")
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<module>[\w\.]+)\b", "import $module as $alias")
        code = replace(code, r"\bmangao (?<module>[\w\.]+)\b", "import $module")
        # sequence matters!
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^\s*(?<B>\-?\d*\.?\d+)", "$A**$B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{3}", "$A**3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{2}", "$A**2")
        code = replace(code, r"(?:\\/|√)\s?(?<A>\-?\d*\.?\d+)", "int($A**(1/2))")
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
        code = replace(code, r"\b(print|kaho)\s([^\t\n\(\)]+)", "$1($2)")
        code = replace(code, r",?\s<?(might (?:throw|raise)|(throw|raise)s)\s[^\:\n\t]+>?(?=\:)", "")
        # ^ supposedly after a function fc x({...}?) might throw SomeError, and before a colon
        code = replace(code, r"\b(?:collect(?:ed)?|together)\((?<params>(?<firstparam>[^\(\)]+),\s*(?<restofparams>[^\(\)]+))\)", "list(zip($params))")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        # NOTE: does not support sub-dictionaries yet
        code = replace(code, r"(?<!obj\()(\{\s*[\"']?[\w.\-]+[\"']?\s*:\s*[^\{\}]+\})", "KL_Py.obj($1)")
        # sequence matters
        # __str, __eq -> __str__, __eq__
        code = replace(code, r"(?<=\b\_\_)([A-Za-z0-9]+)\b", "$1__")
        code = replace(code, r"@([Oo]ver(?:writ{1,2}e|rid{1,2}e)[sn]?|[Ee]xtend|([Rr]e|[Nn]ot)_?[Ii]mplement(ed)?|nae_sire)\s{1}", "")
        code = replace(code, r"\bk(?=__STRING_\d+__)", "f")
        # sequence matters
        code = replace(code, r",(?=\s?(tor|as))", "")
        # handling optionality, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<type>[A-Za-z]\w*)\?", "$type|None")
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
            code = re.sub(r"\b(" + key + r"(?!\s?:\s?\w+))\b", value, code)
        code = replace(code, r"(?<type>[A-Za-z]\w*)(?:\[\]|<list>)", "list[$type]")
        # watch the sequence
        code = replace(code, r"(?<=\=)\s*not(?=\n)", "False")
        # relies ultimately on the positive lookahead (?=\s?\=)
        # `type x=` = `x: type=`
        # needed
        code = replace(code, r"(?<type>[A-Za-z][\w\[\]]*)\s(?<varname>[A-Za-z]\w*)\s?\={1}(?!\=)", "$varname: $type =")
        # custom data types
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<typenumlist>numlist)\s*\=\s?(?<array>\[(\-?\d*\.?\d+(,\s*)?)+\])", "$varname: $typenumlist = $typenumlist($array)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<strtype>str)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $strtype = Str($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<inttype>int)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $inttype = Int($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<floattype>float)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $floattype = Flt($data)")
        # ^ specifically for numlists
        # arr: numlist = [1, 2, 3]
        # becomes ->
        # arr: numlist = numlist([1, 2, 3])
        # Restore strings
        for j, string in enumerate(strings):
            code = code.replace(f"__STRING_{j}__", string)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        import builtins
        (builtins.version, builtins.copyright, builtins.license, builtins.credits, builtins.help) = ("Klang version 0.8", "© 2025, Klang corp.", "MIT", "Core developers\\\n\t~ Khurram Ali", "Not implemented yet")
        for k in dir(platform):
        	if "python" in k:
        		delattr(platform, k)
        		setattr(platform, replace(k, "python", "klang"), "")
        (sys.version, sys.version_info, sys.executable, sys.pycache_prefix) = (version, version, find_executable_path(), "")
        extended_builtins: dict[str, Any] = {"builtins": builtins, "Number": Number, "sys": sys, "platform": platform, "__name__": "__main__"}
        add_module("KL_Py", extended_builtins)
        namespace: dict[str, Any] = extended_builtins | {}
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
if "main" in globals():
	del main
# if a main function (FROM another module got leaked through), delete it
#declare a new main for this file
sys.tracebacklimit=0
# we need this to minimize the stack trace, and to ADD EMPHASIS on the actual problem
# handling ERRORS
class BuraSyntaxError(SyntaxError):
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