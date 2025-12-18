from types import *
from typing import List, Callable, TypeVar, NewType, Any, Optional, Union, Final
from collections import defaultdict
from collections.abc import Iterable, Sequence
from functools import reduce, lru_cache, cache
from dataclasses import dataclass
from math import *
from random import randint, uniform, randrange, choice, sample
from numbers import Number
from datetime import datetime
from copy import deepcopy
from pathlib import Path
import os, sys, json, shutil, base64, requests, math, re, ast, webbrowser
from inspect import *
from hindGui import *
argv: list[str] = sys.argv[1:]
date = time = datetime
rand_int = randint
rand_flt = uniform
rand_from = rand_of = any_from = any_of = choice
choices = sample
haal = filhal = filhaal = bool
nahi = lambda x: not(x)
Str = lafz = jumla = str
nr = num = Number
Infinity = infinity = inf
IntInfinity = int_infinity = int_inf = intinf = sys.maxsize
goto = webbrowser.open
link = webbrowser
typename = TypeT = typeT = TypeVar("T")
def Int(x: str|int|float, base: int = 10) -> int:
    try:
        x = Str(x)
        if "." in x:
            x = x.split(".")[0]
        return int(x, base)
    except (ValueError, TypeError):
        return 0
def Flt(x: str|int|float) -> float:
    try:
        return float(x)
    except (ValueError, TypeError):
        return 0
def IntInput(*args, **kwargs):
    try:
        return Int(input(*args, **kwargs))
    except Exception:
        return 0
def FltInput(*args, **kwargs):
    try:
        return Flt(input(*args, **kwargs))
    except Exception:
        return 0
intInput, fltInput = IntInput, FltInput
class obj(dict):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self._convert_nested_dicts(self)
    def _convert_nested_dicts(self, object):
        if isinstance(object, dict):
            for k, v in object.items():
                if isinstance(v, dict):
                    object[k] = obj(v)
                elif isinstance(v, (list, tuple)):
                    object[k] = self._convert_nested_collections(v)
        elif isinstance(object, (list, tuple)):
            return self._convert_nested_collections(object)
        return object
    def _convert_nested_collections(self, collection):
        converted_collection = []
        for item in collection:
            if isinstance(item, dict):
                converted_collection.append(obj(item))
            elif isinstance(item, (list, tuple)):
                converted_collection.append(self._convert_nested_collections(item))
            else:
                converted_collection.append(item)
        return type(collection)(converted_collection)
    def __getattr__(self, key):
        try:
            return self[key]
        except KeyError:
            raise AttributeError(f"object '{self.__class__.__name__}' has no attribute '{key}'")
    def __setattr__(self, key, value):
        if isinstance(value, dict):
            self[key] = obj(value)
        elif isinstance(value, (list, tuple)):
            self[key] = self._convert_nested_collections(value)
        else:
            self[key] = value
    def __setitem__(self, key, value):
        if isinstance(value, dict):
            super().__setitem__(key, obj(value))
        elif isinstance(value, (list, tuple)):
            super().__setitem__(key, self._convert_nested_collections(value))
        else:
            super().__setitem__(key, value)
    def keys(self):
        return list(super().keys())
    def values(self):
        return list(super().values())
    def entries(self):
        return list(super().items())
# allows obj($x=$valueForX, $y=$valueForY)
o = obj
# for older dictionaries
def keys(dictionary: dict):
    return list(dictionary.keys())
def values(dictionary: dict):
    return list(dictionary.values())
def entries(dictionary: dict):
    return list(dictionary.entries())
keysOf = keys
valuesOf = values
entriesOf = entries
def remove_duplicates(lst: list) -> list:
	if not lst:
		return []
	return list(dict.fromkeys(lst).keys())
def get_local_declarations() -> o:
    """
    @return
        <dict>
        ::a dictionary holding all the local variables, (sub)classes (of classes), and the functions of the local scope of a class/function
    """
    [variables, classes, functions] = [{}, {}, {}]
    frame = currentframe().f_back
    for name, obj in frame.f_locals.items():
        # Exclude built-in names and imported modules
        if not name.startswith('__'):
            if isfunction(obj):
                functions[name] = obj
            elif isclass(obj):
                classes[name] = obj
            # For variables, we can assume anything else that's not a function or class
            # and is user-defined in this module is a variable.
            # This is a simplification; more robust checks might be needed for complex cases.
            elif not ismodule(obj):                           # Exclude imported modules
                variables[name] = obj
    return o(variables=variables, classes=classes, functions=functions)
