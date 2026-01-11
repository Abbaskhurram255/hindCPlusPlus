import re
from numbers import Number
from typing import *
from types import *
import importlib, cmd, ctypes
import KL_Py
# ^ the import above is a MANDATORY imoort, and so is the following:
from KL_Py import *


def get_initial_of(x: Any) -> Any:
	if not x:
		return None
	out: Any
	match x:
		case "str":
			out = ""
		case "int":
			out = 0 
		case "flt" | "float":
			out = 0.0
		case "bool" | "bln":
			out = False
		case "list":
			out = []
		case "numlist":
			out = numlist()
		case "intlist":
			out = intlist()
		case "fltlist":
			out = fltlist()
		case "dict" | "obj":
			out = KL_Py.obj()
		case _:
			out = None
	return out

def add_module(module_name: str, namespace: dict) -> None:
	module = importlib.import_module(module_name)
	for name in dir(module):
		if name.startswith("__"):
		    continue
		namespace[name] = getattr(module, name)
		
		
def execute(filename: str) -> None:
    keys: dict[str, str] = {
        # functions, and classes
        "__(?:c(?:ons)?tr|make|shurwat|banao|n(?:ew|a(?:ya|i)))__": "__init__",
        "__dev_print_(?:par|pe|mode)__": "__repr__",
       "__print_(?:par|pe|mode)__": "__str__",
       "__f(?:mt)?__": "__format__",
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
        "mujhe": "self",
        r"Khud(?: k[aeio])?": "Self",
        # diff: capital first, not-capital first
        r"khud(?: k[aeio])?": "self",
        "my": "self",
        "super": "super()",
        "parent": "super()",
        "mom": "super()",
        "ret|out": "return",
        # math
        r"(?<=\S\s)div(?=\s\S)": "/",
        r"(?<=\S\s)times(?=\s\S)": "*",
        r"(?<=\S\s)tms(?=\s\S)": "*",
        r"(?<=\S\s)mul(?=\s\S)": "*",
        r"(?<=\S\s)guna(?=\s\S)": "*",
        r"(?<=\S\s)plus(?=\s\S)": "+",
        r"(?<=\S\s)pls(?=\s\S)": "+",
        r"(?<=\S\s)minus(?=\s\S)": "-",
        r"(?<=\S\s)mns(?=\s\S)": "-",
        # other
        "kaho": "print",
        # match-case
        r"aga?r[_ ]match(?= [^\n\t\:]+\:)": "match",
        "sath": "case",
        # if-else
        # sequence
        r"agar(?![_ ]match)": "if",
        r"othr?ws[_ ]?if|warna?[_ ]?agar": "elif",
        # ATTENTION: the `r` is needed here,
        # as unlike all the other keys,
        # this one has un escaped characters
        r"othr?ws(?![_ ]?if)|warna(?![_ ]?a?gar)": "else",
        # leave it as is
        "aur": "and",
        "ya": "or",
        # sequence
        "chota[_ ]ya[_ ]ba?ra?ba?r": "<=",
        "bara[_ ]ya[_ ]ba?ra?ba?r": ">=",
        "chota(?![ _]ya)": "<",
        "bara(?![ _]ya)": ">",
        r"(?<=\S\s)na(?:hi)?[ _]?(he|ba?ra?ba?r)(?=\s?\S)": "!=",
        # sequence
        r"(?<=\S\s)(he|ba?ra?ba?r)(?=\s?\S)": "==",
        # sequence
        r"nahi(?=\s\S)": "not",
        "ja?bta?k": "while",
        "har": "for",
        "every": "for",
        "andar|darmya{1,2}n": "in",
        "under": "in",
        "within": "in",
        "until": "in range",
        "limit": "range",
        "ruko": "break",
        "ignore": "continue",
        "with_index|numbered": "enumerate",
        "e_auto": "enum.auto",
        r"kism(?=\s?\()": "type",
        "func": "Callable",
        r"(?:(?:return|out)(s(?:[_ ]an?)?|[_ ]kare)|gives[ _]an?|deta[ _]ek)": "->",
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
         r"(error(?: (by|(?:ki|ba|ka)[ _]?(waja|zaria|sabab)))|(fail(?:ure|ed)|naka{1,2}mi?)(?: (by|(?:ki|ba|ka)[ _]?(?:waja((?: he)? agar(?: he)?)?|zaria|sabab)))?)(?=[^\:\n\t]+\:)": "except",
        r"tor": "as",
        # Error aliases
        "FileNaMojudError": "FileNotFoundError",
        "BuraSyntaxError": "SyntaxError",        "VariableNaMojudError": "NameError",
        "GalatValueError": "ValueError",
        
    }
    with open_case_ins(filename, "r") as file:
        code: str = file.read()
        # Remove comments
        # --- since they're only meant for the developer ---
        # to help us save memory
        code = replace(code, r"#[^\n]+", "")
        code = replace(code, r"\"{3}[^\"]+\"{3}", "")
        # Remove strings
        strings: list[str] = find_matches(code, r"\"[^\"]+\"") + find_matches(code, r"\'[^\'\"]+\'")
        # added partial support for ''
        for i, string in old_enumerate(strings):
        	strings[i] = strings[i][1:-1]
        	strings[i] = replace(strings[i], r"\$(?=\{)", "")
        	#strings[i] = replace(strings[i], r"\{([^\}]*)\}", r"[$1]")
        	# WARNING: this changes core Python f-string functionality for {}
        	# actually, for the sake of commas, and spaces (as the $-based syntax can mess them up), let's allow both
        	# so the use has a choice to either:
        	# print "Name is $name, Age is $age"
        	# which is messed up, as the dollar recognizes the comma as part of the template --- resulting  in a tuple of `({{name}},)`
        	# or they could do {{{varname}}} for the problematic template, or a template with spaces:
        	# print "Name is {name}, Age is $age"
        	# which WORKS
        	# and results in "Name is {{name}}, Age is {{age}}"
        	strings[i] = "f\"" + replace(replace(strings[i], r"(?<!\\)\$([^ \n\t]+)", r"{$1}####"), r"(?<=\})#{4}", "") + "\""
        	# find the template strings, and if found, for each, post process it
        	if re.search(r"\{[^\}]+\}", strings[i]):
                    templates_found_in_string: list[str] = re.findall(r"(?<!\\)\{[^\}]+\}", strings[i])
                    for templt in templates_found_in_string:
                        # {sum (is|he)} should translate to
                        # sum (is|he): {sum}
                        templt = replace(templt, "\{(?<placeholder_slash_varname>[A-Za-z_]\w*) *(?<separator>is|he) *\}", "$placeholder_slash_varname $separator: {$placeholder_slash_varname}")
                        for key, value in keys.items():
                             processed_templt: str = replace(templt, fr"(?<!\.)\b({key}(?! ?\: ?\w+))\b", value)
                             strings[i] = replace(strings[i], templt, processed_templt)
        	# the #### part helps get rid of a bug
        	# this replaces previously remove {formatted_var} functionality with new $-based functionality
        	# WARNING: r"{$1}####" should be as is
        	# the additional whitespace keeps the whole function together
        	# ^ needed as-is
        	old_string = string
        	code = code.replace(old_string, f"__STRING_{i}__") # editor's NOTE: if it works, DON'T touch it! should be `replace(string, ...`, i.e. just AS-IS, and NOT replace(strings[i], ...
        	# ^ needed as-is
        # Replace context-based keywords
        # handling import cases
        # sequence matters!
        FOUR_WHITES: str = " " * 4
        code = replace(code, "\t", FOUR_WHITES)
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<function>\w+) (?<module>[\w\.]+) (me)?[_ ]?se\b", "from $module import $function as $alias")
        code = replace(code, r"(?<module>[\w\.]+) (me)?[_ ]?se mangao (?<functions>(\w+(, )?)+)\b", "from $module import $functions")
        code = replace(code, r"\bmangao (?<functions>(\w+(, )?)+) (?<module>[\w\.]+) (me)?[_ ]?se\b", "from $module import $functions")
        code = replace(code, r"\b(surat|tor) (?<alias>\w+) mangao (?<module>[\w\.]+)\b", "import $module as $alias")
        # comes after\/
        code = replace(code, r"\bmangao (?<module>[\w\.]+)\b", "import $module")
        # sequence matters!
        # post processing module syntax
        # which NOW HAS KEYWORD IMPORT instead of mangao
        code = replace(code, r"\b(?<=import )sab[_ ]?kuch\b", "*")
        code = replace(code, r"(?<=,) (?:a(nd|ur)|ya|(?:ke[_ ]?)?sath(me)?)\b", "")
        # sequence matters!
        code = replace(code, r"(?<![\t    \t])\b(?:fc|act|def) (?:main|start)(?:\([^\)\n\t]*\))?(?=(?: *-> *[\w\?]+)?\:)", "def main()")
        # operators
        # NULL coalescing
        code = replace(code, r"(?<A>[_A-Za-z]\w*)\s?\?\?\=\s?(?<B>[^\n\t]+)", "$A = $A if ('$A' in globals() or '$A' in locals()) and $A is not None else $B")
        # the ifCONDITION(is true, then)=
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:if|agar) ?(?<condition>[^\=]+)\=\s*(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or $A == $condition else $A")
        # the min= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) min *\= *(?<B>[^\n\t]+)", "$A = $B if ('$A' in globals() or '$A' in locals()) and (isinstance($A, (int, float)) and $A < $B) else 0 if ('$A' in globals() or '$A' in locals()) and (not isinstance($A, (int, float))) else $A")
        # the max= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) max *\= *(?<B>[^\n\t]+)", "$A = $B if ('$A' in globals() or '$A' in locals()) and (isinstance($A, (int, float)) and $A > $B) else 0 if ('$A' in globals() or '$A' in locals()) and (not isinstance($A, (int, float))) else $A")
        # the (def|fb)= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:def|fb|othr?ws) *\= *(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or not $A or type($A) != type($B) else $A")
        code = replace(code, r"(?<![\d ])\.{3}\s?(?<dict>[_A-Za-z]\w*)", "**$dict")
        # sequence
        code = replace(code, r"(?<![\.\d ])\.{2}\s?(?<list>[_A-Za-z]\w*)", "*$list")
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^ *(?<B>\-?\d*\.?\d+)", "$A**$B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{3}", "$A**3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{2}", "$A**2")
        code = replace(code, r"(?:\\/|√) ?(?<A>\-?\d*\.?\d+)", "int($A**(1/2))")
        # SEQUENCE MATTERS
        # handling `A me B`, and `B A me` cases
        code = replace(code, r"(?<A>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[, ]*[\)\]\}]*)+[\)\]\}\"\'])) me (?<B>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[, ]*[\)\]\}]*)+[\)\]\}\"\']))(?: (?:mojud|shamil(?: hen?)?|(?:ko )?(?:d[ei]kh[aeio]|pa{1,2}ya)(?: (?:ga?ya|he))?|hen?))?", "$B in $A")
        code = replace(code, r"(?<B>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[, ]*[\)\]\}]*)+[\)\]\}\"\'])) (?<A>([\w\-\.]+|[\(\[\{\"\'](?:[\"\'\w\-\.]+[, ]*[\)\]\}]*)+[\)\]\}\"\'])) me(?: (?:mojud|shamil(?: hen?)?|(?:ko )?(?:d[ei]kh[aeio]|pa{1,2}ya)(?: (?:ga?ya|he))?|hen?))?", "$B in $A")
        #Number system
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?so\b", f"*1{'0'*2}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?hazar\b", f"*1{'0'*3}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?la{1,2}(?:c|kh)\b", f"*1{'0'*5}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?million\b", f"*1{'0'*6}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?crore?\b", f"*1{'0'*7}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?hund(?:o|red) ?(?:[\*_]|times|guna|mul)? ?million\b", f"*1{'0'*8}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?(?:ara?b|billion)\b", f"*1{'0'*9}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?(?:kharab|hund(?:o|red) ?(?:[\*_]|times|guna|mul)? ?billion)\b", f"*1{'0'*11}")
        code = replace(code, r"(?<=\d) ?(?:[\*_]|times|guna|mul)? ?trillion\b", f"*1{'0'*12}")
        # come before
        code = replace(code, r"(?<=[A-Za-z_])\s?(\.\.(?!\.))\s?(?=[^\:]+\:)", " in ")
        code = replace(code, r"(?<n1>\-?\d*\.?\d+)\s?(?:\.\.|se)\s?(?<n2>\-?\d*\.?\d+)", "range($n1, $n2)")
        # sequence
        # comes after
        # to avoid conflict
        code = replace(code, r"(?<!\w)(?<nA>\-?\d*\.?\w+) in (?<nB>\-?\d*\.?\d+)\b", "($nA/$nB)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+) (?:ka a{1,2}thwa|eighth|into eight)\b", "(.125*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+) (?:ka chotha|(?:in )(quarter|four)|quartered|fou?rth)\b", "(.25*$n)")
        code = replace(code, r"\b(?:adh[aei]|hal(?:ved|f[ _](?:of|as))) (?<n>\-?\d*\.?\w+)\b", "(.5*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+) (?:ka adha|halved|in (?:two|half))\b", "(.5*$n)")
        code = replace(code, r"\bpon[ae] (?<n>\w+)\b", "(-.25+$n)")
        code = replace(code, r"\bsawa (?<n>\w+)\b", "(.25+$n)")
        code = replace(code, r"\bsa{1,2}dhe (?<n>\w+)\b", "(.5+$n)")
        code = replace(code, r"\b(?:twice(?:[_ ]as)?|d[uo] ?gu?n[aei]) (?<n>\-?\d*\.?\w+)\b", "(2*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)( ka)? (?:twice|d[uo] ?gu?n[aei])\b", "(2*$n)")
        code = replace(code, r"\b(?:thrice(?:[_ ]as)?|teen gun[aei]) (?<n>\-?\d*\.?\w+)\b", "(3*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+)( ka)? (?:thrice|teen gun[aei])\b", "(3*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+) (?:cha{1,2}r|4) gu?n[aei]\b", "(4*$n)")
        code = replace(code, r"(?<!\w)(?<n>\-?\d*\.?\w+) (?:a{1,2}th|8) gu?n[aei]\b", "(8*$n)")
        # ([..params(, *)?]*) -> lambda [..params(, *)?]:
        # e.g.
        # `(x) ->` becomes lambda x:
        # `(x, y) ->` becomes `lambda x, y:`
        # however, only handles parenthesized lambda parameters
        # not supported for:
        # `x ->`
        code = replace(code, r"(?<!\w)\((?<params>(?:[A-Za-z_]\w*(?:, *)?)*)\) ?\->(?=\s?\S)", "lambda $params:")
        # the actual support for `x ->` 
        code = replace(code, r"\b(?:fc|act) (?<param>[A-Za-z_]\w*)(?=\: ?[^\n]{2,})", "lambda $param")
        # helps drop the parentheses if the function doesn't allow parameters
        # fc log: -> fc log():
        code = replace(code, r"\b(?:fc|act) (?<funcname_followed_not_by_parens>[A-Za-z_]\w*)(?=(?<could_have_a_return_type>[^\(\)\:]+)?\:\n)", "def $funcname_followed_not_by_parens()")
        code = replace(code, r"\b(?:fc|act) (?<funcname_regular>[A-Za-z_]\w*)\((?<params>[^\)]+)?\)(?=(?<could_have_a_return_type>[^\:]+)?\:\n)", "def $funcname_regular($params)")
        # handle (?<=cls )`B (of|from|>|ext(ends)?|is_?an?) A` cases
        # sequence matters
        # _str, _eq -> __str__, __eq__
        code = replace(code, r"(?<=\s)\._([A-Za-z]+)\b(?=\()", "self.__$1__")
        code = replace(code, r"(?<=\s)\.([A-Za-z]\w*)\b(?=\()", "self.$1")
        # sequence
        code = replace(code, r"(?<=\w\.)_([A-Za-z]\w*)\b(?=\()", r"__$1__")
        # sequence
        code = replace(code, r"(?<!\.)\b_([A-Za-z]+)\b(?=\()", r"def __$1__")
        code = replace(code, r"@(redo|[Oo]ver(?:writ{1,2}e|rid{1,2}e)[sn]?|[Ee]xtends?|([Rr]e|[Nn]ot)_?[Ii]mplement(ed)?|dubara|nae_sire) {1}", "")
        code = replace(code, r"\b(static|direct) (me?th?o?d|act|fc|def)\b", "def")
        code = replace(code, r"\bme?th?o?d (\w+\()(?=\))", "def $1self")
        code = replace(code, r"\bme?th?o?d (\w+\()(?!\)|self)", "def $1self, ")
        # sequence
        code = replace(code, r"@calls?[_ ]?me\b", "@classmethod")
        code = replace(code, r"(?<!\()\bcls\b(?!\()", "class")
        # replace "cls" with "class"
        # ONLY IF the user is not working
        # on a @classmethod
        code = replace(code, r"@auto(c(?:l(?:as)?s|(?:ons)?tr)|make)\b", "@dataclass")
        # the key-value pair does not remove anything preceded by a ., so...
        code = replace(code, r"(?<=[\w\)]\.)call\b(?=\()", "__init__")
        # sequence matters
        code = replace(code, r"(?<=\bclass )(?<B>\w+) (of|from|<|ext(ends)?|is[ _]?an?)? ?(?<A>(\w+(, *)?)+)\b", "$B($A)")
        # handle (?<=cls )`A [\.>] B` cases
        code = replace(code, r"(?<=\bclass )(?<A>(\w+(, *)?)+) *[\.>] *(?<B>\w+)\b", "$B($A)")
        code = replace(code, r"\benum (?<enumclassname>\w+)", "class $enumclassname(Enum)")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}\(\)]+[\"']?)\.(?<method>replace(?:_first)?)\(", "$method($varname, ")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}]+[\"']?)\.(?:ki_?)?(len(?:gth)?|lambai|size)(?:\(\))?", "len($varname)")
        code = replace(code, r"(?<A>[\w\-\.,\[\]\"']+) (instance[ _]?of|(?:is[ _]?)an?|he[_ ]ek|(is|he|ki|has|of)?[ _]?(type|kism)(of)?) (?<B>\w+)", "isinstance($A, $B)")
        code = replace(code, r"\b(print|kaho) ([^\t\n]+)", "$1($2)")
        code = replace(code, r",? <?(might (?:throw|raise)|(throw|raise)s) [^\:\n\t]+>?(?=\:)", "")
        # ^ supposedly after a function fc x({...}?) might throw SomeError, and before a colon
        code = replace(code, r"\b(final|var|farz|n(?:a(?:ya|i)|ew)|either|yato) ", "")
        code = replace(code, r" (to|hua|k[aeio])\b", "")
        code = replace(code, r"\b(?:collect(?:ed)?|together)\((?<params>(?<firstparam>[^\(\)]+), *(?<restofparams>[^\(\)]+))\)", "list(zip($params))")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?: *: *(?<type>[\w\[\]\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?: *: *(?<type>[\w\[\]\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        # NOTE: does not support sub-dictionaries yet
        code = replace(code, r"(?<!obj\()(\{[\s\n\t]*[\"']?[\w.\-]+[\"']? *: *[^\{\}]+\})", "KL_Py.obj($1)")
        # core
        code = replace(code, r"\bf(?=__STRING_\d+__)", "")
        # sequence matters
        code = replace(code, r",(?= ?(tor|as))", "")
        # adds a sprinkle of English-like flavor: with open(x, "r") as file [bad] -> with open(x, "r"), as file [better, or at least a little more readable]
        # handling Optionality: default, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<type>[A-Za-z]\w*)\?(?!\.)", "$type|None")
        code = replace(code, r"sath (?:[\.\?]{3}|ba{1,2}ki|anja{1,2}n)(?=(?: (?:if|agar) [^\:]+)? ?\:)", "case _")
        code = replace(code, r"\bnone\b", "None")
        code = replace(code, r"(?<!\w)\?(?![\w\.])", "None")
        def __destructure_objects__(match):
            keys = [k.strip() for k in match.group(1).split(',') if k]
            keys_with_aliases: list[str] = keys.copy()
            for i, _ in enumerate(keys):
    	        keys[i] = replace(keys[i], r"tor ([A-Za-z_]\w*) ([A-Za-z_]\w*)", r"$2 as $1")
    	        if re.search(r"(?<=\w)(?:\s(?:as|tor)\s|\s?\:\s?)(?=[A-Za-z_])", keys[i]):
    		        parts = re.split(r"(?:\s(?:as|tor)\s|\s?\:\s?)", keys[i])
    		        keys[i] = parts[0]
    		        keys_with_aliases[i] = parts[1]
            obj = match.group(2)
            return ", ".join(keys_with_aliases) + " = " + ", ".join(f"{obj}?.{k}" for k in keys)
        code = replace(code, r"\{([A-Za-z][,\s\w\:]*)\}\s*=\s*([A-Za-z]\w*)", __destructure_objects__)
        # sequence should be watched
        # this comes after the destruction, to see if the destructured value even exists or not:
        code = replace(code, r"(?<object>[_A-Za-z]\w*)\?\.(?<field>[_A-Za-z]\w*)", "$object.$field if ('$object' in globals() or '$object' in locals()) and hasattr($object, '$field') and $object.$field is not None else {}")
        code = replace(code, r"\b(?:neither|nato) (?<A>[^\n\t]+) (?:or )?(?:n?or|na(?:[ _]?hi)?) (?<B>[^\n\t]+)", "not($A or $B)")
        code = replace(code, r"(?<=(?<![^ \t])[ \t])(?:is|he|kism) (?<type>[A-Za-z_]\w*)(?=\:)", "case $type()")
        for key, value in keys.items():
            code = replace(code, r"(?<!\.)\b(" + key + r"(?! ?\: ?\w+))\b", value)
        code = replace(code, r"(?<type>[A-Za-z]\w*)(?:\[\]|<list>)", "list[$type]")
        # int[] -> list[int]
        # int<list> -> list[int]
        # comes before
        code = replace(code, r"(?<!\w )(?:type|kism) ?< ?(?<type>[_A-Za-z\?]\w*) ?>", "$type")
        # SEQUENCE
        # this comes after
        code = replace(code, r"(?<=\w) (?:type|kism) ?< ?(?<type>[_A-Za-z\?]\w*) ?>", ": $type")
        # watch the sequence
        code = replace(code, r"(?<=\=) *(?:not|nahi)(?=\n)", "False")
        # relies ultimately on the positive lookahead (?= ?\=)
        # `type x=` = `x: type=`
        # needed
        code = replace(code, r"(?<type>[_A-Za-z\?][\w\[\]]*) (?<varname>[_A-Za-z]\w*) ?\={1}(?!\=)", "$varname: $type =")
        code = replace(code, r"\b(?<varname>[_A-Za-z]\w*) (expects|ume{0,2}d|chahe|wants|mange|needs) (?<type>[_A-Za-z\?]\w*)", "$varname: $type")
        # custom data types
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<typenumlist>num_?list) *\= ?(?<array>\[(\-?\d*\.?\d+(, *)?)+\])", "$varname: numlist = numlist($array)")
        # ^ specifically for numlists
        # arr: numlist = [1, 2, 3]
        # becomes ->
        # arr: numlist = numlist([1, 2, 3])
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<typeintlist>int_?list) *\= ?(?<array>\[(\-?\d*\.?\d+(, *)?)+\])", "$varname: intlist = intlist($array)")
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<typefltlist>(fl(?:oa)?t|d(?:ou)?ble?)_?list) *\= ?(?<array>\[(\-?\d*\.?\d+(, *)?)+\])", "$varname: fltlist = fltlist($array)")
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<chartype>char) *\= ?(?<data>[^, \n\t]+)", "$varname: $chartype = Char($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<strtype>str|lafz|jumla) *\= ?(?<data>[^, \n\t]+)", "$varname: $strtype = Str($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<inttype>int) *\= ?(?<data>[^, \n\t]+)", "$varname: $inttype = Int($data)")
        # much needed
        code = replace(code, r"(?<varname>[A-Za-z]\w*) *\: *(?<floattype>float|flt|double|dbl) *\= ?(?<data>[^, \n\t]+)", "$varname: float = Flt($data)")
        # Restore strings
        for j, string in old_enumerate(strings):
            code = code.replace(f"__STRING_{j}__", string)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        old_print: Callable = builtins.print
        def cust_print(*args, **kwargs):
        	if not args:
        		return
        	from pprint import pp
        	args = list(args)
        	# since tuples are immutable, we can't  work with them, we need a list
        	for i, arg in old_enumerate(args):
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
        (builtins.version, builtins.copyright, builtins.license, builtins.credits, builtins.help, builtins.enumerate, builtins.print) = ("Klang version 0.8", "© 2025, Klang corp.", "MIT", "Core developers\\\n\t~ Khurram Ali", "Not implemented yet", numbered, cust_print)
        for k in dir(platform):
        	if "python" in k:
        		delattr(platform, k)
        		#setattr(platform, replace(k, "python", "klang"), "")
        (sys.version, sys.version_info, sys.executable, sys.pycache_prefix) = (builtins.version, builtins.version, "", "")
        extended_builtins: dict[str, Any] = {"builtins": builtins, "enumerate": numbered, "print": cust_print, "range": rng, "Number": Number, "sys": sys, "platform": platform, "KL_Py": KL_Py, "__name__": "__main__"}
        # let's ALSO push every individual function from KL_Py
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
        #keywords: list[str] = find_matches(code, r"(?<!\.)[_A-Za-z]\w*(?!\")")
        #for keyword in keywords:
        	#if keyword in namespace:
        		#if isinstance(namespace[keyword], str):
        			#print("do something for me")
        		#print(f"{keyword=}, work on it")
        	
        	
