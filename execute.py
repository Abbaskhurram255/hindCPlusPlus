import re
from numbers import Number
from typing import *
from types import *
import importlib, cmd, ctypes, stat
import KL_Py
# ^ the import above is a MANDATORY imoort, and so is the following:
from KL_Py import *

# set the title of the command line interface
__app__: dict[str, str] = {
    "name": "Klang",
    "version": "v0.8"
}
__window_title__: str = f"{__app__['name']} {__app__['version']}"
if os.name == "nt":
    ctypes.windll.kernel32.SetConsoleTitleW(__window_title__)
else:
    # Linux/Posix/ANSI escape sequence
    sys.stdout.write(f"\x1b]2;{__window_title__}\x07")
    sys.stdout.flush()
TRANSLATION_FILE_DIR: str = to_path(".__translated__.py")

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
	
def __join_into_words_version_2__(lst: list = []) -> str:
	"""
	this is a scope-only variant
	of function joined_words
	(from KL_Py)
	only meant for the local scope
	of cust_print
	"""
	result: list[str] = []
	was_a_tuple: bool = False
	if isinstance(lst, tuple):
		was_a_tuple = True
		lst = list(lst)
	if not isinstance(lst, list):
		lst = []
	for arg in lst:
		if isinstance(arg, (list, tuple)):
			arg = __join_into_words_version_2__(arg)
			arg = re.sub(r"(?<=, )aur (?=.+$)", "", str(arg))
		was_a_str: bool = False
		if isinstance(arg, str):
			was_a_str: bool = True
		if isinstance(arg, float):
			arg = round(arg, 1)
		if isinstance(arg, bool):
			arg = "Han" if arg else "Nahi"
		arg = str(arg)
		if ", " in arg:
			sublst: list[str] = arg.split(", ")
			for subarg in sublst:
				result.append(subarg)
			continue
		if was_a_str:
			arg = f"'{arg}'"
		if str(arg) == "None":
			# doing this later so that
			# koi_na is written as-is
			# and doesn't get mistakenly stringified
			# adding an if-arg-is-None check right at the beginning of the loop, and setting arg to "koi_na" right there, if it is,
			# will only result in
			# an stringified "\'koi_na\'"
			# not what we're after
			# since koi_na is
			# more than that,
			# it's a keyword
			arg = "koi_na"
		result.append(arg)
	signs: list[str]|tuple[str] = ["[", "]"]
	if was_a_tuple:
		signs[0], signs[1] = "(", ")"
	if len(result) < 2:
		return f"{signs[0]}{', '.join(result)}{signs[1]}"
	last: str = str(result.pop())
	return signs[0] + (", ".join(result) + ", aur " + last) + signs[1]

def add_module(module_name: str, namespace: dict) -> None:
	module = importlib.import_module(module_name)
	for name in dir(module):
		if name.startswith("__"):
		    continue
		namespace[name] = getattr(module, name)
# let's try, and avoid some multi-main function conflict
if hasattr(KL_Py, "main"):
	delattr(KL_Py, "main")
if "main" in globals():
	del globals()["main"]
# if a main function (FROM another module got leaked through), delete it
#declare a new main for this file
sys.tracebacklimit=0
# we need this to minimize the stack trace, and to ADD EMPHASIS on the actual problem
		