def get_global_declarations() -> o:
    """
    @return
        <dict>
        ::a dictionary holding all the local variables, (sub)classes (of classes), and the functions of the local scope of a class/function
    """
    [variables, classes, functions] = [{}, {}, {}]
    for name, obj in globals().items():
        # Exclude built-in names and imported modules
        if not name.startswith('__') and getmodule(obj) is sys.modules[__name__]:
            if isfunction(obj):
                functions[name] = obj
            elif isclass(obj):
                classes[name] = obj
            # For variables, we can assume anything else that's not a function or class
            # and is user-defined in this module is a variable.
            # This is a simplification; more robust checks might be needed for complex cases.
            elif not ismodule(obj):                          # Exclude imported modules
                variables[name] = obj
    return o(variables=variables, classes=classes, functions=functions)
sort = sorted
sortMutate = lambda x: x.sort()
reverseSort = lambda arr: sorted(arr, reverse=Yes)
reverseSortMutate = lambda arr: arr.sort(reverse=Yes)
Yes = Ha = true = True
No = Na = false = False
none: None = None
null = none
def reverse(x: str | list[any]):
	if not isinstance(x, str) and not isinstance(x, list): return None
	if isinstance(x, list):
		x.reverse()
		return x
	return x[::-1]
filter = lambda arr, condition: filter(condition, arr)
# test this
bw = lambda *args, **kwargs: list(range(*args, **kwargs))
def rng(x: str|list|tuple) -> list[int]:
    return_list: list[int] = []
    for i in bw(len(x)-1):
        print(i)
        return_list[i] = i
    return return_list
def f(*args) -> str:
    formatted: str = ""
    curframe: Optional[FrameType] = currentframe()
    frames: list[Optional[FrameType]] = []
    caller_locals: obj = {}
    while curframe is not None:
        frames.append(curframe)
        curframe = curframe.f_back
        # keep retrieving until you hit the oldest ancestor
    frames = reversed(frames)
    # reverse the frames to prioritize the closest local scope first
    for scope in frames:
    	caller_locals.update(scope.f_locals)
    blacklisted_keywords: list = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions: list = ['system', 'popen', 'subprocess']
    blacklisted_items: list = blacklisted_keywords + blacklisted_functions
    for arg in args:
        try:
            ast.parse(f"f'{arg}'")
            arg_lower: str = arg.lower()
            for item in blacklisted_items:
                if item in arg_lower:
                    print(f"Forbidden keyword/function in input: '{item}'")
                    continue
            # Evaluate the expression
            arg: str = re.sub(r"[\{\$]+([^\s\{\}\$]+)\}?", r"{\1}", arg)
            # fixing a logical bug...
            arg = replace(arg, r",\}", "}")
            evaluation = eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
            formatted += evaluation
        except Exception:
            return ""
    return formatted
def printf(*args):
    print(f(*args))
kaho = printf
def flatten(lst: list) -> list:
    if lst is None:
        return []
    out = []
    for item in lst:
        if isinstance(item, Iterable) and not isinstance(item, (str, bytes)):
            out.extend(flatten(item))
        else:
            out.append(item)
    return out
flat = flatten
def clone(item: list|tuple|dict):
    if item == None:
        return None
    return deepcopy(item)
    #:params        item {{object to clone}}
    #:types         [(list, tuple, dict),
    #:returns       list|tuple {{cloned object}}]
def hissa(x: str|list|tuple, y: str|list|tuple) -> haal:
    if isinstance(x, str) and isinstance(y, str):
        return match_i(x, y)
    return x in y
def kism(x: Any) -> type:
	return type(x)
def he_kism(x: Any, y: type) -> bool:
	return isinstance(x, y)
is_type = istype = he_kism
def barabar(x, y) -> haal:
    if isinstance(x, str) and isinstance(y, str):
        return x.lower() == y.lower()
    return x == y
def khali(x: Iterable) -> haal:
    if x == None:
        return False
    return len(x) == 0
