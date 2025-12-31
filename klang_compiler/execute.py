import re
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
    keys: dict[str, str] = {
        # functions, and classes
        "cls": "class",
        "__(?:c(?:ons)?tr|make)__": "__init__",
        "Ctr": "Self",
        "Constr": "Self",
        "This": "Self",
        "this": "self",
        "It": "Self",
        "it": "self",
        "its": "self",
        "Me": "Self",
        "me": "self",
        "mera": "self",
        "meri": "self",
        r"Khud(?:\sk[aeio])?": "Self",
        # diff: capital first, not-capital first
        r"khud(?:\sk[aeio])?": "self",
        "my": "self",
        "super": "super()",
        "mom": "super()",
        "ma": "super()",
        "call": "__init__",
        "fc": "def",
        "act": "def",
        r"(?:q(?:uick)?|s(?:hort))[_\s]?fc": "lambda",
        "ret|out": "return",
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
        # match-case
         r"aga?r[_\s]match(?=\s[^\n\t\:]+\:)": "match",
         "sath": "case",
         # if-else
        # sequence
        r"agar(?![_\s]match)": "if",
        r"othr?ws[_\s]?if|warna?[_\s]?agar": "elif",
        # ATTENTION: the `r` is needed here,
        # as unlike all the other keys,
        # this one has un escaped characters
        r"othr?ws(?![_\s]?if)|warna(?![_\s]?a?gar)": "else",
        # leave it as is
        "aur": "and",
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
        "until": "in range",
        "limit": "range",
        "ruko": "break",
        "ignore": "continue",
        "with_index|numbered": "enumerate",
        "e_auto": "enum.auto",
        "kism": "type",
        "func": "Callable",
        r"(?:return(s(?:_an?)?|_kare)|gives_an?)": "->",
        #theres a difference between these two ^ √
        "Shayad": "Union",
        "isfunc": "callable",
        "char": "Char",
        # ^^ much needed
        # char is the keyword 
        # while Char with a
        # capital C
        # is a Class
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
        r"[Nn]o|[Jj]hoot|[Nn]ahi|false": "False",
        r"k(lang)?__help": "print('Not implemented yet')",
        r"k(lang)?__name": "print('Klang version 0.8')",
        r"k(lang)?__about": r"print('\\nK    K    L             A    NNN   N      GGGG\\nK  K      L            A A     NN   N    G    G\\nKK        L           A  A     N N   N   G\\nK K       L          A AAA     N  N  N   G  GGGG\\nK   K     L         A    A     N   N N   G     G\\nK     K   LLLLLLL  A     AA   NN    N     GGGGGG\\n\\n\tversion 0.8\\n__________________________________________________\\n\\nCredits:\\n\t  Core developer\\n\t\t@ KhurramAli \t\t  \\n\t\t\t\t\\n__________________________________________________')",
        r"k(lang)?__version": "print('Klang v0.8')",
        # € implement help later
        r"throw": "raise",
        r"koshish(?=\:)": "try",
         r"(error(?:\s(by|(?:ki|ba|ka)[\s_]?(waja|zaria|sabab)))|(fail(?:ure|ed)|naka{1,2}mi?)(?:\s(by|(?:ki|ba|ka)[\s_]?(?:waja((?:\she)?\sagar(?:\she)?)?|zaria|sabab)))?)(?=[^\:\n\t]+\:)": "except",
        r"tor": "as",
        # Error aliases
        "FileNaMojudError": "FileNotFoundError",
        "BuraSyntaxError": "SyntaxError",        "VariableNaMojudError": "NameError",
        "GalatValueError": "ValueError",
        
    }
    with open_case_ins(filename, "r") as file:
        code = file.read()
        # Remove strings
        strings = find_matches(code, r"\"[^\"]+\"") + find_matches(code, r"\'[^\'\"]+\'")
        # added partial support for ''
        for i, string in enumerate(strings):
        	strings[i] = strings[i][1:-1]
        	strings[i] = replace(strings[i], r"\{([^\}]*)\}", r"[$1]")
        	# WARNING: this changes core Python f-string functionality for {}
        	strings[i] = "f\"" + replace(replace(strings[i], r"(?<!\\)\$([^\s\n\t]+)", r"{$1}####"), r"(?<=\})#{4}", "") + "\""
        	# the #### part helps get rid of a bug
        	# this replaces previously remove {} functionality with new $-based functionality
        	# WARNING: r"{$1}####" should be as is
        	# the additional whitespace keeps the whole function together
        	# ^ needed as-is
        	old_string = string
        	code = code.replace(old_string, f"__STRING_{i}__") # editor's NOTE: if it works, DON'T touch it! should be `replace(string, ...`, i.e. just AS-IS, and NOT replace(strings[i], ...
        	# ^ needed as-is
        # Replace context-based keywords
        # handling import cases
        # sequence matters!
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<function>\w+) (?<module>[\w\.]+) (me)?[_\s]?se\b", "from $module import $function as $alias")
        code = replace(code, r"(?<module>[\w\.]+) (me)?[_\s]?se mangao (?<functions>(\w+(,\s)?)+)\b", "from $module import $functions")
        code = replace(code, r"\bmangao (?<functions>(\w+(,\s)?)+) (?<module>[\w\.]+) (me)?[_\s]?se\b", "from $module import $functions")
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<module>[\w\.]+)\b", "import $module as $alias")
        code = replace(code, r"\bmangao (?<module>[\w\.]+)\b", "import $module")
        # post processing module syntax
        # which NOW HAS KEYWORD IMPORT instead of mangao
        code = replace(code, r"\b(?<=import\s)sab[_\s]?kuch\b", "*")
        code = replace(code, r"(?<=,)\s(?:a(nd|ur)|ya|(?:ke[_\s]?)?sath(me)?)\b", "")
        # sequence matters!
        code = replace(code, r"(?<![\t    \t])\b(?:fc|act|def)\s(?:main|start)(?:\([^\)\n\t]*\))?(?=(?:\s*->\s*[\w\?]+)?\:)", "def main()")
        code = replace(code, r"\.{3}(?<dict>[_A-Za-z]\w*)", "**$dict")
        code = replace(code, r"(?<!\.)\.{2}(?<list>[_A-Za-z]\w*)", "*$list")
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^\s*(?<B>\-?\d*\.?\d+)", "$A**$B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{3}", "$A**3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+)\s*\^{2}", "$A**2")
        code = replace(code, r"(?:\\/|√)\s?(?<A>\-?\d*\.?\d+)", "int($A**(1/2))")
        # SEQUENCE MATTERS
        # handling `A me B`, and `B A me` cases
        code = replace(code, r"(?<A>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\'])) me (?<B>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\']))(?:\s(?:mojud|shamil(?:\shen?)?|(?:ko\s)?(?:d[ei]kh[aeio]|pa{1,2}ya)(?:\s(?:ga?ya|he))?|hen?))?", "$B in $A")
        code = replace(code, r"(?<B>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\'])) (?<A>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[,\s]*[\)\]\}]*)+[\)\]\}\"\'])) me(?:\s(?:mojud|shamil(?:\shen?)?|(?:ko\s)?(?:d[ei]kh[aeio]|pa{1,2}ya)(?:\s(?:ga?ya|he))?|hen?))?", "$B in $A")
        #Number system
        code = replace(code, r"(?<!\w)(?<nA>\-?\d*\.?\w+) in(?:to)? (?<nB>\-?\d*\.?\d+)\b", "$nA/$nB")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\s(?:ka\sa{1,2}thwa|eighth|into\seight)\b", ".125*$n")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\s(?:ka\schothw?a|(?:into\s)?quarter|fou?r(?:th)?)\b", ".25*$n")
        code = replace(code, r"\b(?:adh[aei]|hal(?:ved|f[\s_]of))\s(?<n>\-?\d*\.?\w+)(?:\ska)?\b", ".5*$n")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\s(?:ka\sadha|halved|in (2|two|half))\b", ".5*$n")
        code = replace(code, r"\bpon[aei]\s(?<n>\w+)(?:\ska)?\b", "-.25+$n")
        code = replace(code, r"\b(?<n>\w+)\ska\spona\b", "-.25+$n")
        code = replace(code, r"\bsaw[aei]\s(?<n>\w+)(?:\ska)?\b", ".25+$n")
        code = replace(code, r"\b(?<n>\w+)\ska\ssawa\b", ".25+$n")
        code = replace(code, r"\bd[uo]\s?gu?n[aei]\s(?<n>\-?\d*\.?\w+)(?:\ska)?\b", "2*$n")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\ska\sd[uo]\s?gu?n[aei]\b", "2*$n")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\ska\scha{1,2}r\s?gu?n[aei]\b", "4*$n")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)\ska\sa{1,2}th\s?gu?n[aei]\b", "8*$n")
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?so\b", "*1" + "0"*2)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?hazar\b", "*1" + "0"*3)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?la{1,2}(?:c|kh)\b", "*1" + "0"*5)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?million\b", "*1" + "0"*6)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?crore?\b", "*1" + "0"*7)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?hund(?:o|red)\s?(?:[\*_]|times|guna|mul)?\s?million\b", "*1" + "0"*8)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?(?:ara?b|billion)\b", "*1" + "0"*9)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?(?:kharab|hund(?:o|red)\s?(?:[\*_]|times|guna|mul)?\s?billion)\b", "*1" + "0"*11)
        code = replace(code, r"(?<=\d)\s?(?:[\*_]|times|guna|mul)?\s?trillion\b", "*1" + "0"*12)
        # handle (?<=cls )`B (of|from|>|ext(ends)?|is_?an?) A` cases
        # sequence matters
        # _str, _eq -> __str__, __eq__
        code = replace(code, r"(?<!\w)\._([A-Za-z]+)\b(?=\()", "self.__$1__")
        code = replace(code, r"(?<!\w)\.([A-Za-z]\w*)\b(?=\()", "self.$1")
        # sequence
        code = replace(code, r"(?<=\w\.)_([A-Za-z]\w*)\b(?=\()", r"__$1__")
        # sequence
        code = replace(code, r"(?<!\.)\b_([A-Za-z]+)\b(?=\()", r"def __$1__")
        code = replace(code, r"@(redo|[Oo]ver(?:writ{1,2}e|rid{1,2}e)[sn]?|[Ee]xtends?|([Rr]e|[Nn]ot)_?[Ii]mplement(ed)?|dubara|nae_sire)\s{1}", "")
        code = replace(code, r"\b(static|direct|unlinked)\s(me?th?o?d|act|fc|def)\b", "def")
        code = replace(code, r"\bme?th?o?d (\w+\()(?=\))", "def $1self")
        code = replace(code, r"\bme?th?o?d (\w+\()(?!\)|self)", "def $1self, ")
        # sequence
        code = replace(code, r"\bcls\b", "class")
        code = replace(code, r"@auto(c(?:l(?:as)?s|(?:ons)?tr)|make)\b", "@dataclass")
        # sequence matters
        code = replace(code, r"(?<=\bclass\s)(?<B>\w+)\s(of|from|<|ext(ends)?|is[\s_]?an?)?\s?(?<A>(\w+(,\s*)?)+)\b", "$B($A)")
        # handle (?<=cls )`A [\.>] B` cases
        code = replace(code, r"(?<=\bclass\s)(?<A>(\w+(,\s*)?)+)\s*[\.>]\s*(?<B>\w+)\b", "$B($A)")
        code = replace(code, r"\benum\s(?<enumclassname>\w+)", "class $enumclassname(Enum)")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}\(\)]+[\"']?)\.(?<method>replace(?:_first)?)\(", "$method($varname, ")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}]+[\"']?)\.(?:ki_?)?(len(?:gth)?|lambai|size)(?:\(\))?", "len($varname)")
        code = replace(code, r"(?<A>[\w\-\.,\[\]\"']+) (instance[\s_]?of|(?:is[\s_]?)?an?|(he_?)?ek|(is|he|ki|has|of)?[\s_]?(type|kism)(of)?) (?<B>\w+)", "isinstance($A, $B)")
        code = replace(code, r"\b(print|kaho)\s([^\t\n]+)", "$1($2)")
        code = replace(code, r",?\s<?(might (?:throw|raise)|(throw|raise)s)\s[^\:\n\t]+>?(?=\:)", "")
        # ^ supposedly after a function fc x({...}?) might throw SomeError, and before a colon
        code = replace(code, r"\b(final|var|farz|n(?:a(?:ya|i)|ew)|either|yato)\s", "")
        code = replace(code, r"\s(to|hua|k[aeio])\b", "")
        code = replace(code, r"\b(?:collect(?:ed)?|together)\((?<params>(?<firstparam>[^\(\)]+),\s*(?<restofparams>[^\(\)]+))\)", "list(zip($params))")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?:\s*:\s*(?<type>[\w\[\]\|,\s]+\??))?\s*->\s*(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        # NOTE: does not support sub-dictionaries yet
        code = replace(code, r"(?<!obj\()(\{\s*[\"']?[\w.\-]+[\"']?\s*:\s*[^\{\}]+\})", "KL_Py.obj($1)")
        # core
        code = replace(code, r"\bf(?=__STRING_\d+__)", "")
        # sequence matters
        code = replace(code, r",(?=\s?(tor|as))", "")
        # adds a sprinkle of English-like flavor: with open(x, "r") as file [bad] -> with open(x, "r"), as file [better, or at least a little more readable]
        # handling Optionality: default, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<type>[A-Za-z]\w*)\?(?!\.)", "$type|None")
        code = replace(code, r"sath\s(?:[\.\?]{3}|ba{1,2}ki|anja{1,2}n)(?=\s?:)", "case _")
        code = replace(code, r"\bnone\b", "None")
        code = replace(code, r"(?<!\w)\?(?![\w\.])", "None")
        code = replace(code, r"(?<object>[_A-Za-z]\w*)\?\.(?<field>[_A-Za-z]\w*)", "$object.$field if ('$object' in globals() or '$object' in locals()) and hasattr($object, '$field') and $object.$field is not None else {}")
        code = replace(code, r"\b(?:neither|nato)\s(?<A>[^\n\t]+)\s(?:or\s)?(?:n?or|na(?:[\s_]?hi)?)\s(?<B>[^\n\t]+)", "not($A or $B)")
        for key, value in keys.items():
            code = re.sub(r"(?<!\\.)\b(" + key + r"(?!\s?:\s?\w+))\b", value, code)
        code = replace(code, r"(?<type>[A-Za-z]\w*)(?:\[\]|<list>)", "list[$type]")
        # int[] -> list[int]
        # int<list> -> list[int]
        code = replace(code, r"(?:type|kism)\s?<\s?(?<type>[_A-Za-z\?]\w*)\s?>", "$type")
        # watch the sequence
        code = replace(code, r"(?<=\=)\s*(?:not|nahi)(?=\n)", "False")
        # relies ultimately on the positive lookahead (?=\s?\=)
        # `type x=` = `x: type=`
        # needed
        code = replace(code, r"(?<type>[A-Za-z\?][\w\[\]]*)\s(?<varname>[A-Za-z]\w*)\s?\={1}(?!\=)", "$varname: $type =")
        code = replace(code, r"\b(?<varname>[A-Za-z]\w*)\s(expects|ume{0,2}d|chahe|wants|mange|needs)\s(?<type>[_A-Za-z\?]\w*)", "$varname: $type")
        # custom data types
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<typenumlist>num_?list)\s*\=\s?(?<array>\[(\-?\d*\.?\d+(,\s*)?)+\])", "$varname: numlist = numlist($array)")
        # ^ specifically for numlists
        # arr: numlist = [1, 2, 3]
        # becomes ->
        # arr: numlist = numlist([1, 2, 3])
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<typeintlist>int_?list)\s*\=\s?(?<array>\[(\-?\d*\.?\d+(,\s*)?)+\])", "$varname: intlist = intlist($array)")
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<typefltlist>(fl(?:oa)?t|d(?:ou)?ble?)_?list)\s*\=\s?(?<array>\[(\-?\d*\.?\d+(,\s*)?)+\])", "$varname: fltlist = fltlist($array)")
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<chartype>char)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $chartype = Char($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<strtype>str|lafz|jumla)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $strtype = Str($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<inttype>int)\s*\=\s?(?<data>[^\n\t]+)", "$varname: $inttype = Int($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*)\s*\:\s*(?<floattype>float|flt|double|dbl)\s*\=\s?(?<data>[^\n\t]+)", "$varname: float = Flt($data)")
        # Restore strings
        for j, string in enumerate(strings):
            code = code.replace(f"__STRING_{j}__", string)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        import builtins
        old_print: Callable = builtins.print
        def cust_print(*args, **kwargs):
        	if not args:
        		return
        	from pprint import pp
        	args = list(args)
        	# since tuples are immutable, we can't  work with them, we need a list
        	for i, arg in enumerate(args):
        		if isinstance(arg, (list, tuple, dict)):
        		    pp(arg)
        		    args[i] = None
        		elif is_int(arg):
        			args[i] = fpk(arg)
        		elif is_flt(arg):
        			args[i] = fpk(arg)
        		elif is_bool(arg):
        			args[i] = "Yes" if arg == True else "No"
        		args = [arg for arg in args if arg is not None]
        	old_print(*args, **kwargs)
        (builtins.version, builtins.copyright, builtins.license, builtins.credits, builtins.help, builtins.print) = ("Klang version 0.8", "© 2025, Klang corp.", "MIT", "Core developers\\\n\t~ Khurram Ali", "Not implemented yet", cust_print)
        for k in dir(platform):
        	if "python" in k:
        		delattr(platform, k)
        		#setattr(platform, replace(k, "python", "klang"), "")
        (sys.version, sys.version_info, sys.executable, sys.pycache_prefix) = (builtins.version, builtins.version, "", "")
        extended_builtins: dict[str, Any] = {"builtins": builtins, "print": cust_print, "range": rng, "Number": Number, "sys": sys, "platform": platform, "__name__": "__main__"}
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
	def __int__(self, name: str, message: str = " ki umeed thi"):
		self.name = name
		self.message = message
		super().__init__(name, message)
class VariableNaMojudError(NameError):
	def __int__(self, name: str, message: str = " is scope me mojud nahi"):
		self.name = name
		self.message = message
		super().__init__(name, message)
class GalatValueError(ValueError):
	def __int__(self, name: str, message: str = " ki value galat he"):
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
    		msg = replace(msg, r"f(?=\-string)", "k")
    	raise BuraSyntaxError(msg) from None
    except NameError as e:
    	msg = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
    	msg = f"\n\tVariable \"{msg}\" is scope me mojud nahi"
    	raise VariableNaMojudError(msg) from None
    except ValueError as e:
    	msg = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
    	msg = f"\n\tValue \"{msg}\" ki umeed NAHI thi yaha,\n\t"
    	msg += replace(e.args[0], r"\b[Ii]nvalid\b", "galat")
    	
    	raise GalatValueError(msg) from None

if __name__ == "__main__":
    main()