def execute(filename: str) -> None:
    keys: dict[str, str] = {
        # functions, and classes
        "__(?:c(?:ons)?tr|bake|shurwat|build|banao)__": "__init__",
        "__devview__": "__repr__",
       "__print__": "__str__",
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
        "(?<!(?:but|par)[_ ])(?:agar|tab[_ ]jab)(?![_ ]match)": "if",
        "othe?r?ws[_ ]?if|warna?[_ ]?agar": "elif",
        r"(othe?r?ws|warna|else)(?= (?:ret(?:urn)?|out) \S)": "else:",
        # no-colon else
        # comes first
        # ^ a shorter way to say `else: ret|return|out X|Y` would be `else ret|return|out X|Y` without a colon
        r"othe?r?ws(?![_ ]?if)|warna(?![_ ]?a?gar)": "else",
        "ba{1,2}d_?me|later": "...",
        # regular else
        # leave it as-is
        # sequence
        r"(?<=\S )\bchot[aei][_ ]ya[_ ]ba?ra?ba?r(?:[ _]hen?)?\b(?= \S)": "<=",
        r"(?<=\S )\bbar[aei][_ ]ya[_ ]ba?ra?ba?r(?:[ _]hen?)?(?= \S)": ">=",
        r"(?<=\S )\b(chot[aei](?:[_ ]hen?)?|is[_ ](?:less(?:er)?|s(?:mall|hort)er)[_ ]than)\b(?= \S)": "<",
        r"(?<=\S )\b(bar[aei](?![ _]ya)(?:[ _]hen?)?|is[_ ](?:large|bigg|great)er[_ ]than)\b(?= \S)": ">",
        r"(?<=(?<![ia])\S )(?:nahi[ _]?(?:hen? )?(?:hen?|ba?ra?ba?r(?: hen?)?)?|(?:is|ai)n'?t)(?= +\S)": "!=",
        # don't escape
        # the . here is NOT a \.
        # it's a . in the sense that matches any character (or, in this case, any 2 characters)
        # sequence
        # equality_keyword=he|brbr|barabar
        r"(?<=(?<![ianh])\S )(?:(?:hen? )?(?:ba?ra?ba?r|hen?)(?: hen?)?)(?= +\S)": "==",
        # assignment_keyword=is (as long as it's not followed by ` *(not None|type|kism| *a| *an))`
        r"(?<=\S )\b(?:is|are|be|rakh[aeio]|ab)\b(?!(?: (?:not None|type|kism)| *an?))": "=",
        # sequence
        r"aur(?= +\S)": "and",
        r"ya(?= +\S)": "or",
        r"(?:nahi|na[_ ]mojud|kha{1,2}li|(?:is|ai)n'?t)(?= \S)": "not",
        r"kuch(?= ?\()": "any",
        r"sa{1,2}re(?= ?\()": "all",
        "ja?bta?k": "while",
        "har": "for",
        "every": "for",
        r"(?<=\S )(?:andar|(?:with)?in|under|darmya{1,2}n)(?= \S)": " in ",
        # tests needed, but keep the " in " as-is
        r"until(?= ?\()": "in range",
        r"(?:limit|darmya{1,2}n|b(?:et)?w(?:een)?)(?= *\()": "range",
        r"next(?= [^ \(])": "yield",
        r"(?<=(?<!\w) {2})ruko": "break",
        r"(?<=(?<!\w) {2})ignore(?= ?[^\(])": "continue",
        # ignore only translates to continue as long as it's indented
        # and ISN'T followed by a (
        # no messing around^
        r"baad(?= ?\()": "delay",
        r"(with_index|numbered)(?= ?\()": "enumer",
        r"e_auto(?= ?\()": "enum.auto",
        r"kism(?= ?\()": "type",
        "func": "Callable",
        r"(?:(?:return|out)(s(?:[_ ]an?)?|[_ ]kare)|gives[ _]an?|deta[ _]ek)": "->",
        r"Shayad(?= ?\[[A-Za-z_])": "Union",
        r"is_?func(?= ?\()": "callable",
        r"(?<=\:) ?char|char(?= ?[\(])": "Char",
        # * both sides are needed
        # ^^ much needed
        # char is the keyword user
        # will look for
        # when they would
        # actually mean Char
        # with a capital C
        # (i.e. the class 'Char' from KL_Py)
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
        r"koshish(?: karo)?(?= ?\:)": "try",
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
        multi_line_comments: list[str] = re.findall(r"[\"\']{3}[\s\S]*?[\"\']{3}", code)
        # *? is used for LAZY match (matching only one match at a time)
        # it's better if you DO NOT TOUCH THE REGEX
        for multi_line_comment in multi_line_comments:
            unprocessed_multi_line_comment: str = multi_line_comment
            # storing the original comment for later
            processed_multi_line_comment: str = multi_line_comment[3:-3]
            processed_multi_line_comment = re.sub("\n[^\n]*", "\n", processed_multi_line_comment)
            code = code.replace(unprocessed_multi_line_comment, processed_multi_line_comment)
        # Remove strings (actual strings, now that multi-line comments are GONE)
        strings: list[str] = find_matches(code, r"\"[^\"]*\"") + find_matches(code, r"\'[^\'\"]*\'")
        # added partial support for ''
        for i, string in old_enumerate(strings):
        	strings[i] = strings[i][1:-1]
        	if len(strings[i]) == 1:
        		# let characters pass through
        		# to allow working with
        		# character ranges
        		continue
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
                        # readable index access
                        strings[i] = replace(strings[i], r"\[\.?(?:(?:f(?:ir)?st|pehle)(?:[_ ]ke)?|shuru?(?:[_ ][smk]e|wa{1,2}ti)) *[\: ] *(?<n>\d+)\]", "[0:$n]")
                        strings[i] = replace(strings[i], r"\[\.?(?:la?st|akhri|akhir)(?:[_ ]?[smk]e)? *[\: ] *(?<n>\d+)\]", "[-$n:]")
                        strings[i] = replace(strings[i], r"\[(?:\.(?:f(?:ir)?st|pehla)|\.?1(?:st|h?la))\]", "[0]")
                        strings[i] = replace(strings[i], r"\[(?:\.(?:sec(?:o|d|o?nd?)?|d(?:u|oo)sra)|\.?2(?:nd|s?ra))\]", "[1]")
                        strings[i] = replace(strings[i], r"\[(?:\.(?:th(?:i|d|i?rd?)|t(?:i|ee)sra)|\.?3(?:rd|s?ra))\]", "[2]")
                        strings[i] = replace(strings[i], r"\[\.?(?:(?:shuru?(?:wat)?(?:[_ ]?(?:k|wal)a)|n)\:)?(?<n>\d+)(?:st|nd|rd|h?la|th|th?a|s?ra|wa)\]", "[$n-1]")
                        strings[i] = replace(strings[i], r"\[\.?(?:(?:a{1,2}kh(?:ir|ri)(?:[_ ]?(?:k|wal)a)|\-n)\:)(?<n>\d+)(?:st|nd|rd|h?la|th|th?a|s?ra|wa)\]", "[-$n]")
                        strings[i] = replace(strings[i], r"\[(?:(?:(?:\.th(?:i|d|i?rd?))[_ ]?la?st)|\.?[t3](?:i|ee)?(?:s?ra|rd)[_ ]?(?:a{1,2}khri|la?st))\]", "[-3]")
                        strings[i] = replace(strings[i], r"\[(?:(?:(?:\.sec(?:o|d|o?nd?)?|2nd)[_ ]?la?st)|\.?[d2](?:u|oo)?(?:s?ra|nd)[_ ]?(?:a{1,2}khri|la?st))\]", "[-2]")
                        strings[i] = replace(strings[i], r"\[\.?(?:(?:f(?:ir)?st|pehla)|1(?:st|h?la))?[_ ]?(?:\.?(?:la?st|a{1,2}khri))\]", "[-1]")
        	# the #### part helps get rid of a bug
        	# this replaces previously removed {formatted_var} functionality with new $-based functionality
        	# WARNING: r"{$1}####" should be as is
        	# the additional whitespace keeps the whole together
        	# ^ needed as-is
        	old_string = string
        	code = code.replace(old_string, f"__STRING_{i}__") # editor's NOTE: if it works, DON'T touch it! should be `code.replace(old_string, ...`, i.e. just AS-IS, and NOT replace(strings[i], ...
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
        __pretty_function_imports_regex__: str = r"\b(?:tor|surat) (?<aliases>[A-Za-z_][\w, ]*) mangao (?<functions>[A-Za-z_][\w, ]*)\b (?<module>[A-Za-z\.][\w\.]*) (?:k[aei]|(?:me[_ ]?)?se)\b"
        def __pretty_function_imports_replacer__(match: re.Match) -> str:
            module: str|list[str] = match.group("module")
            functions: str|list[str] = match.group("functions")
            aliases: str|list[str] = match.group("aliases")
            functions = [f.strip() for f in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", functions)]
            aliases = [a.strip() for a in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", aliases)]
            length: int = min(len(functions), len(aliases))
            functions_with_aliases: list[str] = [f"{functions[i]} as {aliases[i]}" for i in range(length)]
            result: str = f"from {module} import {', '.join(functions_with_aliases)}"
            return result
        code = replace(code, __pretty_function_imports_regex__, __pretty_function_imports_replacer__)
        # ^ example of usage:
        #     | tor DF mangao DataFrame pandas mese
        code = replace(code, r"(?<module>[A-Za-z\.][\w\.]*)\b (?:me)?[_ ]?se mangao (?<functions>\*|sab[_ ]kuch|[A-Za-z_][\w, ]*\b)", "from $module import $functions")
        # ^ example of usage:
        #     | pandas mese mangao DataFrame, read_csv
        code = replace(code, r"\bmangao (?<functions>\*|sab[_ ]kuch|[A-Za-z_][\w, ]*\b) (?<module>[A-Za-z\.][\w\.]*)\b (?:me)?[_ ]?se\b", "from $module import $functions")
        # ^ example of usage:
        #     | mangao DataFrame, read_csv pandas mese
        # look similar, but are different
        __pretty_function_imports_regex_2__: str = r"\b(?:tor|surat) (?<aliases>[A-Za-z_][\w, ]*) mangao (?<module>[A-Za-z\.][\w\.]*)\b(?: (?:k[aei]|(?:me[_ ]?)?se))? ?(?:[\[\:]|->) ?(?<functions>[A-Za-z_][\w, ]*)\b\]?"
        def __pretty_function_imports_replacer_2__(match: re.Match) -> str:
            module: str|list[str] = match.group("module")
            functions: str|list[str] = match.group("functions")
            aliases: str|list[str] = match.group("aliases")
            functions = [f.strip() for f in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", functions)]
            aliases = [a.strip() for a in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", aliases)]
            length: int = min(len(functions), len(aliases))
            functions_with_aliases: list[str] = [f"{functions[i]} as {aliases[i]}" for i in range(length)]
            result: str = f"from {module} import {', '.join(functions_with_aliases)}"
            return result
        code = replace(code, __pretty_function_imports_regex_2__, __pretty_function_imports_replacer_2__)
        # ^ example of usage:
        #     | tor DF, rcsv mangao pandas[DataFrame, read_csv]
        code = replace(code, r"\bmangao (?<module>[A-Za-z\.][\w\.]*)\b(?: (?:k[aei]|(?:me[_ ]?)?se))? ?(?:[\[\:]|->) ?(?<functions>\*|sab[_ ]kuch|[A-Za-z_][\w, ]*\b)\]?", "from $module import $functions")
        # ^ example of usage:
        #     | mangao pandas[DataFrame]
        __pretty_module_imports_regex__: str = r"\b(?:tor|surat) (?<aliases>[A-Za-z_][\w, ]*) mangao (?<modules>[A-Za-z_\.][\w\., ]*)\b"
        def __pretty_module_imports_replacer__(match: re.Match) -> str:
        	modules: str|list[str] = match.group("modules")
        	aliases: str|list[str] = match.group("aliases")
        	modules = [m.strip() for m in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", modules)]
        	aliases = [a.strip() for a in re.split(r", ?(?:(?:aur|(?:ke[_ ])?sath) )?", aliases)]
        	length: int = min(len(modules), len(aliases))
        	result: str = "; ".join(f"import {modules[i]} as {aliases[i]}" for i in range(length))
        	return result
        code = replace(code, __pretty_module_imports_regex__, __pretty_module_imports_replacer__)
        # ^ example of usage:
        #     | tor pd, np mangao pandas, numpy
        # comes after\/
        code = replace(code, r"\bmangao (?<modules>[A-Za-z\_\.][\w\., ]*)\b", "import $modules")
        # ^ example of usage:
        #    | mangao pandas
        # sequence matters!
        # post processing module syntax
        # which NOW HAS KEYWORD IMPORT instead of mangao
        code = replace(code, r"\b(?<=import )sab[_ ]kuch\b", "*")
        code = replace(code, r"(?<=,) \b(?:a(?:nd|ur)|ya|(?:ke[_ ]?)?sath)\b", "")
        # sequence matters!
        code = replace(code, r"(?<![\t    \t])\b(?:fc|act|def) (?:main|start)(?:\([^\)\n\t]*\))?(?=(?: *-> *[\w\?]+)?\:)", "def main()")
        # operators
        # try..else
        code = replace(code, r"\b(?:try|koshish)(?: karo)? (?<x>[^\n]+) (?:else|warna|naka{1,2}mi(?: p(e|ar))?) (?<y>[^\n]+)\b", "try_else(() -> $x, $y)")
        # NULL coalescing
        code = replace(code, r"(?<A>[_A-Za-z]\w*) ?\?\?\= ?(?<B>[^\n\t]+)", "$A = $A if ('$A' in globals() or '$A' in locals()) and $A is not None else $B")
        # the ifCONDITION(is true, then)=
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:if|agar) ?(?<condition>[^\=\n\t]+)\= ?(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or $A == $condition else $A")
        # the min= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) min *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if '$A' in globals()|locals() and ((isinstance($A, (int, float)) and $A < $B) or (not isinstance($A, (int, float)))) else $A if '$A' in globals()|locals() and isinstance($A, (int, float)) else $B")
        # the max= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) max *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if '$A' in globals()|locals() and isinstance($A, (int, float)) and $A > $B else $A if '$A' in globals()|locals() and isinstance($A, (int, float)) else 0")
        # the (def|fb)= operator
        code = replace(code, r"(?<A>[_A-Za-z]\w*) (?:def|fb|othe?r?ws) *\={1}(?!\=) *(?<B>[^\n\t]+)", "$A = $B if not('$A' in globals() or '$A' in locals()) or not $A or type($A) != type($B) else $A")
        # the ^t (initial type)= operator
        # /made for strs \ | /
        # comes before
        # WARNING: since 'is' is a reserved keyword
        # 'is None' no longer works
        # had to use ' ... he None' here
        # which works fine \ | /
        # changing the 'he' back to 'is' ONLY BREAKS the code
        code = replace(code, r"(?<varname>[A-Za-z]\w*) \^t ?\= ?str\b", "$varname = '' if not('$varname' in globals() or '$varname' in locals()) or $varname he None else Str($varname)")
        # /made for ints \ | /
        # comes after
        code = replace(code, r"(?<varname>[A-Za-z]\w*) \^t ?\= ?int\b", "$varname = 0 if not('$varname' in globals() or '$varname' in locals()) or not $varname or not isinstance($varname, (str, int, float)) else Int($varname)")
        # /made for floats \ | /
        # comes after
        code = replace(code, r"(?<varname>[A-Za-z]\w*) \^t ?\= ?(?:fl(?:oa)?t|d(?:ou)?ble?|Number|nr)\b", "$varname = 0.0 if not('$varname' in globals() or '$varname' in locals()) or not $varname or not isinstance($varname, (str, int, float)) else Flt($varname)")
        # /made for other types \ | /
        # comes at last
        code = replace(code, r"\b(?<varname>[_A-Za-z]\w*) \^t ?\= ?(?<type>[A-Za-z_]\w*)\b", "$varname = get_initial_of('$type') if not('$varname' in globals() or '$varname' in locals()) or not $varname or not isinstance($varname, $type) else $varname")
        # glitchy self-assignment operator
        def __self_assignment_operations_replacer__(match: re.Match) -> str:
            varname: str|list[str] = match.group("varname")
            re_value_group: str = match.group("values")
            result: str = ""
            if not "," in re_value_group:
                value: str = re_value_group[1:-1]
                result += f"{varname}={value}; "
                return result.strip()
            values = re.split(r", *(?=[\-\.\w])", re_value_group)
            for value in values:
                if not value:
                    continue
                if value.startswith("("):
                    value = value[1:]
                if re.search(r"(?<=[\-\.\w\)])\)$", value):
                    value = value[:-1]
                result += f"{varname}={value}; "
            result = result.strip()
            return result
        # self-assignment parser
        code = replace(code, r"(?<varname>[_A-Za-z]\w*) ?:: ?(?<values>\([^\n\t]+\))", __self_assignment_operations_replacer__)
        # ranges
        code = replace(code, r"(?<=[A-Za-z_]) ?(\.\.(?!\.)) ?(?=[^\:]+\:)", " in ")
        # numeric ranges
        # comes before\/
        code = replace(code, r"(?<!(?<!\.)\.)(?<n1>\-?\d*\.?\d+) ?(?:\.\.|se) ?(?<n2>\-?\d*\.?\d+)(?: ?(?:\:\:|step|gap|ba{1,2}d) ?(?<step_optional>\d+)(?: ?\- ?\d+)?)?", "range($n1, $n2, $step_optional)")
        # comes after\/
        code = replace(code, r"(?<!\d|(?<!\.)\.)(?:\.\. ?(?<n>\-?\d*\.?\d+))", "range($n)")
        # character ranges
        # comes before\/
        code = replace(code, r"(?<charA>[\"\']\w[\"\']) ?(?:\.\.|se) ?(?<charB>[\"\']\w[\"\'])(?: ?(?:\:\:|step|gap|ba{1,2}d) ?(?<step_optional>\d+)(?: ?\- ?\d+)?)?", "range($charA, $charB, $step_optional)")
        # comes after\/
        code = replace(code, r"(?<![\w\"\']|(?<!\.)\.)(?:\.\. ?(?<char>[\"\']\w[\"\']))", "range($char)")
        # ...{dict} -> **{dict}
        code = replace(code, r"(?<![\d]|(?<!,) )\.{3} ?(?<dict>\{|[_A-Za-z]\w*)", "**$dict")
        # ..{list} -> *{list}
        # sequence
        code = replace(code, r"(?<![\.\d]|(?<!,) )\.{2} ?(?<list>\[|[_A-Za-z]\w*)", "*$list")
        # handling mathematical operations
        # SEQUENCE MATTERS
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^ *(?<B>\-?\d*\.?\d+)", "$A**$B")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{3}", "$A**3")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) *\^{2}", "$A**2")
        code = replace(code, r"(?<A>\-?\d*\.?\d+) \%(?! *[\-\.\d])", "$A/100")
        code = replace(code, r"√ ?(?<A>\-?\d*\.?\d+)", "int($A**(1/2))")
        # handle increment
        # comes before
        code = replace(code, r"\b(?<varname>[A-Za-z]\w*) (?:me (?<val>[\w\-\.]+\b)(?: k[ao])? (?:(?:barht?a?|da{1,2}l)(?:o|t?[aei] (?:rah|ja|chal)[eo])|izafa)(?: (?:hot[ai]?|karte)(?: (?:rah|ja|chal)[eo]))?)\b", "$varname+=$val")
        # after
        code = replace(code, r"\b(?<varname>[A-Za-z]\w*)(?:\+{2}|(?: (?:me|k[ao]))? (?:(?:barht?a?|da{1,2}l)(?:o|t?[aei] (?:rah|ja|chal)[eo])|izafa)(?: (?:hot[ai]?|karte)(?: (?:rah|ja|chal)[eo]))?\b)", "$varname+=1")
        # handle decrement
        # comes before
        code = replace(code, r"\b(?<varname>[A-Za-z]\w*) (?:me(?:[_ ]?se)? (?<val>[\w\-\.]+\b)(?: k[aoi])? (?:(?:ghat{1,2}a?|kam ho|nika{1,2}l)(?:o|t?[aei] (?:rah|ja|chal)[eo])|ghata|kami?)(?: (?:hot[ai]?|karte)(?: (?:rah|ja|chal)[eo]))?)\b", "$varname-=$val")
        # after
        code = replace(code, r"\b(?<varname>[A-Za-z]\w*)(?:\-{2}|(?: (?:k[aoi]|me[_ ]?(?:se)?))? (?:(?:ghat{1,2}a?|kam ho|nika{1,2}l)(?:o|t?[aei] (?:rah|ja|chal)[eo])|ghata|kami?)(?: (?:hot[ai]?|karte)(?: (?:rah|ja|chal)[eo]))?\b)", "$varname-=1")
        # SEQUENCE MATTERS
        # IT DOES!
        # handling `A me B`, and `B A me` cases
        # First, let's handle A-me-B checks
        # non-negated versions come before
        # \/ A-me-nahi-B (negation v1)
        code = replace(code, r"(?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? nahi(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)?\b", "not($B in $A)")
        # bonus negation (negation v2 \|/ )
        # \/ A-me-B-nahi
        code = replace(code, r"(?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? nahi\b", "not($B in $A)")
        # and then the regular
        # A-me-B \/
        code = replace(code, r"(?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)?\b", "$B in $A")
        # and now let's handle A-me-B checks
        # negated versions come before
        code = replace(code, r"(?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? nahi(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)?\b", "not($B in $A)")
        # \^^^/ bonus negation (negation v1): B-nahi-A-me
        # as compared to
        # \V/ B-A-me-nahi (negative v2 down below \|/ )
        code = replace(code, r"(?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? nahi(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)?\b", "not($B in $A)")
        # and then the regular
        code = replace(code, r"(?<B>(?:[\[\"\'](?:[\"\'\w\-\.,][\]]*)+[\]\"\']|[\w\-\.]+))(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)? (?<A>(?:[\w\-\.]+|[\[\"\'](?:[\"\'\w\-\., ][\]]*)+[\]\"\'])) me(?:(?: hen?)?(?: (?:mojud|shamil)(?: hen?)?|hen?)?)?\b", "$B in $A")
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
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?<replacement_method>replace(?:_first)?)\(", "$replacement_method($varname, ")
        # >> custom starts_with, and ends_with, that work with arrays as well
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:starts_?with)\(", "startswith($varname, ") #custom, comes from KL_Py
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:ends_?with)\(", "endswith($varname, ") #custom, comes from KL_Py
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:is_?(?:sent(?:ence)?_?case|sentn?[cs]s?))\(\)", "is_sentence_case($varname)")
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:sent(?:ence)?_?case|sentn?[cs]s?)\(\)", "sentence_case($varname)")
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:is_?(?:snake_?case))\(\)", "is_snake_case($varname)")
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:snake_?case)\(\)", "snake_case($varname)")
        code = replace(code, r"\blambai (?<iterable>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)", "lambai($iterable)" if "lambai" in {**globals(), **locals()} and isinstance(lambai, Callable) else "len($iterable)")
        # don't touch it
        # doesn't need a work boundary ^
        code = replace(code, r"(?<varname>[\[\{\"\']{1,2}(?:[\-\.\w\"\' ](?:, *)?)+[\]\}\"\']{1,2}|[A-Za-z_][\w\.]*(?:\(\))?)\.\b(?:ki_?)?(?:len(?:gth)?|lambai|size)\b(?! *\()", "lambai($varname)" if "lambai" in {**globals(), **locals()} and isinstance(lambai, Callable) else "len($varname)")
        # don't change this\/
        # the ^\n part stays as-is
        # the negated version comes before,
        # to avoid conflict
        code = replace(code, r"(?<A>[\-\.\w,\"'\[\]]+) (?:not|nahi) (?:instance[ _]?of|(?:is[ _]?)an?|he[_ ]ek|(?:is|he|ki|has|of)?[ _]?(?:type|kism)(?:of)?) (?<B>[A-Za-z_]\w*)", "not isinstance($A, $B)")
        code = replace(code, r"(?<A>[\-\.\w,\"'\[\]]+) (?:instance[ _]?of|(?:is[ _]?)an?|he[_ ]ek|(?:is|he|ki|has|of)?[ _]?(?:type|kism)(?:of)?) (?<B>[A-Za-z_]\w*)", "isinstance($A, $B)")
        code = replace(code, r"\b(print|kaho) ([^\t\n]+)", "$1($2)")
        code = replace(code, r",? <?(?:(?:might|shayad) (?:throw|raise|de|uthae)|(?:throw|raise)s|uthae) [^\:\n\t]+>?(?=\:)", "")
        # ^ supposedly after a function fc x({...}?) might throw SomeError, and before a colon
        code = replace(code, r"\b(?:final|let|var|farz|n(?:a(?:ya|i)|ew)|either|yato) ", "")
        code = replace(code, r"(?<=\w )\b(?:present|mojud) (?=\S)", "")
        code = replace(code, r" (?:(?<=\w )se(?=(?: tabtak)? ?\:)|to|tak|tabtak(?= ?\:)|hua|k[aeio](?:[_ ]?lie)?)\b", "")
        code = replace(code, r"\b(?:collect(?:ed)?|together)\((?<params>(?<firstparam>[^\(\)]+), *(?<restofparams>[^\(\)]+))\)", "collect($params)" if "collect" in {**globals(), **locals()} and callable({**globals(), **locals()}["collect"]) else "list(zip($params))")
        # sequence matters
        # for numeric  keys
        code = replace(code, r"(?<k>\-?\d*\.?\d+)(?: *: *(?<type>[\w\[\]\<\>\?\.\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "$k: $v,")
        # for stringed keys
        code = replace(code, r"(?<k>[A-Za-z]\w*)(?: *: *(?<type>[\w\[\]\<\>\?\|, ]+\??))? *-> *(?<v>[^\n\t]+)", "\"$k\": $v,")
        # converting dicts to objs to allow the use of dot-driven access to keys
        # NOTE: does not support sub-dictionaries yet
        code = replace(code, r"(?<!obj\()(\{[ \n\t]*[\"']?[\w.\-]+[\"']? *: *[^\{\}]+\})", "KL_Py.obj($1)")
        # core
        code = replace(code, r"\bf(?=__STRING_\d+__)", "")
        # sequence matters
        code = replace(code, r",(?= ?\b(?:tor|as)\b)", "")
        # adds a sprinkle of English-like flavor: with open(x, "r") as file [bad] -> with open(x, "r"), as file [better, or at least a little more readable]
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
        code = replace(code, r"(?<=(?<![^ \t])[ \t])(?:is|he|kism) (?<type>[A-Za-z]*\w*\.?[A-Za-z]\w*)(?=(?: (?:as|tor) [A-Za-z_]\w*)?\:)", "case $type()")
        # KEY-VALUE replacement
        for key, value in keys.items():
            code = replace(code, r"(?<!\.)\b(" + key + r"(?! ?\: ?\w+))\b", value)
        code = replace(code, r"(?<type>[A-Za-z]*\w*\.?[A-Za-z]\w*)(?:\[\]|<list>)", "list[$type]")
        # int[] -> list[int]
        # int<list> -> list[int]
        # comes before
        code = replace(code, r"(?<!\w )(?:type|kism) ?< ?(?<type>[A-Za-z\?][\w\[\]\|\?\.]*) ?>", "$type")
        # SEQUENCE
        # this comes after
        # similar, but different
        code = replace(code, r"(?<=\w) (?:type|kism) ?< ?(?<type>[A-Za-z\?][\w\[\]\.\|\?]*) ?>", ": $type")
        # watch the sequence
        code = replace(code, r"(?<=\=) *(?:not|nahi)(?=\n)", "False")
        # relies ultimately on the positive lookahead (?= ?\=)
        # `type x=` = `x: type=`
        # needed
        code = replace(code, r"(?<type>[_A-Za-z\?][\w\[\]\.\|\?]*) (?<varname>[_A-Za-z]\w*) ?\={1}(?!\=)", "$varname: $type =")
        code = replace(code, r"\b(?<varname>[_A-Za-z]\w*) (expects|ume{0,2}d|chah(?:e|ta)|wants|mange|needs) (?<type>[_A-Za-z\?][\w\[\]\.\|\?]*)", "$varname: $type")
        # handling Optionality: default, and null cases
        # <type>? means the type is optional
        code = replace(code, r"(?<=\S )\bkwarg\b(?= *[,\)])", "= None")
        # DON'T edit
        code = replace(code, r"(?<type>[A-Za-z][\w\[\],\.]*)(?:\?| \boptional\b)(?!\.)", "$type|None")
        code = replace(code, r"(?<=(?<!\w) {2})(?:sath|case) (?:[\.\?]{3}|ba{1,2}ki|anja{1,2}n)(?=(?: (?:if|agar) [^\:]+)? ?\:)", "case _")
        # since the key-value replacement has already occured
        # (scroll up a few lines)
        # we need to catch bot sath|case
        # as sath will not be replaced
        # with case anymore
        code = replace(code, r"\b(?:none|koi_na)\b", "None")
        # REMINDER:
        # there's a difference between None, and NoneType
        code = replace(code, r"\b(?:KoiNa)\b", "NoneType")
        code = replace(code, r"(?<!\w)\?(?![\w\.])", "None")
        # readable index access
        code = replace(code, r"\[\.?(?:(?:f(?:ir)?st|pehle)(?:[_ ]ke)?|shuru?(?:[_ ][smk]e|wa{1,2}ti)) *[\: ] *(?<n>\d+)\]", "[0:$n]")
        # ^ e.g. "hello world"[.first4] -> "hell"
        code = replace(code, r"\[\.?(?:la?st|akhri|akhir)(?:[_ ]?[smk]e)? *[\: ] *(?<n>\d+)\]", "[-$n:]")
        # ^ e.g. "hello world"[.last:?4] -> "orld"
        code = replace(code, r"\[(?:\.(?:f(?:ir)?st|pehla)|\.?1(?:st|h?la))\]", "[0]")
        # ^ e.g. "hello world"[.1st] -> "h"
        code = replace(code, r"\[(?:\.(?:sec(?:o|d|o?nd?)?|d(?:u|oo)sra)|\.?2(?:nd|s?ra))\]", "[1]")
        # ^ e.g. "hello world"[.second] -> "e"
        code = replace(code, r"\[(?:\.(?:th(?:i|d|i?rd?)|t(?:i|ee)sra)|\.?3(?:rd|s?ra))\]", "[2]")
        # ^ e.g. "hello world"[.third] -> "l"
        code = replace(code, r"\[\.?(?:(?:shuru?(?:wat)?(?:[_ ]?(?:k|wal)a)|n)\:)?(?<n>\d+)(?:st|nd|rd|h?la|th|th?a|s?ra|wa)\]", "[$n-1]")
        code = replace(code, r"\[\.?(?:(?:a{1,2}kh(?:ir|ri)(?:[_ ]?(?:k|wal)a)|\-n)\:)(?<n>\d+)(?:st|nd|rd|h?la|th|th?a|s?ra|wa)\]", "[-$n]")
        code = replace(code, r"\[(?:(?:(?:\.th(?:i|d|i?rd?))[_ ]?la?st)|\.?[t3](?:i|ee)?(?:s?ra|rd)[_ ]?(?:a{1,2}khri|la?st))\]", "[-3]")
        # ^ e.g. "hello world"[.third] -> "l"
        code = replace(code, r"\[(?:(?:(?:\.sec(?:o|d|o?nd?)?|2nd)[_ ]?la?st)|\.?[d2](?:u|oo)?(?:s?ra|nd)[_ ]?(?:a{1,2}khri|la?st))\]", "[-2]")
        # ^ e.g. "hello world"[.secondlast] -> "s"
        code = replace(code, r"\[\.?(?:(?:f(?:ir)?st|pehla)|1(?:st|h?la))?[_ ]?(?:\.?(?:la?st|a{1,2}khri))\]", "[-1]")
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
        #print(f"Translation:\n________________\n\n{code}\n\n________________\n____________\n________\n\n\n")
        try:
            with open(TRANSLATION_FILE_DIR, "w") as file:
                translation: str = code
                file.write(translation)
        except:
            ...
        old_print: Callable = builtins.print
        def cust_print(*args, **kwargs):
        	args = list(args)
        	# since tuples are immutable, we can't  work with them, we need a list
        	if len(args) == 1 and args[0] == "\n":
                      # to print only a line_break (without arguments), just do cust_print()
                      # as cust_print("\n") would lead to two of them
                      args[0] = ""
        	for i, arg in old_enumerate(args):
        		if arg is None:
        			args[i] = "koi_na"
        		elif is_int(arg):
        			args[i] = fpk(arg)
        		elif is_flt(arg):
        			args[i] = fpk(arg)
        		elif is_bool(arg):
        			args[i] = "Han" if arg == True else "Nahi"
        		elif isinstance(arg, (list, tuple)):
        			args[i] = __join_into_words_version_2__(arg)
        		else:
        			# if it's an object of any other type (list, some custom class, ...)
                                                      # let's stringify, and post-process it, to make it look prettier
        			args[i] = str(args[i])
        			args[i] = replace(args[i], r", (?=[^,\]]+\])", ", aur ")
        			args[i] = replace(args[i], r"(?<=^\<)class(?= [\"\'][A-Za-z_][\w\.]*[\"\']\>$)", "kism:")
        			# ^ meaning <class 'int'>  SHOULD BE  <kism 'int'>
        			# dont mess around
        			args[i] = replace(args[i], r"^(?<pre>\<(?:kism|class)\:? [\"\'])NoneType(?<post>[\"\']\>)$", "${pre}KoiNa${post}")
        			args[i] = replace(args[i], r"^(?<pre>\<(?:kism|class)\:? [\"\'])float(?<post>[\"\']\>)$", "${pre}flt${post}")
        			args[i] = replace(args[i], r"^(?<pre>\<(?:kism|class)\:? [\"\'])Number(?<post>[\"\']\>)$", "${pre}nr${post}")
        			args[i] = replace(args[i], r"^(?<pre>\<(?:kism|class)\:? [\"\'])bool(?<post>[\"\']\>)$", "${pre}haal${post}")
        			args[i] = replace(args[i], r"\bNone\b", "koi_na")
        			args[i] = replace(args[i], r"\bTrue\b", "Han")
        			args[i] = replace(args[i], r"\bFalse\b", "Nahi")
        	old_print(*args, **kwargs)
        	# if args is empty, prints a line break
        (builtins.version, builtins.copyright, builtins.license, builtins.credits, builtins.help, builtins.enumer, builtins.print) = ("Klang version 0.8", "© 2025, Klang corp.", "MIT", "Core developers\\\n\t~ Khurram Ali", "Not implemented yet", numbered, cust_print)
        for k in dir(platform):
        	if "python" in k:
        		if k == "python_implementation":
        			# causes conflicts with some external modules
        			# ignore it
        			# from deleting
        			continue
        		delattr(platform, k)
        		#setattr(platform, replace(k, "python", "klang"), "")
        (sys.version, sys.executable, sys.pycache_prefix) = (f"{builtins.version.split(" ")[2]} {sys.version.split(" ", 1)[1]}", "", "")
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
        
        extended_builtins: dict[str, Any] = {"builtins": builtins, "enumer": numbered, "print": cust_print, "range": rng, "Number": Number, "sys": sys, "platform": platform, "KL_Py": KL_Py, "__name__": "__main__"}
        # let's ALSO push every individual function from KL_Py
        add_module("KL_Py", extended_builtins)
        #import hindGui
        #add_module("hindGui", extended_builtins)
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
        keywords: list[str] = find_matches(code, r"(?<!\.)[_A-Za-z]\w*(?!\")")
        #for keyword in keywords:
        	#if keyword in namespace:
        		#if isinstance(namespace[keyword], str):
        			#print("do something for me")
        		#print(f"{keyword=}, work on it")
        		

TEMP_FILE_DIR: str = path_to("._temp.klang")
RECENTS_LOG_FILE_DIR: str = path_to(".recents")
MODULES_DIR: str = to_path(r"venv\Lib\site-packages")
PIP_PATH: str = to_path(r"venv\Scripts\pip")
if File(RECENTS_LOG_FILE_DIR).exists_file() and Path(RECENTS_LOG_FILE_DIR).stat().st_size > 8192:
    # delete the recents file if it has grown to be more than 8 KB in size
    st = os.stat(RECENTS_LOG_FILE_DIR)
    new_file_permissions = st.st_mode | stat.S_IWRITE | stat.S_IREAD | stat.S_IEXEC
    os.chmod(RECENTS_LOG_FILE_DIR, new_file_permissions)
    try:
        os.remove(RECENTS_LOG_FILE_DIR)
    except:
        ...
if File(TRANSLATION_FILE_DIR).exists_file():
    # deleting the translation log file
    st = os.stat(TRANSLATION_FILE_DIR)
    new_file_permissions = st.st_mode | stat.S_IWRITE | stat.S_IREAD | stat.S_IEXEC
    os.chmod(TRANSLATION_FILE_DIR, new_file_permissions)
    try:
        os.remove(TRANSLATION_FILE_DIR)
    except:
        ...
SYSTEM_GENERATED_CACHE_DIR: str = to_path("Users")
if File(SYSTEM_GENERATED_CACHE_DIR).exists_folder():
    # deleting an autogenerated cache directory
    # tested that it is safe to do so
    st = os.stat(SYSTEM_GENERATED_CACHE_DIR)
    new_file_permissions = st.st_mode | stat.S_IWRITE | stat.S_IREAD | stat.S_IEXEC
    os.chmod(SYSTEM_GENERATED_CACHE_DIR, new_file_permissions)
    def on_error(func, path, excinfo) -> None:
        os.chmod(path, stat.S_IWRITE)
        func(path)
    shutil.rmtree(SYSTEM_GENERATED_CACHE_DIR, onerror=on_error)

class Klang(cmd.Cmd):
    prompt: str = "Klang> "
    intro: str = 'Klang version 0.8\n2025 build\nLikhie "madad {{function_ka_naam}}" kisi bhi function ka istamaal jaanne ke lie, ya "?" saari mojuda commands jaanne ke lie.'
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
            if re.search(r"^\-{1,2}v(?:ersion)?$", line):
                self.do_version(self.NO_SUB_COMMAND)
            elif re.search(r"^\-{1,2}(?:author|credit)s?$", line):
                self.do_credits(self.NO_SUB_COMMAND)
            elif re.search(r"^\-{1,2}about$", line):
                self.do_about(self.NO_SUB_COMMAND)
            elif re.search(r"^\-{1,2}(?:h(?:elp)?|madad)\b", line):
                # NOTE:
                # not the end of the command, there's more,
                # hence NO $ at the end
                if not re.search(r"(?<=\w )[A-Za-z]", line):
                    # if no sub commands are present, open global HELP
                    self.do_help(self.NO_SUB_COMMAND)
                    return
                # lets process the sub help-command
                # for it, open help {help_command}
                sub_help_command: str = line.split(" ")[1]
                self.do_help(sub_help_command)
            elif re.search(r"^\-{1,2}r(?:ecent)?$", line):
                self.do_recent(self.NO_SUB_COMMAND)
            elif re.search(r"^\-*i(?:nstall)?\b", line):
                # NOTE:
                # not the end of the command, there's more,
                # hence NO $ at the end
                # WE NEED THE SUB COMMAND
                if not re.search(r"(?<=\w )[A-Za-z]", line):
                    self.do_install(self.NO_SUB_COMMAND)
                    return
                sub_command: str = line.split(" ", 1)[1]
                self.do_install(sub_command)
            elif re.search(r"^\-*un?(?:install)?\b", line):
                # NOTE:
                # not the end of the command, there's more,
                # hence NO $ at the end
                # WE NEED THE SUB COMMAND
                if not re.search(r"(?<=\w )[A-Za-z]", line):
                    self.do_uninstall(self.NO_SUB_COMMAND)
                    return
                sub_command: str = line.split(" ", 1)[1]
                self.do_uninstall(sub_command)
            else:
            	if re.search(r"^[\"']?[\.\w]+[\"']?$", line):
            	    # compile if the line is kinda like a filename
            	    if line.startswith(('"', "'")):
            	    	line = line[1:]
            	    if line.endswith(('"', "'")):
            	    	line = line[:-1]
            	    file_to_be_compiled: str = to_path(line)
            	    try:
            	    	with open(RECENTS_LOG_FILE_DIR, "a") as log_file:
            	         	log_file.write(f"\n{file_to_be_compiled}")
            	    except Exception as e:
            		    ...
            	    run_process(f"python execute.py {file_to_be_compiled}")
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
            		if not re.search(r"(print|kaho)[ \(]+", argument_variable) and not re.search(r"(?<=[^\n])\=(?=[^\n])|(?<=\S )\b(?:is|are|be|rakh[aeio]|ab)\b(?!(?: (?:not None|type|kism)| *an?))", replace(argument_variable, r"[\"'][^\"']*[\"']", "__STRING__")):
            		    argument_variable = "print " + argument_variable
            		    #print(f"{argument_variable=}")
            		if not contents or not re.search(r"(?<=[^\n])\=(?=[^\n])|(?<=\S )\b(?:is|are|be|rakh[aeio]|ab)\b(?!(?: (?:not None|type|kism)| *an?))", replace(contents, r"[\"'][^\"']*[\"']", "__STRING__")):
            		    new_content = f"fc main():\n\t{argument_variable}"
            		else:
            		    new_content = f"{contents}\n\t{argument_variable}"
            		try:
            			with open(TEMP_FILE_DIR, "w") as temp_program_file:
            		    	 temp_program_file.write(new_content)
            		    	 run_process(f"python execute.py {temp_program_file.name}", True)
            		except Exception as e:
            		    ...
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
    def do_install(self, line) -> None:
        """
        :: Klang me nae packages add karta he
        .: Usage: i/install <package_name_1> [package_name_2] ...
        """
        if not line:
            print("Usage: i/install <package_name_1> [package_name_2] ...")
            return
        packages: list[str] = [pkg for pkg in re.split(r"[, ]+(?:aur )?", line)]
        if os.name != "nt":
            print("Module installation/unstallation filhal Linux/Android/Mac par supported nahi.")
            return
        run_process(f"install.bat {' '.join(packages)}")
    do_i = do_install
    def do_uninstall(self, line) -> None:
        """Klang me mojud packages ko uninstall karta he
        \nUsage: u/uninstall <package_name_1> [package_name_2] ...
        """
        if not line:
            print("Usage: u/uninstall <package_name_1> [package_name_2] ...")
            return
        packages: list[str] = [pkg for pkg in re.split(r"[, ]+(?:aur )?", line)]
        if os.name != "nt":
            print("Module installation/uninstallation filhal Linux/Android/Mac par supported nahi.")
            return
        run_process(f"uninstall.bat {' '.join(packages)}")
    do_u = do_uninstall
    def do_edit(self, line) -> None:
        text_editor: str = "nano"
        filename: str = line.strip()
        if os.name == "nt":
            text_editor = "notepad"
        if filename and not filename.endswith(".klang"):
            filename += ".klang"
        edit_command: str = text_editor
        # `notepad` just opens notepad (with a blank file)
        if filename:
            # `notepad filename`
            # opens notepad with that filename --- +'.klang' extension, if not present --- instead
            edit_command += f" {filename}"
        if not filename and File(RECENTS_LOG_FILE_DIR).exists_file():
            try:
                with open(RECENTS_LOG_FILE_DIR, "r") as file:
                    lines: list[str] = file.readlines()
                    if not len(lines):
                        return
                    most_recent_file: str = re.split(r"[\/\\]", lines[-1])[-1].strip()
                    filename = most_recent_file
                    edit_command += f" {filename}"
            except:
                ...
        run_process(edit_command)
    do_notepad = do_edit
    def do_version(self, line) -> None:
        """Display the current version of Klang CLI"""
        print(self.version)
    do_v = do_version
    def do_credits(self, line) -> None:
        """Displays the authors"""
        print(self.credits)
    do_authors = do_author = do_credits
    def do_recent(self, _):
        """
        Pichli pichli file ko dubara compile karega
        """
        if not File(RECENTS_LOG_FILE_DIR).exists_file():
            print("No recent files, as you haven't compiler any programs yet. Please compile a program first.")
            return
        try:
    	    with open(RECENTS_LOG_FILE_DIR, "r") as file:
    	        lines: list[str] = file.readlines()
    	        if not len(lines):
    	            return
    	        most_recent_file: str = re.split(r"[\/\\]", lines[-1])[-1].strip()
    	        self.do_klang(most_recent_file)
        except Exception as e:
            ...
    def do_clear(self, line) -> bool:
        """Agar sub argument 'cache' rahi to cache files ko hata dega,
        \twarna screen ko clear/saaf kardega."""
        console_clear_command: str
        if os.name == "nt":
            # if Windows
            console_clear_command = "cls"
            run_process(f"{PIP_PATH} cache purge", True)
        else:
            # but if probably Unix (including Linux, Android, and Mac)
            console_clear_command = "clear"
        if not line:
            os.system(console_clear_command)
            Klang().cmdloop()
        if File(TEMP_FILE_DIR).exists_file():
            try:
                os.remove(TEMP_FILE_DIR)
            except:
                ...
            # delete both, if both exist
            # otherwise, delete the one that
            # does exist
        if File(RECENTS_LOG_FILE_DIR).exists_file():
            try:
                os.remove(RECENTS_LOG_FILE_DIR)
            except:
                ...
        # lets also delete the translation file
        if File(TRANSLATION_FILE_DIR).exists_file():
            try:
                os.remove(TRANSLATION_FILE_DIR)
            except:
                ...
    do_cc = do_cls = do_clear
    def do_about(self, _):
    	"""provides information about the compiler"""
    	self.do_print("k__about")
    def do_madad(self, line):
        """\t    :: Kisi bhi function ka istamaal batata he"""
        self.do_help(line)
    def do_quit(self, line) -> bool:
        """\t    :: Closes the Klang terminal"""
        return True
    # Aliases for do_quit
    do_leave = do_close = do_exit = do_bas = do_kill = do_q = do_quit

		
def main() -> None:
    arg: str
    arg = " ".join(argv) if len(argv) > 0 else "ttest.klang"
    # the " ".join(argv) part is used to handle directory names with spaces (" ") in them
    if not arg.endswith(".klang"):
    	arg += ".klang"
    if not File(arg).is_file():
    	if len(argv) != 0:
    		arg = argv[0]
    if not File(arg).is_file():
    	arg = "main.klang"
    try:
    	execute(to_path(arg))
    except FileNotFoundError as e:
    	error: str = e.args[0]
    	error = replace(error, r"\bdoesn't exist\b", "mojud nahi")
    	malfunctioning_file: str = find_match(error, "(?<=\')[^\']*(?=\')") or e.filename
    	if not re.search(r"\.klang$", malfunctioning_file):
    		raise FileNaMojudError(f"File `{malfunctioning_file}' is directory '{KL_Py._dir}' me mojud nahi") from None
    	else:
    		print(f"Entry point mojud na thi.\nKisi bhi Klang program ko compile karne ke lie 'klang file/ki/path' likhen. {error}")
    		Klang().cmdloop()
    except SyntaxError as e:
    	args = list(e.args)
    	args[0] = replace(args[0], r"\b[Ii]nvalid\b", "galat")
    	args[0] = replace(args[0], r"\bunterminated\b", "ger khatm shuda")
    	args[0] = replace(args[0], r"\b(?<=string) literal\b", "")
    	args[0] = replace(args[0], r"\bdetected\b", "pai gai")
    	args[0] = replace(args[0], r"\bat\b", "karib")
    	msg = replace(args[0], r"expected [\"\'](?<fix>\S+)[\"\']", "\"$fix\" ki umeed thi")
    	msg = f"\n    {msg} line {e.lineno} pe"
    	if len(args) >= 2 and isinstance(args[1], tuple) and len(args[1]) >= 4:
    		msg += f"\n    karib yaha: \"\n\t {args[1][3].strip()}\n    \"                       ^^^\n\t\t\t    |||"
    		msg = replace(msg, r"\bf(?=\-string\b|\"[^\"]*\")", "k")
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
    	msg = "Index range se bahir he string, tuple, ya list ki"
    	raise GalatIndexError(msg) from None
    except ZeroDivisionError as e:
    	msg = "Kisi bhi number ko 0 se divide nahi kia jasakta"
    	raise DivisionError(msg) from None
    except re.error as e:
        print("andruni kharabi.", e)

if __name__ == "__main__":
    main()