is_empty = isempty = khali
# type checks
is_none = isnone = is_null = isnull = lambda x: x == None
isnt_none = isntnone = non_none = nonnone = lambda x: not is_none(x)
is_string = isstring = is_str = isstr = lambda x: isinstance(x, str)
isnt_string = isntstring = isnt_str = isntstr = non_string = nonstring = non_str = nonstr = lambda x: not is_string(x)
is_integer = isinteger = is_int = isint = lambda x: isinstance(x, int)
isnt_integer = isntinteger = isnt_int = isntint = non_integer = noninteger = non_int = nonint = lambda x: not is_integer(x)
is_float = isfloat = is_flt = isflt = lambda x: isinstance(x, float)
isnt_float = isntfloat = isnt_float = isntfloat = non_float = nonfloat = non_flt = nonflt = lambda x: not is_float(x)
is_boolean = isboolean = is_bool = isbool = lambda x: isinstance(x, bool)
isnt_boolean = isntboolean = isnt_bool = isntbool = non_boolean = nonboolean = non_bool = nonbool = lambda x: not is_boolean(x)
is_array = isarray = is_arr = isarr = lambda x: isinstance(x, (list, tuple))
isnt_array = isntarray = isnt_arr = isntarr = non_array = nonarray = non_arr = nonarr = lambda x: not is_array(x)
is_stringarray = is_stringarr = is_strarray = is_strarr = isstringarray = isstringarr = isstrarray = isstrarr = lambda x: isinstance(x, (list[str], tuple[str, ...]))
isnt_stringarray = isnt_stringarr = isnt_strarray = isnt_strarr = isntstringarray = isntstringarr = isntstrarray = isntstrarr = non_stringarray = non_stringarr = non_strarray = non_strarr = nonstringarray = nonstringarr = nonstrarray = nonstrarr = lambda x: not is_stringarray(x)
is_integerarray = is_integerarr = is_intarray = is_intarr = isintegerarray = isintegerarr = isintarray = isintarr = lambda x: isinstance(x, (list[int], tuple[int, ...]))
isnt_integerarray = isnt_integerarr = isnt_intarray = isnt_intarr = isntintegerarray = isntintegerarr = isntintarray = isntintarr = non_integerarray = non_integerarr = non_intarray = non_intarr = nonintegerarray = nonintegerarr = nonintarray = nonintarr = lambda x: not is_integerarray(x)
is_floatarray = is_floatarr = is_fltarray = is_fltarr = isfloatarray = isfloatarr = isfltarray = isfltarr = lambda x: isinstance(x, (list[float], tuple[float, ...]))
isnt_floatarray = isnt_floatarr = isnt_fltarray = isnt_fltarr = isntfloatarray = isntfloatarr = isntfltarray = isntfltarr = non_floatarray = non_floatarr = non_fltarray = non_fltarr = nonfloatarray = nonfloatarr = nonfltarray = nonfltarr = lambda x: not is_floatarray(x)
is_booleanarray = is_booleanarr = is_boolarray = is_boolarr = isbooleanarray = isbooleanarr = isboolarray = isboolarr = lambda x: isinstance(x, (list[bool], tuple[bool, ...]))
isnt_booleanarray = isnt_booleanarr = isnt_boolarray = isnt_boolarr = isntbooleanarray = isntbooleanarr = isntboolarray = isntboolarr = non_booleanarray = non_booleanarr = non_boolarray = non_boolarr = nonbooleanarray = nonbooleanarr = nonboolarray = nonboolarr = lambda x: not is_booleanarray(x)
is_iterable = isiterable = lambda x: isinstance(x, Iterable)
isnt_iterable = isntiterable = non_iterable = noniterable = lambda x: not is_iterable(x)
is_callable = iscallable = is_function = isfunction = is_func = isfunc = lambda x: callable(x)
isnt_callable = isntcallable = non_callable = noncallable = lambda x: not is_callable(x)
def split(srcString: str, regex: str, maxsplits: int = IntInfinity, flags: int = 0) -> str:
    return re.split(regex, srcString, maxsplit=maxsplits, flags=flags)
def replace(src: str, to_replace: str, replacement: str = "") -> str:
    occurences: list[str] = re.findall(to_replace, src)
    for occurence in occurences:
        src = re.sub(occurence, replacement, src)
    return src
def replace_i(src: str, to_replace: str, replacement: str = "") -> str:
    occurences: list[str] = re.findall(to_replace, src, re.IGNORECASE)
    for occurence in occurences:
        src = re.sub(occurence, replacement, src)
    return src
def replace_one(src: str, to_replace: str, replacement: str = "") -> str:
    occurences: list[str] = re.findall(to_replace, src)
    if len(occurences) == 0:
        return src
    return re.sub(occurences[0], replacement, src)
def replace_one_i(src: str, to_replace: str, replacement: str = "") -> str:
    occurences: list[str] = re.findall(to_replace, src, re.IGNORECASE)
    if len(occurences) == 0:
        return src
    return re.sub(occurences[0], replacement, src)
def find_matches(src: str, to_find: str) -> list:
    matches: list[str] = re.findall(to_find, src)
    return matches
def find_matches_i(src: str, to_find: str) -> list:
    matches: list[str] = re.findall(to_find, src, re.IGNORECASE)
    return matches
