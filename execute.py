import re
from numbers import Number
from typing import *
from types import *
import importlib, cmd, ctypes
import KL_Py
# ^ the import above is a MANDATORY imoort, and so is the following:
from KL_Py import *

# error classes
class BuraSyntaxError(SyntaxError):
	def __int__(self, *args):
		super().__init__(*args)
class VariableNaMojudError(NameError):
	def __int__(self, *args):
		super().__init__(*args)
class KeyNaMojudError(KeyError):
	def __int__(self, *args):
		super().__init__(*args)
class FileNaMojudError(FileNotFoundError):
	def __int__(self, *args):
		super().__init__(*args)
class LibraryError(ImportError):
	def __int__(self, *args):
		super().__init__(*args)
ModuleError = LibraryError
class LibraryNaMojudError(ModuleNotFoundError, ImportError):
	def __int__(self, *args):
		super().__init__(*args)
ModuleNaMojudError = LibraryNaMojudError
class GalatKismError(TypeError):
	def __int__(self, *args):
		super().__init__(*args)
BuraKismError = KismError = GalatKismError
class GalatValueError(ValueError):
	def __int__(self, *args):
		super().__init__(*args)
class GalatIndexError(IndexError):
	def __int__(self, *args):
		super().__init__(*args)
class DivisionError(ZeroDivisionError):
	def __int__(self, *args):
		super().__init__(*args)
		