# let's try, and avoid some multi-main function conflict
if hasattr(KL_Py, "main"):
	delattr(KL_Py, "main")
if "main" in globals():
	del globals()["main"]
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
class KeyNaMojudError(KeyError):
	def __int__(self, name: str, message: str = " (key) is object/class me mojud nahi"):
		self.name = name
		self.message = message
		super().__init__(name, message)
class GalatValueError(ValueError):
	def __int__(self, name: str, message: str = " ki value galat he"):
		self.name = name
		self.message = message
		super().__init__(name, message)

TEMP_FILE_DIR: str = "._temp.klang"

class Klang(cmd.Cmd):
    prompt: str = "Klang> "
    intro: str = 'Klang version 0.8\n2025 build\nType "help" or "?" for commands.'
    version: str = "v0.8"
    credits: str = "__________________[Credits]______________________\nCore developer\t\t  ~ Khurram Ali"
    # the following variable is needed for proper functioning
    NO_SUB_COMMAND: str = ""
    def do_klang(self, line) -> None:
        """The official Klang Compiler"""
        line = line.strip()
        if line:
            if re.search(r"^\-{0,2}v(?:ersion)?$", line):
                self.do_version(self.NO_SUB_COMMAND)
            elif re.search(r"^\-{0,2}(author|credits)s?$", line):
                self.do_credits(self.NO_SUB_COMMAND)
            elif re.search(r"^\-{0,2}h(?:elp)?", line):
                if re.search(r"(?<=\s)[A-Za-z]", line):
                    self.do_help(line.split(" ")[1])
                else:
                    self.do_help(self.NO_SUB_COMMAND)
            else:
            	if re.search(r"^[\"']?[\.\w]+[\"']?$", line):
            	    # compile if the line is kinda like a filename
            	    if line.startswith(('"', "'")):
            	    	line = line[1:]
            	    if line.endswith(('"', "'")):
            	    	line = line[:-1]
            	    run_process(f"python execute.py {line}")
            	else:
            		# otherwise,
            		# interpret the line
            		argument_variable: str = line
            		contents: str = ""
            		new_content: str = ""
            		lines: list[str] = []
            		if File(TEMP_FILE_DIR).exists_file():
            			with open(TEMP_FILE_DIR, "r") as temp_program_file:
            			    contents = temp_program_file.read().strip()
            			    lines = contents.split("\n")
            			    if len(lines) > 0:
            			    	for line in lines:
            			    	    if re.search(r"(print|kaho)[ \(]+", line):
            			    	        contents = replace(contents, "\n*" + re.escape(line) + "\n*", "")
            			    	        # the re.ESCAPING is mandatory, wouldn't work without it
            		if not re.search(r"(print|kaho)[ \(]+", argument_variable) and "=" not in replace(argument_variable, r"[\"'][^\"']*[\"']", "__STRING__"):
            		    argument_variable = "print " + argument_variable
            		    print(f"{argument_variable=}")
            		if not contents or "=" not in replace(contents, r"[\"'][^\"']*[\"']", "__STRING__"):
            		    new_content = "fc main():\n\t" + argument_variable
            		else:
            		    new_content = contents + "\n\t" + argument_variable
            		if os.name == "nt":
            			# hide the file on Windows
            		    # the . prefix already hides it on Unix-like platforms
            		    # including Linux, Android, and Mac
            		    HIDDEN: int = 2
            		    ctypes.windll.kernel32.SetFileAttributesW(temp_program_file.name, HIDDEN)
            		try:
            		    with open(TEMP_FILE_DIR, "w") as temp_program_file:
            		        temp_program_file.write(new_content)
            		        run_process(f"python execute.py {temp_program_file.name}", True)
            		except Exception as e:
            		    print(e)
            		Klang().cmdloop()
        else:
            print(f"Klang version 0.8\n\n{self.credits}")
    do_do = do_let = do_var = do_farz = do_set = do_kl = do_klang
    def do_print(self, line) -> None:
    	self.do_klang("print " + line)
    do_kaho = do_print
    def do_version(self, line) -> None:
        """Display the current version of Klang CLI"""
        print(self.version)
    do_v = do_version
    def do_credits(self, line) -> None:
        """Displays the author line"""
        print(self.credits)
    do_author = do_credits
    def do_clear(self, line) -> bool:
        """Clears the cache."""
        if line != "cache":
        	return
        if not File(TEMP_FILE_DIR).exists_file():
        	return
        os.remove(TEMP_FILE_DIR)
    do_cc = do_clear
    def do_quit(self, line) -> bool:
        """Closes the Klang terminal."""
        return True
    # Aliases for do_quit
    do_leave = do_exit = do_bas = do_kill = do_q = do_quit

		