def find_match(src: str, to_find: str) -> str:
    matches: list[str] = find_matches(src, to_find)
    if len(matches) == 0:
        return ""
    return matches[0]
def find_match_i(src: str, to_find: str) -> str:
    matches: list[str] = find_matches_i(src, to_find)
    if len(matches) == 0:
        return ""
    return matches[0]
def match(src: str, to_find: str) -> bool:
    matches: list[str] = find_matches(src, to_find)
    if len(matches) == 0:
        return False
    return True
def match_i(src: str, to_find: str) -> bool:
    matches: list[str] = find_matches_i(src, to_find)
    if len(matches) == 0:
        return False
    return True
class money:
    def __init__(self, amount=0, currency="Rs. "):
        self.amount = amount if amount >= 0 else 0
        self.currency = currency if currency and len(currency) <= 4 else "Rs. "
    def setCurrency(self, currency):
        if currency and len(currency) <= 4:
            self.currency = currency
        return self
    def setAmount(self, new_amount):
        if new_amount >= 0:
            self.amount = new_amount
        return self
    def add(self, *nums):
        self.amount += sum(nums)
        return self
    def subtract(self, *nums):
        self.amount -= sum(nums)
        return self
    def multiply(self, *nums):
        for n in nums:
            self.amount *= n
        return self
    def divide(self, *nums):
        for n in nums:
            if n != 0:
                self.amount /= n
        return self
    def __str__(self):
        return f"{self.currency}{self.amount:.2f}"
    def balance(self):
        return str(self)
class pesa(money):
    def __init__(self, amount=0, currency="Rs. "):
        super().__init__(amount, currency)
class File:
    def __init__(self, path: Union[str, Path]):
        self.pathname = Path(path)
    def __str__(self) -> str:
    	return str(self.pathname)
    def path(self) -> Path:
        return self.pathname
    def absolutePath(self) -> str:
        return str(self.pathname.absolute())
    def absPath(self) -> str:
        return self.absolutePath()
    def isFolder(self) -> bool:
        return self.pathname.is_dir()
    @staticmethod
    def create(fname: str, content: str = "") -> bool:
        try:
            if not fname or not content:
                raise ValueError("File name and content are required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", fname):
                for subFileName in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", fname):
                    File.create(subFileName, content)
                return True
            with open(fname, 'w') as f:
                f.write(content)
            print(f"[KL.file.JobSuccess]:\nFile {fname} created successfully.")
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to create file {fname}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
    @staticmethod
    def createBlankFile(fname: str) -> bool:
	    try:
	        if not fname:
	            raise ValueError("File name is required")
	        Path(fname).touch()
	        print(f"[KL.file.JobSuccess]:\nBlank file {fname} created successfully.")
	        return True
	    except ValueError as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    except PermissionError:
	        print(f"[KL.file.JobFailed]: Permission denied to create file {fname}")
	    except OSError as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    except Exception as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    return False
    @staticmethod
    def createFolder(folderName: str) -> bool:
        try:
            if not folderName:
                raise ValueError("Folder name is required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", folderName):
                for folder in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", folderName):
                    File.createFolder(folder)
                return True
            os.makedirs(folderName, exist_ok=True)
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to create folder {folderName}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
    @staticmethod
    def read(fname: str) -> str:
        try:
            if not fname:
                raise ValueError("File name is required")
            with open(fname, 'r') as f:
                contents: str = f.read()
                return contents
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except FileNotFoundError:
            print(f"[KL.file.JobFailed]: File {fname} does not exist")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to read file {fname}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return ""
    @staticmethod
    def get_lines(fname: str) -> list[str]:
    	contents: str = File.read(fname)
    	lines: list[str] = []
    	if not contents.strip():
    		return False
    	if re.search(r"\n", contents):
            split_content: list[str] = split(contents, r"\n")
            for line in split_content:
                lines.append(line)
    	else:
        	lines.append(contents)
        	# no lines found other than the first, append the contents as-is
    	return lines
    readlines = read_lines = getlines = get_lines
    @staticmethod
    def readJson(fname: str) -> Optional[dict]:
        try:
            return json.loads(File.read(fname))
        except json.JSONDecodeError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return None

    @staticmethod
    def write(fname: str, content: str) -> bool:
	    try:
	        if not fname or not content:
	            raise ValueError("File name and content are required")
	        with open(fname, 'w') as f:
	            f.write(content)
	        print(f"[KL.file.JobSuccess]:\nFile {fname} written successfully.")
	        return True
	    except ValueError as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    except PermissionError:
	        print(f"[KL.file.JobFailed]: Permission denied to write to file {fname}")
	    except OSError as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    except Exception as e:
	        print(f"[KL.file.JobFailed]: {e}")
	    return False
    @staticmethod
    def append(fname: str, content: str) -> bool:
        try:
            if not fname or not content:
                raise ValueError("File name and content are required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", fname):
                for subFileName in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", fname):
                    File.append(subFileName, content)
                return True
            with open(fname, 'a') as f:
                f.write(content)
            print(f"[KL.file.JobSuccess]:\nAppending to file {fname} was successful.")
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to append to file {fname}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
    @staticmethod
    def delete(fname: str) -> bool:
        try:
            if not fname:
                raise ValueError("File name is required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", fname):
                for subFileName in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", fname):
                    File.delete(subFileName)
                return True
            if os.path.isdir(fname):
                shutil.rmtree(fname)
            else:
                os.remove(fname)
            print(f"[KL.file.JobSuccess]:\nFile {fname} deleted successfully.")
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except FileNotFoundError:
            print(f"[KL.file.JobFailed]: File {fname} does not exist")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to delete file {fname}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
    @staticmethod
    def rename(fname: str, destinationString: str) -> bool:
        try:
            if not fname or not destinationString:
                raise ValueError("File name and destination are required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", fname) and re.search(r"[\\\\\\/]", destinationString):
                for subFileName in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", fname):
                    File.rename(subFileName, destinationString)
                return True
            os.rename(fname, destinationString)
            print(f"[KL.file.JobSuccess]:\nFile {fname} was successfully moved/renamed to {destinationString}")
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except FileNotFoundError:
            print(f"[KL.file.JobFailed]: File {fname} does not exist")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to rename file {fname}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
    @staticmethod
    def copy(from_path: str, to_path: str, overwrite: bool = True) -> bool:
        try:
            if not from_path or not to_path:
                raise ValueError("Source and destination paths are required")
            if re.search(r"(?<=\\w)\\s*[\\|\\+\\&\\,\\;]\\s*(?=\\w)", from_path):
                for subFileName in re.split(r"\\s*[\\|\\+\\&\\,\\;]\\s*", from_path):
                    File.copy(subFileName, to_path, overwrite)
                return True
            if overwrite:
                shutil.copy(from_path, to_path)
            else:
                shutil.copy2(from_path, to_path)
            return True
        except ValueError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except FileNotFoundError:
            print(f"[KL.file.JobFailed]: File {from_path} does not exist")
        except PermissionError:
            print(f"[KL.file.JobFailed]: Permission denied to copy file {from_path}")
        except OSError as e:
            print(f"[KL.file.JobFailed]: {e}")
        except Exception as e:
            print(f"[KL.file.JobFailed]: {e}")
        return False