# a helper function for def= operator
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
        "__(?:c(?:ons)?tr|bake|shurwat|build|banao)__": "__init__",
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
        "Mujhe": "Self",
        "mujhe": "self",
        r"Khud(?:[_ ]k[aeio])?": "Self",
        # diff: capital first, not-capital first
        r"khud(?:[_ ]k[aeio])?": "self",
        "my": "self",
        "super": "super()",
        "parent": "super()",
        "mom": "super()",
        "ret|out": "return",
        # math
        r"(?<=\S )div(?= \S)": "/",
        r"(?<=\S )times(?= \S)": "*",
        r"(?<=\S )tms(?= \S)": "*",
        r"(?<=\S )mul(?= \S)": "*",
        r"(?<=\S )guna(?= \S)": "*",
        r"(?<=\S )plus(?= \S)": "+",
        r"(?<=\S )pls(?= \S)": "+",
        r"(?<=\S )minus(?= \S)": "-",
        r"(?<=\S )mns(?= \S)": "-",
        # context
        "(?<=@)context": "contextmanager",
        # opening files
        r"khola(?= ?\()": "open",
        # printing
        "kaho": "print",
        # match-case
        r"aga?r[_ ]match(?= [^\n\t\:]+\:)": "match",
        r"(?<=(?<!\w) {2})sath(?! (?:open|khola) ?\()": "case",
        # same keyword, different operations
        r"sath(?= [A-Za-z_])": "with",
        # if-else
        # sequence
        "(?<!(?:but|par)[_ ])agar(?![_ ]match)": "if",
        "othe?r?ws[_ ]?if|warna?[_ ]?agar": "elif",
        r"(othe?r?ws|warna|else)(?= (?:ret(?:urn)?|out) \S)": "else:",
        # no-colon else
        # comes first
        # ^ a shorter way to say `else: ret|return|out X|Y` would be `else ret|return|out X|Y` without a colon
        r"othe?r?ws(?![_ ]?if)|warna(?![_ ]?a?gar)": "else",
        "ba{1,2}d_?me|later": "...",
        # regular else
        # leave it as-is
        "aur": "and",
        "ya": "or",
        # sequence
        r"(?<=\S )chota[_ ]ya[_ ]ba?ra?ba?r[ _]he(?= \S)": "<=",
        r"(?<=\S )bara[_ ]ya[_ ]ba?ra?ba?r[_ ]he(?= \S)": ">=",
        r"(?<=\S )(chota[_ ]he|is[_ ](?:less(?:er)?|s(?:mall|hort)er)[_ ]than)(?= \S)": "<",
        r"(bara(?![ _]ya)[_ ]he|is[_ ](?:large|bigg|great)er[_ ]than)": ">",
        r"(?<=(?<![ia])\S )(?:he )?(?:nahi[ _]?(?:he )?(?:hen?|ba?ra?ba?r(?: he)?)?|(?:is|ai)n'?t)(?= +\S+)": "!=",
        # don't escape
        # the . here is NOT a \.
        # it's a . in the sense that matches any character (or, in this case, any 2 characters)
        # sequence
        # equality_keyword=he|brbr|barabar
        r"(?<=(?<![ianh])\S )(?:(?:hen? )?(?:ba?ra?ba?r|hen?)(?: hen?)?)(?= +\S+)": "==",
        # assignment_keyword=is (as long as it's not followed by ` *(not None|type|kism| *a| *an))`
        r"(?<=\w )\b(?:is|are|be|rakho|ab)\b(?!(?: (?:not None|type|kism)| *an?))": "=",
        # sequence
        r"(?:nahi|na[_ ]mojud|kha{1,2}li|(?:is|ai)n'?t)(?= \S)": "not",
        r"kuch(?= ?\()": "any",
        r"sare(?= ?\()": "all",
        "ja?bta?k": "while",
        "har": "for",
        "every": "for",
        "andar|darmya{1,2}n": "in",
        "under": "in",
        "within": "in",
        r"until(?= ?\()": "in range",
        r"limit(?= ?\()": "range",
        r"next(?= [^\s\(])": "yield",
        r"(?<=(?<!\w) {2})ruko": "break",
        r"(?<=(?<!\w) {2})ignore(?= ?[^\(])": "continue",
        # ignore only translates to continue as long as it's indented
        # and ISN'T followed by a (
        # no messing around^
        r"baad(?= ?\()": "delay",
        r"(with_index|numbered)(?= ?\()": "enumerate",
        r"e_auto(?= ?\()": "enum.auto",
        r"kism(?= ?\()": "type",
        "func": "Callable",
        r"(?:(?:return|out)(s(?:[_ ]an?)?|[_ ]kare)|gives[ _]an?|deta[ _]ek)": "->",
        r"Shayad(?= ?\[[A-Za-z_])": "Union",
        r"is_?func(?= ?\()": "callable",
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
        "haal|filha{1,2}l": "bool",
        r"[Yy]es|[Ss]ach|[Hh]an?(?! par)|true": "True",
        r"[Nn]o|[Jj]hoot|[Nn]ahi|false": "False",
        r"k(?:lang)?__(?:name|version)": "\"Klang v0.8\"",
        r"k(?:lang)?__about": r"'\\nK    K    L             A        N     N    GGGG\\nK  K      L            A A       NN    N   G    G\\nKK        L           A   A      N N   N   G\\nK K       L          AAAAAAA     N  N  N   G  GGGG\\nK   K     L         A       A    N   N N   G     G\\nK     K   LLLLLLL  A         A   N    N    GGGGGG\\n\\n\tVersion\t|\t0.8\\n\tRel.\t|\t2025\\n__________________________________________________\\n\\nCredits:\\n\t  Core developer\\n\t\t@ KhurramAli \t\t  \\n\t\t\t\t\\n__________________________________________________'",
        # € implement help later
        r"(?:throw|uthao)(?= [A-Za-z_])": "raise",
        r"koshish(?= ?\:)": "try",
        r"(?<!(?:ar|if) )(but(?:[_ ]?if)?|(?:ha[_ ])?par(?:[_ ]agar)?|error(?: (?:by|(?:ki|ba|ka)[ _]?(?:waja|zaria|sabab)))|(?:fail(?:ure|ed)|naka{1,2}mi?)(?: (?:by|(?:ki|ba|ka)[ _]?(?:waja((?: he)? agar(?: he)?)?|zaria|sabab)))?)(?=[^\:\n\t]*\:)": "except",
        r"akhir(?= ?\:)": "finally",
        "tor(?= [A-Za-z_])": "as",
        "Error": "Exception",
    }
    with open_case_ins(filename, "r") as file:
        code: str = file.read()
        # Remove comments
        # --- since they're only meant for the developer ---
        # to help us save memory,
        # and this removal of
        # multi-line comments
        # occurs before the 
        # replacement of strings
        # with placeholders
        # remove multi-line comments
        # single-line comments will be gotten rid of later
        # FOR A BIG REASON (being settings can contains hashes --- # --- too)
        code = replace(code, "[\"\']{3}[^\"\']*[\"\']{3}", "")
        # Remove strings
        strings: list[str] = find_matches(code, r"\"[^\"]*\"") + find_matches(code, r"\'[^\'\"]*\'")
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
        	# find the template strings, and if found, for each, process it even
        	if re.search(r"\{[^\}]+\}", strings[i]):
                    templates_found_in_string: list[str] = find_matches(strings[i], r"(?<!\\)\{[^\}]+\}")
                    for templt in templates_found_in_string:
                        # {sum (is|he)} should translate to
                        # sum (is|he): {sum}
                        processed_templt: str = replace(replace(templt, r"\{(?<placeholder_slash_varname>[A-Za-z_]\w*) *(?<separator>is|he) *:? *\}", "$placeholder_slash_varname $separator: {$placeholder_slash_varname}####"), "####", "")
                        # Warning: the 4-hashes part might seem ridiculous, BUT IS A BUG FIX, and better stay untouched
                        for key, value in keys.items():
                            processed_templt = replace(processed_templt, fr"(?<!\.)\b(({key})(?! ?\: ?\w+))\b", value)
                        processed_templt = replace(processed_templt, r"(?<=\w )=(?=:)", "is")
                        strings[i] = replace(strings[i], templt, processed_templt)
                        strings[i] = replace(strings[i], r"(?<=\S\.)\b_cl(?:as)?s_?name\b", "__class__.__name__")
                        strings[i] = replace(strings[i], r"(?<=\S\.)\b_cl(?:as)?s\b", "__class__")
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
        escaped_keywords: list[str] = find_matches(code, r"`(?:\w+ *)+`")
        for i, escaped_keyword in old_enumerate(escaped_keywords):
        	code = code.replace(escaped_keywords[i], f"__ESCAPED_KEYWORD_{i}__")
        FOUR_WHITES: str = " " * 4
        # NOTE: now that strings have been gotten rid of entirely
        # --- i.e. multi-line comments ("""{content}""") have been replaced with "" {that is, removed}, and base strings ("") have been replaced with
        # their placeholders
        # so that we only translate keywords outside of a string, or a multi-line comment
        # we might as well get rid of single-line comments
        # which, we DIDN'T BEFORE...
        # AS STRINGS CAN CONTAIN
        # hashes (#'s') TOO
        code = replace(code, r"#[^\n]+", "")
        code = replace(code, "\t", FOUR_WHITES)
        code = replace(code, r"\b(?:surat|tor) (?<alias>[A-Za-z_]\w*) mangao (?<function>[A-Za-z_]\w*) (?<module>[A-Za-z\.][\w\.]*) (?:me)?[_ ]?se\b", "from $module import $function as $alias")
        # ^ example of usage:
        #     | tor DF mangao DataFrame pandas mese
        code = replace(code, r"(?<module>[A-Za-z\.][\w\.]*) (?:me)?[_ ]?se mangao (?<functions>(?:[A-Za-z]\w*(?:, )?)+\b|\*)", "from $module import $functions")
        # ^ example of usage:
        #     | pandas mese mangao DataFrame, read_csv
        code = replace(code, r"\bmangao (?<functions>(?:[A-Za-z]\w*(?:, )?)+) (?<module>[A-Za-z\.][\w\.]*) (?:me)?[_ ]?se\b", "from $module import $functions")
        # ^ example of usage:
        #     | mangao DataFrame, read_csv pandas mese
        # look similar, but are different
        code = replace(code, r"\b(?:tor|surat) (?<alias>[A-Za-z_]\w*) mangao (?<module>[A-Za-z\.][\w\.]*) ?(?:[\[\:]|->) ?(?<function>(?:[A-Za-z_]\w*(?:, )?)+)\b\]?", "from $module import $function as $alias")
        # ^ example of usage:
        #     | tor DF mangao pandas[DataFrame]
        code = replace(code, r"\bmangao (?<module>[A-Za-z\.][\w\.]*) ?(?:[\[\:]|->) ?(?<functions>(?:[A-Za-z_]\w*(?:, )?)+)\b\]?", "from $module import $functions")
        # ^ example of usage:
        #     | mangao pandas[DataFrame]
        code = replace(code, r"\b(?:surat|tor) (?<alias>[A-Za-z_]\w*) mangao (?<module>[A-Za-z\.][\w\.]*)\b", "import $module as $alias")
        # ^ example of usage:
        #     | tor pd mangao pandas
        # comes after\/
        code = replace(code, r"\bmangao (?<module>[A-Za-z\.][\w\.]*)\b", "import $module")
        # ^ example of usage:
        #    | mangao pandas
        # sequence matters!
        # post processing module syntax
        # which NOW HAS KEYWORD IMPORT instead of mangao
        code = replace(code, r"\b(?<=import )sab[_ ]kuch\b", "*")
        code = replace(code, r"(?<=,) (?:a(nd|ur)|ya|(?:ke[_ ]?)?sath(me)?)\b", "")
        # sequence matters!
        code = replace(code, r"(?<![\t    \t])\b(?:fc|act|def) (?:main|start)(?:\([^\)\n\t]*\))?(?=(?: *-> *[\w\?]+)?\:)", "def main()")
        # operators
        # try..else
        code = replace(code, r"\b(?:try|koshish) (?<x>[^\n]+) (?:else|warna|naka{1,2}mi(?: p(e|ar))?) (?<y>[^\n]+)\b", "try_else(() -> $x, $y)")
        # NULL coalescing
        code = replace(code, r"(?<A>[_A-Za-z]\w*) ?\?\?\= ?(?<B>[^\n\t]+)", "$A = $A if ('$A' in globals() or '$A' in locals()) and $A is not None else $B")
        # the ifCONDITION(is true, then)=
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:if|agar) ?(?<condition>[^\=\n\t]+)\= ?(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or $A == $condition else $A")
        # the min= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) min *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if ('$A' in globals() or '$A' in locals()) and (isinstance($A, (int, float)) and $A < $B) else 0 if ('$A' in globals() or '$A' in locals()) and (not isinstance($A, (int, float))) else $A")
        # the max= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) max *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if ('$A' in globals() or '$A' in locals()) and (isinstance($A, (int, float)) and $A > $B) else 0 if ('$A' in globals() or '$A' in locals()) and (not isinstance($A, (int, float))) else $A")
        # the (def|fb)= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:def|fb|othe?r?ws) *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or not $A or type($A) != type($B) else $A")
        code = replace(code, r"(?<![\d]|(?<!,) )\.{3} ?(?<dict>[_A-Za-z]\w*)", "**$dict")
        # sequence
        code = replace(code, r"(?<![\.\d]|(?<!,) )\.{2} ?(?<list>[_A-Za-z]\w*)", "*$list")
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^ *(?<B>\-?\d*\.?\d+)", "$A**$B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{3}", "$A**3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{2}", "$A**2")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) \%(?! *[\-\.\d])", "$A/100")
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
        code = replace(code, r"(?<=[A-Za-z_]) ?(\.\.(?!\.)) ?(?=[^\:]+\:)", " in ")
        # comes before\/
        code = replace(code, r"(?<n1>\-?\d*\.?\d+) ?(?:\.\.|se) ?(?<n2>\-?\d*\.?\d+)", "range($n1, $n2)")
        # comes after\/
        code = replace(code, r"(?<![\d\.])(?:\.\. ?(?<n>\-?\d*\.?\d+))", "range($n)")
        # KEEP the sequence
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
        code = replace(code, r"(?<!\w)\((?<params>(?:[A-Za-z_]\w*(?:, *)?)*)\) ?\->(?= ?\S)", "lambda $params:")
        # the actual support for `x ->` 
        code = replace(code, r"\b(?:fc|act) (?<param>[A-Za-z_]\w*)(?=\: ?[^\n]{2,})", "lambda $param")
        # helps drop the parentheses if the function doesn't allow parameters
        # fc log: -> fc log():
        code = replace(code, r"\b(?:fc|act) (?<funcname_followed_not_by_parens>[A-Za-z_]\w*)(?=(?<could_have_a_return_type>[^\(\)\:]+)?\:)", "def $funcname_followed_not_by_parens()")
        code = replace(code, r"\b(?:fc|act) (?<funcname_regular>[A-Za-z_]\w*)\((?<params>[^\)]+)?\)(?=(?<could_have_a_return_type>[^\:]+)?\:)", "def $funcname_regular($params)")
        code = replace(code, r"@(redo|[Oo]ver(?:writ{1,2}e|rid{1,2}e)[sn]?|[Ee]xtends?|([Rr]e|[Nn]ot)_?[Ii]mplement(ed)?|dubara|nae_sire) ", "")
        # sequence matters
        # _str, _eq -> __str__, __eq__
        # comes first
        # this one handles calling of dunder methods
        # in a conciser way:
        # e.g. (?<= )._str() -> self.__str__()
        # \/
        code = replace(code, r"(?<= )\._([A-Za-z]+)\b(?=\()", "self.__$1__")
        # these two are distinct
        # this one handles calling of non-dunder methods
        # in a conciser way:
        # e.g. (?<= ).method() -> self.method()
        # \/
        code = replace(code, r"(?<= )\.([A-Za-z]\w*)\b(?=\()", "self.$1")
        # sequence
        code = replace(code, r"(?<=\w\.)_([A-Za-z]\w*)\b(?=\()", r"__$1__")
        # sequence
        code = replace(code, r"(?<=(?<!\w) {4})\b_([A-Za-z]+)\b\((?=[^\)]*\)[^\:]*\:)", r"def __$1__(self, ")
        # reminder: look behinds in Python are supposed to have fixed width!
        code = replace(code, r"\b(static|direct) (me?th?o?d|act|fc|def)\b", "def")
        code = replace(code, r"\bme?th?o?d (\w+\()(?=\))", "def $1self")
        code = replace(code, r"\bme?th?o?d (\w+\()(?!\)|self)", "def $1self, ")
        # sequence
        code = replace(code, r"\b(?:interface|rule|instruct(?:ion)?|(?:base|abstract) cl(?:as)?s) (?<abstractclassname>\w+)", "class $abstractclassname(metaclass=AbstractBaseClassMeta)")
        # "metaclass" is a keyword argument for the base class
        # to avoid conflict
        # comes before ^
        # comes after \/
        code = replace(code, r"(?<!\()\bcls\b(?![\(\.])", "class")
        # replace "cls" with "class"
        # to make the future replacements
        # easier
        # also, replace "cls" with "class"
        # ONLY IF the user is not working
        # on a @classmethod
        # to avoid conflict
        code = replace(code, r"(?<=\S\.)\b_cl(?:as)?s_?name\b", "__class__.__name__")
        code = replace(code, r"(?<=\S\.)\b_cl(?:as)?s\b", "__class__")
        code = replace(code, r"@calls?[_ ]?me\b", "@classmethod")
        code = replace(code, r"@(?:abstr(?:act)?|follow|emp?ty?_?body)\b", "@abstractmethod")
        code = replace(code, r"@auto(c(?:l(?:as)?s|(?:ons)?tr)|make)\b", "@dataclass")
        # the key-value pair does not remove anything preceded by a ., so...
        code = replace(code, r"(?<=[\w\)]\.)call\b(?=\()", "__init__")
        # sequence matters
        # \/ handle (?<=(?:cls|class) )`B (of|from|>|ext(ends)?|is_?an?) A` cases
        code = replace(code, r"(?<=\bclass )(?<B>\w+)(?: (?:of|from|ext(?:ends)?|impl(?:em(?:ents)?)?|follows|is[ _]?an?) | ?[>\/] ?)(?<A>(?:\w+(?:, *)?)+)\b", "$B($A)")
        # \/ handle (?<=(?:cls|class) )`A [\.>] B` cases
        code = replace(code, r"(?<=\bclass )(?<A>(?:\w+(?:, *)?)+) (?:produces?|peda karen?|jana?m den?) (?<B>\w+)(?: ko)?\b", "$B($A)")
        code = replace(code, r"\benum (?<enumclassname>\w+)", "class $enumclassname(Enum)")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}\(\)]+[\"']?)\.(?<method>replace(?:_first)?)\(", "$method($varname, ")
        code = replace(code, r"(?<varname>[\"']?[\w\-\.,\[\]\{\}]+[\"']?)\.(?:ki_?)?(len(?:gth)?|lambai|size)(?:\(\))?", "len($varname)")
        # don't change this\/
        # the ^\n part stays as-is
        code = replace(code, r"(?<A>[\-\.\w,\"'\[\]]+) (?:instance[ _]?of|(?:is[ _]?)an?|he[_ ]ek|(?:is|he|ki|has|of)?[ _]?(?:type|kism)(?:of)?) (?<B>\w+)", "isinstance($A, $B)")
        code = replace(code, r"\b(print|kaho) ([^\t\n]+)", "$1($2)")
        code = replace(code, r",? <?(?:(?:might|shayad) (?:throw|raise|de|uthae)|(?:throw|raise)s|uthae) [^\:\n\t]+>?(?=\:)", "")
        # ^ supposedly after a function fc x({...}?) might throw SomeError, and before a colon
        code = replace(code, r"\b(?:final|let|var|farz|n(?:a(?:ya|i)|ew)|either|yato) ", "")
        code = replace(code, r"\b(?<=\w )(?:present|mojud) (?=\S)", "")
        code = replace(code, r" (?:se(?! ?[\-\.\d])|to|tak|hua|k[aeio](?:[_ ]?lie)?)\b", "")
        code = replace(code, r"\b(?:collect(?:ed)?|together)\((?<params>(?<firstparam>[^\(\)]+), *(?<restofparams>[^\(\)]+))\)", "collect($params)" if "collect" in {**globals(), **locals()} and callable({**globals(), **locals()}["collect"]) else "list(zip($params))")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?: *: *(?<type>[\w\[\]\<\>\?\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?: *: *(?<type>[\w\[\]\<\>\?\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        # NOTE: does not support sub-dictionaries yet
        code = replace(code, r"(?<!obj\()(\{[ \n\t]*[\"']?[\w.\-]+[\"']? *: *[^\{\}]+\})", "KL_Py.obj($1)")
        # core
        code = replace(code, r"\bf(?=__STRING_\d+__)", "")
        # sequence matters
        code = replace(code, r",(?= ?(tor|as))", "")
        # adds a sprinkle of English-like flavor: with open(x, "r") as file [bad] -> with open(x, "r"), as file [better, or at least a little more readable]
        # handling Optionality: default, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<=\S )\bkwarg\b", "= None")
        # DON'T edit
        code = replace(code, r"(?<type>[A-Za-z]\w*)(?:\?| \boptional\b)(?!\.)", "$type|None")
        code = replace(code, r"(?<=(?<!\w) {2})sath (?:[\.\?]{3}|ba{1,2}ki|anja{1,2}n)(?=(?: (?:if|agar) [^\:]+)? ?\:)", "case _")
        code = replace(code, r"\b(?:none|koi_na)\b", "None")
        code = replace(code, r"(?<!\w)\?(?![\w\.])", "None")
        code = replace(code, r"\{(?:\.{3}|\*{1,2})\} *= *(?<obj>[A-Za-z]\w*)", "globals().update(**$obj)")
        def __destructure_objects__(match):
            keys = [k.strip() for k in match.group(1).split(',') if k]
            keys_with_aliases: list[str] = keys.copy()
            for i, _ in old_enumerate(keys):
    	        keys[i] = replace(keys[i], r"tor ([A-Za-z_]\w*) ([A-Za-z_]\w*)", r"$2 as $1")
    	        if re.search(r"(?<=\w)(?: (?:as|tor) | ?\: ?)(?=[A-Za-z_])", keys[i]):
    		        parts = split(keys[i], r"(?: (?:as|tor) | ?\: ?)")
    		        keys[i] = parts[0]
    		        keys_with_aliases[i] = parts[1]
    	        if keys_with_aliases[i].startswith("...") and len(keys_with_aliases[i]) > 3:
    	        	keys_with_aliases[i] = f"**{keys[i][3:]}"
    	        if keys_with_aliases[i].startswith("**"):
    	            keys[i] = keys[i].lstrip("**")
    	            keys_with_aliases[i] = keys_with_aliases[i].lstrip("**")
            obj: str = match.group(2)
            lhs: str = ", ".join(keys_with_aliases)
            rhs: str = ", ".join(f"{obj}?.{k}" if k not in ("keys", "values", "items") else (f"{obj}.{k}() if '{obj}' in " + "{**globals(), **locals()}" + f" and isinstance({obj}, dict) else " + "{}") for k in keys)
            rhs = replace(rhs, r"([A-Za-z_]\w*\.items\(\))", "[list(tuple) for tuple in list($1)]")
            new_pair: str = lhs + " = " + rhs
            return new_pair
        code = replace(code, r"\{([A-Za-z\*][, \w\*\:]*)\} *= *([A-Za-z]\w*)", __destructure_objects__)
        # sequence should be watched
        # this comes after the destruction, to see if the destructured value even exists or not:
        code = replace(code, r"(?<object>[_A-Za-z]\w*)\?\.(?<field>[_A-Za-z]\w*)", "$object.$field if ('$object' in globals() or '$object' in locals()) and hasattr($object, '$field') and $object.$field is not None else {}")
        code = replace(code, r"\b(?:neither|nato) (?<A>[^\n\t]+) (?:or )?(?:n?or|na(?:[ _]?hi)?) (?<B>[^\n\t]+)", "not($A or $B)")
        code = replace(code, r"(?<=(?<![^ \t])[ \t])(?:is|he|kism) (?<type>[A-Za-z_]\w*)(?=\:)", "case $type()")
        # KEY-VALUE replacement
        for key, value in keys.items():
            code = replace(code, r"(?<!\.)\b(" + key + r"(?! ?\: ?\w+))\b", value)
        code = replace(code, r"(?<type>[A-Za-z]\w*)(?:\[\]|<list>)", "list[$type]")
        # int[] -> list[int]
        # int<list> -> list[int]
        # comes before
        code = replace(code, r"(?<!\w )(?:type|kism) ?< ?(?<type>[_A-Za-z\?][\w\<\>\[\]\?]*) ?>", "$type")
        # SEQUENCE
        # this comes after
        code = replace(code, r"(?<=\w) (?:type|kism) ?< ?(?<type>[_A-Za-z\?][\w\<\>\[\]\?]*) ?>", ": $type")
        # watch the sequence
        code = replace(code, r"(?<=\=) *(?:not|nahi)(?=\n)", "False")
        # relies ultimately on the positive lookahead (?= ?\=)
        # `type x=` = `x: type=`
        # needed
        code = replace(code, r"(?<type>[_A-Za-z\?][\w\<\>\[\]\?]*) (?<varname>[_A-Za-z]\w*) ?\={1}(?!\=)", "$varname: $type =")
        code = replace(code, r"\b(?<varname>[_A-Za-z]\w*) (expects|ume{0,2}d|chahe|wants|mange|needs) (?<type>[_A-Za-z\?][\w\<\>\[\]\?]*)", "$varname: $type")
        # readable index access
        code = replace(code, r"\[\.first\:?(?<n>\d+)\]", "[0:$n]")
        # ^ e.g. "hello world"[.first4] -> "hell"
        code = replace(code, r"\[\.last\:?(?<n>\d+)\]", "[-$n:]")
        # ^ e.g. "hello world"[.last:?4] -> "orld"
        code = replace(code, r"\[\.(?:fir|1)st\]", "[0]")
        # ^ e.g. "hello world"[.1st] -> "h"
        code = replace(code, r"\[\.(?:seco|2)nd\]", "[1]")
        # ^ e.g. "hello world"[.second] -> "e"
        code = replace(code, r"\[\.(?:thi|3)rd\]", "[2]")
        # ^ e.g. "hello world"[.third] -> "l"
        code = replace(code, r"\[\.(?<n>\d+)th\]", "[$n-1]")
        # ^ e.g. "hello world"[.third] -> "l"
        code = replace(code, r"\[\.(?:sec(?:ond)?|2nd)la?st\]", "[-2]")
        # ^ e.g. "hello world"[.secondlast] -> "s"
        code = replace(code, r"\[\.last\]", "[-1]")
        # e.g. ^ "hello world"[.last] -> "d"
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
        # Restore escaped keywords
        for j, escaped_keyword in old_enumerate(escaped_keywords):
        	escaped_keyword = escaped_keyword[1:-1]
        	code = code.replace(f"__ESCAPED_KEYWORD_{j}__", escaped_keyword)
        print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        old_print: Callable = builtins.print
        def cust_print(*args, **kwargs):
        	args = list(args)
        	# since tuples are immutable, we can't  work with them, we need a list
        	for i, arg in old_enumerate(args):
        		if arg is None:
        			args[i] = "koi_na"
        		elif is_int(arg):
        			args[i] = fpk(arg)
        		elif is_flt(arg):
        			args[i] = fpk(arg)
        		elif is_bool(arg):
        			args[i] = "Han" if arg == True else "Nahi"
        	old_print(*args, **kwargs)
        	# if args is empty, prints a line break
        (builtins.version, builtins.copyright, builtins.license, builtins.credits, builtins.help, builtins.enumerate, builtins.print) = ("Klang version 0.8", "© 2025, Klang corp.", "MIT", "Core developers\\\n\t~ Khurram Ali", "Not implemented yet", numbered, cust_print)
        for k in dir(platform):
        	if "python" in k:
        		delattr(platform, k)
        		#setattr(platform, replace(k, "python", "klang"), "")
        (sys.version, sys.version_info, sys.executable, sys.pycache_prefix) = (builtins.version, builtins.version, "", "")
        __error_classes__: dict[str, Any] = {
            "BuraSyntaxError": BuraSyntaxError,
            "VariableNaMojudError": VariableNaMojudError,
            "KeyNaMojudError": KeyNaMojudError,
            "FileNaMojudError": FileNaMojudError,
            "LibraryError": LibraryError,
            "ModuleError": ModuleError,
            "LibraryNaMojudError": LibraryNaMojudError,
            "ModuleNaMojudError": ModuleNaMojudError,
            "GalatKismError": GalatKismError,
            "BuraKismError": BuraKismError,
            "KismError": KismError,
            "GalatValueError": GalatValueError,
            "GalatIndexError": GalatIndexError,
            "DivisionError": DivisionError,
        }
        extended_builtins: dict[str, Any] = {"builtins": builtins, "enumerate": numbered, "print": cust_print, "range": rng, "Number": Number, "sys": sys, "platform": platform, "KL_Py": KL_Py, **__error_classes__, "__name__": "__main__"}
        # let's ALSO push every individual function from KL_Py
        add_module("KL_Py", extended_builtins)
        import hindGui
        add_module("hindGui", extended_builtins)
        namespace: dict[str, Any] = extended_builtins | {}
        namespace["argv"] = argv[1:] if len(argv) > 0 else []
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

TEMP_FILE_DIR: str = "._temp.klang"

class Klang(cmd.Cmd):
    prompt: str = "Klang> "
    intro: str = 'Klang version 0.8\n2025 build\nType "help" or "?" for commands.'
    version: str = "v0.8"
    credits: str = "__________________[Credits]______________________\nCore developer\t\t  ~ Khurram Ali"
    # the following variable is needed for proper functioning
    NO_SUB_COMMAND: str = ""
    def do_klang(self, line) -> None:
        """
    	\t:: the official Klang compiler
    	\t.: compiles the code, if the command is found to be a
    	\t   valid filename. 
    	\t   Otherwise, interprets it.
    	"""
        line = line.strip()
        if line:
            if re.search(r"^\-*v(?:ersion)?$", line):
                self.do_version(self.NO_SUB_COMMAND)
            elif re.search(r"^\-*(?:author|credits)s?$", line):
                self.do_credits(self.NO_SUB_COMMAND)
            elif re.search(r"^\-*about$", line):
                self.do_about(self.NO_SUB_COMMAND)
            elif re.search(r"^\-*h(?:elp)?", line):
                if re.search(r"(?<= )[A-Za-z]", line):
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
            		    #print(f"{argument_variable=}")
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
            print(f"Klang version 0.8\n{self.credits}")
    do_do = do_let = do_var = do_farz = do_set = do_kl = do_klang
    def do_print(self, line) -> None:
    	"""
    	:: prints the data (in its stringified form) to the console.
    	.: the handling of how an object is displayed\nis customizable by putting an _str method in its origin class
    	"""
    	self.do_klang("print " + line)
    def do_kaho(self, line) -> None:
    	"""
    	:: data stringify karke, console par dikhaata he
    	.: ek object kis tara zaahir hoga, is ka fesla\n\t   karta he object ki origin class ke andar mojud\n\t   _str method, agar mojud hua, warna object ka class name,\n\t   or memory address zaahir kie jaege
    	"""
    	self.do_print(line)
    def do_version(self, line) -> None:
        """Display the current version of Klang CLI"""
        print(self.version)
    do_v = do_version
    def do_credits(self, line) -> None:
        """Displays the authors"""
        print(self.credits)
    do_authors = do_author = do_credits
    def do_clear(self, line) -> bool:
        """Clears the cache if the line reads 'cache',
        \totherwise clears the screen."""
        console_clear_command: str
        if os.name == "nt":
        	# if Windows
        	console_clear_command = "cls"
        else:
        	# but if probably Unix (including Linux, Android, and Mac)
        	console_clear_command = "clear"
        if not line:
        	os.system(console_clear_command)
        	Klang().cmdloop()
        	return
        if not File(TEMP_FILE_DIR).exists_file():
        	return
        os.remove(TEMP_FILE_DIR)
    do_cc = do_cls = do_clear
    def do_about(self, _):
    	"""provides information about the compiler"""
    	self.do_print("k__about")
    def do_quit(self, line) -> bool:
        """\t    :: Closes the Klang terminal"""
        return True
    # Aliases for do_quit
    do_leave = do_close = do_exit = do_bas = do_kill = do_q = do_quit

		
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
    except FileNotFoundError as e:
    	error: str = e.args[0]
    	error = replace(error, r"\bdoesn't exist\b", "mojud nahi")
    	malfunctioning_file: str = find_match(error, "(?<=\')[^\']*(?=\')") or e.filename
    	if malfunctioning_file != "main.klang":
    		raise FileNaMojudError(f"File `{malfunctioning_file}' is directory '{KL_Py._dir}' me mojud nahi") from None
    	else:
    		print(f"Entry point mojud na thi.\nKisi bhi Klang program ko compile karne ke lie 'klang file/ki/path' likhen. {error}")
    		Klang().cmdloop()
    except SyntaxError as e:
    	args = list(e.args)
    	args[0] = replace(args[0], r"\bunterminated\b", "ger khatm shuda")
    	args[0] = replace(args[0], r"\b(?<=string) literal\b", "")
    	args[0] = replace(args[0], r"\bdetected\b", "pai gai")
    	args[0] = replace(args[0], r"\bat\b", "karib")
    	msg = replace(args[0], r"expected [\"\'](?<fix>\S+)[\"\']", "\"$fix\" ki umeed thi")
    	msg = f"\n    {msg} line {e.lineno} pe"
    	if len(args) >= 2 and isinstance(args[1], tuple) and len(args[1]) >= 4:
    		msg += f"\n    karib yaha: \"\n\t {args[1][3].strip()}\n    \"                       ^^^\n\t\t\t    |||"
    		msg = replace(msg, r"\bf(?=\-string)\b", "k")
    		msg = replace(msg, r"\bexpecting\b", "umeed thi")
    		msg = replace(msg, r"\bor\b", "ya")
    		msg = replace(msg, r"\band\b", "aur")
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
    except ImportError as e:
    	msg: str = e.args[0]
    	if isinstance(e, ModuleNotFoundError):
    	    msg = replace(msg, r"\bNo module named (?<module>\'\w*\')", "$module naam ki koi library mojud nahi")
    	    raise LibraryNaMojudError(msg) from None
    	if " (" in msg:
    		msg = msg.split(" (")[0]
    	msg = replace(msg, r"\bcannot import name (?<item>\'\w*\') from (?<module>\'\w*\')", "Library $module ke andar $item naam ka koi item mojud nahi")
    	raise LibraryError(msg) from None
    except TypeError as e:
    	msg = e.args[0]
    	msg = replace(msg, r"\bmust be( an?)?\b", "hona/i chahie tha/i ek")
    	msg = replace(msg, r"(?<=\w, )an?\b", "ya ek")
    	msg = replace(msg, r"(?<=\S) or an?\b", ", ya ek")
    	msg = replace(msg, r"(?<=\S) and an?\b", ", aur ek")
    	msg = replace(msg, r"(?<=\S, )not\b(?= \S)", "naake ek")
    	raise KismError(msg) from None
    except ValueError as e:
    	msg = replace(e.args[0], r"\b[Ii]nvalid\b", "galat")
    	raise GalatValueError(msg) from None
    except IndexError:
    	msg = "Index string, tuple, ya list ki range se baahir he, or kuch zyada hi chota, ya bara he"
    	raise GalatIndexError(msg) from None
    except ZeroDivisionError as e:
    	msg = "Kisi bhi number ko 0 se divide nahi kia jasakta"
    	raise DivisionError(msg) from None

if __name__ == "__main__":
    main()