def main() -> None:
    arg: str
    arg = argv[0] if len(argv) != 0 else "ttest.klang"
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
    	print("No entry point was found.\nEnter klang 'path/to/file' to compile.")
    	Klang().cmdloop()
    except SyntaxError as e:
    	args = list(e.args)
    	args[0] = replace(args[0], r"\bunterminated\b", "ger khatm shuda")
    	args[0] = replace(args[0], r"\b(?<=string)\sliteral\b", "")
    	args[0] = replace(args[0], r"\bdetected\b", "pai gai")
    	args[0] = replace(args[0], r"\bat\b", "karib")
    	msg = replace(args[0], r"expected [\"\'](?<fix>\S+)[\"\']", "\"$fix\" ki umeed thi")
    	msg = f"\n    {msg} line {e.lineno} pe"
    	if len(args) >= 2 and isinstance(args[1], tuple) and len(args[1]) >= 4:
    		msg += f"\n    karib yaha: \"\n\t {args[1][3].strip()}\n    \"            ^^^\n\t\t\t    |||"
    		msg = replace(msg, r"f(?=\-string)", "k")
    	raise BuraSyntaxError(msg) from None
    except NameError as e:
    	varname: str = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
    	msg = f"\n\tVariable \"{varname}\" is scope me mojud nahi"
    	raise VariableNaMojudError(msg) from None
    except (KeyError, AttributeError) as e:
       object: str = find_match(e.args[0], r"[\"\'](\w+)[\"\']")
       key: str = find_match(e.args[0], r"[\"\'](\w+)[\"\']$")
       msg = f"Class, ya object '{object}' me key '{key}' mojud nahi"
       raise KeyNaMojudError(msg) from None
    except ValueError as e:
    	msg = replace(e.args[0], r"\b[Ii]nvalid\b", "galat")
    	raise GalatValueError(msg) from None

if __name__ == "__main__":
    main()