file: File = File
def encode(data: any) -> str:
    try:
            return base64.b64encode(str(data).encode()).decode()
    except TypeError as e:
            return ""
def decode(data: str) -> str:
    import binascii
    try:
            return base64.b64decode(data).decode()
    except (TypeError, binascii.Error) as e:
            return ""
def internet_access() -> bool:
    try:
        requests.get("https://www.google.com", timeout=5)
        return True
    except requests.ConnectionError:
        return False
def fetch(url: str) -> dict|list:
    if not url:
        return {}
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except Exception as e:
        print(f"Error fetching data: {e}")
        return {}
def filepath(to_filename: str) -> str:
    if to_filename == none or len(to_filename) == 0:
        return ""
    return os.path.join(os.getcwd(), to_filename)
file_path = path_to = filepath

name: str = "Cindy"

def main() -> none:
    print(Int("100", 2))
    print(Flt("2.22"))
    print(Int(2.22))
    print(Flt(2.22))
    print(Int(2))
    print(Flt(2))
    dictionary: obj = obj(key="value")
    cloned = clone(dictionary)
    cloned.key = 4
    print(dictionary.entries())
    print(cloned.entries())
    name: lafz = "Misty"
    print(name)
    x: num = 4
    print(x)
    printf("$name, dont! You are, but a $10+5-8 -year-old kid. $x")
    print(isstr(""))
    print(isint(3))
    print(isflt(""))
    print(isstr(None))
    print(isstr(None))
    print(isstr(None))
    print(isstr(None))
    print(isstr(None))
    print(isstr(None))
    print(isfunc(internet_access))
    print(flatten([1, [2, [3, 4, [5, 6]]]]))
    print(remove_duplicates([1, 3, 1, 5, 6, 3, 7, 8, 9]))
    print(kism(7.5))
    print(he_kism(7.5, float))
    
if __name__ == "__main__":
    main()
