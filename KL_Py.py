import os, sys, base64, requests, math, re, inspect, ast
from collections import defaultdict
from collections.abc import Iterable, Sequence
from functools import reduce, lru_cache, cache
from copy import deepcopy
from types import *
from typing import List, Callable, TypeVar, Any, Optional, Final
from numbers import Number
from math import *
from hindGui import *
haal = filhal = filhaal = bool
nahi = lambda x: not(x)
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
# allows obj(name=$x, age=$y)
o = obj
def get_private_declarations() -> o:
    [variables, classes, functions] = [{}, {}, {}]
    for name, obj in locals().items():
        # Exclude built-in names and imported modules
        if not name.startswith('__') and inspect.getmodule(obj) is sys.modules[__name__]:
            if inspect.isfunction(obj):
                functions[name] = obj
            elif inspect.isclass(obj):
                classes[name] = obj
            # For variables, we can assume anything else that's not a function or class
            # and is user-defined in this module is a variable.
            # This is a simplification; more robust checks might be needed for complex cases.
            elif not inspect.ismodule(obj): # Exclude imported modules
                variables[name] = obj
    return o(variables=variables, classes=classes, functions=functions)
def get_global_declarations() -> o:
    [variables, classes, functions] = [{}, {}, {}]
    for name, obj in globals().items():
        # Exclude built-in names and imported modules
        if not name.startswith('__') and inspect.getmodule(obj) is sys.modules[__name__]:
            if inspect.isfunction(obj):
                functions[name] = obj
            elif inspect.isclass(obj):
                classes[name] = obj
            # For variables, we can assume anything else that's not a function or class
            # and is user-defined in this module is a variable.
            # This is a simplification; more robust checks might be needed for complex cases.
            elif not inspect.ismodule(obj): # Exclude imported modules
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
lim = lambda *args, **kwargs: list(range(*args, **kwargs))
def rng(x: str|list|tuple) -> list[int]:
    return_list: list[int] = []
    for i in lim(len(x)-1):
        print(i)
        return_list[i] = i
    return return_list
def f(*args) -> str:
    formatted: str = ""
    curframe: Optional[FrameType] = inspect.currentframe()
    caller_locals: obj = obj(curframe.f_locals | curframe.f_globals)
    while hasattr(curframe, "f_back") and curframe.f_back != None:
        caller_locals = caller_locals | curframe.f_locals | curframe.f_globals
        curframe = curframe.f_back
        # keep retrieving until you hit the oldest ancestor
    blacklisted_keywords: list = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions: list = ['system', 'popen', 'subprocess']
    blacklisted_items: list = blacklisted_keywords + blacklisted_functions
    for arg in args:
        try:
            ast.parse(f"f'{arg}'")
            arg_lower: str = arg.lower()
            for item in blacklisted_items:
                if item in arg_lower:
                    print(f"Forbidden keyword/function in input: '{keyword}'")
                    continue
            # Evaluate the expression
            arg: str = re.sub(r"[\{\$]+([^\s\{\}\$]+)\}?", r"{\1}", arg)
            formatted += eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
        except Exception:
            ...
    return formatted
def printf(*args):
    formatted: str = ""
    curframe: Optional[FrameType] = inspect.currentframe()
    caller_locals: obj = obj(curframe.f_locals | curframe.f_globals)
    while hasattr(curframe, "f_back") and curframe.f_back != None:
        caller_locals = caller_locals | curframe.f_locals | curframe.f_globals
        curframe = curframe.f_back
        # keep retrieving until you hit the oldest ancestor
    blacklisted_keywords: list = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions: list = ['system', 'popen', 'subprocess']
    blacklisted_items: list = blacklisted_keywords + blacklisted_functions
    for arg in args:
        try:
            ast.parse(f"f'{arg}'")
            arg_lower: str = arg.lower()
            for item in blacklisted_items:
                if item in arg_lower:
                    print(f"Forbidden keyword/function in input: '{keyword}'")
                    continue
            # Evaluate the expression
            arg: str = re.sub(r"[\{\$]+([^\s\{\}\$]+)\}?", r"{\1}", arg)
            formatted += eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
        except Exception:
            ...
    print(formatted)
kaho = printf
def flat(lst: list) -> list:
    if lst == None:
        return []
    out = []
    for item in lst:
        if isinstance(item, Iterable) and not isinstance(item, (str, bytes)):
            out.extend(flat(item))
        else:
            out.append(item)
    return out
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
class kmath:
    pi: float = 3.141592653589793
    speed_of_light: float = 2.99792e8
    earth_gravity: float = 9.80665
    earth_mass: float = 5.9722e24
    earth_radius: float = 6.378137e3
    cUnit: str = "m/s"
    earthsGravityUnit: str = "m/s^2"
    earthsMassUnit: str = "km"
    earthsRadiusUnit: str = "km"
    class c:
        @staticmethod
        def f(n: Number) -> Number:
            return round(1.8 * n + 32, 2)
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 3.154e18, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 3.154e15, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 3.154e12, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 3.154e9, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 5.256e7, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 8.76e5, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 3.65e4, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n * 5.214e3, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 1.2e3, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 1e2, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 1e1, 2)
    class f:
        @staticmethod
        def c(n: Number) -> Number:
            return round(((n - 32) * 5) / 9, 1)
    class m:
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 6.21371e-4, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 3.28084, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 3.93701e+1, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 1e2, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 1.0936, 2)
    class km:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 6.21371e-1, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 3.28084e+3, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 3.93701e+4, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 1e+5, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 1e+6, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 1.09361e+3, 2)
    class mi:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.60934e+3, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 1.60934, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 5.280e+3, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 6.3360e+4, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 1.60934e+5, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 1.609340e+6, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 1.76e+3, 2)
    class ft:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 3.048e-1, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 3.048e-4, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 1.89394e-4, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 1.2e1, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 3.48e+1, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 3.048e+2, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 3.33333e-1, 2)
    class inch:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 2.54e-2, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 2.54e-5, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 1.57828e-5, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 8.333e-2, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 2.54, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 2.54e+1, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 2.77778e-2, 2)
    class cm:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1e-2, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 1e-5, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 621371e-6, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 3.28084e-2, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 3.93701e-1, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 1e1, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 1.09361e-2, 2)
    class mm:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 1e-6, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 6.21371e-7, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 3.28084e-3, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 3.93701e-2, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 1e-1, 2)
        @staticmethod
        def yd(n: Number) -> Number:
            return round(n * 1.09361e-3, 2)
    class yd:
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 9.144e-1, 2)
        @staticmethod
        def km(n: Number) -> Number:
            return round(n * 9.144e-4, 2)
        @staticmethod
        def mi(n: Number) -> Number:
            return round(n * 5.68182e-4, 2)
        @staticmethod
        def ft(n: Number) -> Number:
            return round(n * 3, 2)
        @staticmethod
        def inch(n: Number) -> Number:
            return round(n * 3.6e1, 2)
        @staticmethod
        def cm(n: Number) -> Number:
            return round(n * 9.144e+1, 2)
        @staticmethod
        def mm(n: Number) -> Number:
            return round(n * 9.144e+2, 2)
    class mcg:
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 1e-6, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 1e-9, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n * 1e-12, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n * 1e-15, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.527e-8, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2.205e-9, 2)
    class mg:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 1e-6, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n * 1e-9, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n * 1e-12, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.527e-5, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2.205e-6, 2)
    class g:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n / 1e3, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n / 1e6, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n / 1e9, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.5e-2, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2e-3, 2)
    class kg:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 1e9, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n / 1e3, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n / 1e6, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.5274e1, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2.204, 2)
    class ton:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 1e12, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 1e9, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.5274e4, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2.204e3, 2)
    class kiloton:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 1e15, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 1e12, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 1e9, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 3.5274e7, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 2.204e6, 2)
    class oz:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 2.835e7, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 2.835e4, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 2.835e1, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 2.8e-2, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n * 2.8e-5, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n * 2.8e-8, 2)
        @staticmethod
        def p(n: Number) -> Number:
            return round(n * 6.3e-2, 2)
    class p:
        @staticmethod
        def mcg(n: Number) -> Number:
            return round(n * 4.536e8, 2)
        @staticmethod
        def mg(n: Number) -> Number:
            return round(n * 4.536e5, 2)
        @staticmethod
        def g(n: Number) -> Number:
            return round(n * 4.536e2, 2)
        @staticmethod
        def kg(n: Number) -> Number:
            return round(n * 4.53e-1, 2)
        @staticmethod
        def ton(n: Number) -> Number:
            return round(n * 4.53e-4, 2)
        @staticmethod
        def kiloton(n: Number) -> Number:
            return round(n * 4.53e-7, 2)
        @staticmethod
        def oz(n: Number) -> Number:
            return round(n * 1.6e1, 2)
    class ns:
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 1e-6, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 1e-9, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.6665e-11, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 2.7775e-13, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 1.157e-14, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n * 1.653e-15, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 3.805e-16, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 3.17e-17, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 3.17e-18, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 3.17e-19, 2)
    class mcs:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 1e-6, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.6665e-8, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 2.7775e-10, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 1.157e-11, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n * 1.653e-12, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 3.805e-13, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 3.17e-14, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 3.17e-15, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 3.17e-16, 2)
    class ms:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 1e-3, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.6665e-5, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 2.7775e-7, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 1.157e-8, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n * 1.653e-9, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 3.805e-10, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 3.17e-11, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 3.17e-12, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 3.17e-13, 2)
    class s:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 1e9, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 1e6, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 1e3, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.66665e-2, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 2.7775e-4, 2)

        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 1.157e-5, 2)

        @staticmethod
        def wk(n: Number) -> Number:
            return round(n * 1.653e-6, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 3.805e-7, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 3.17e-8, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 3.17e-9, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 3.17e-10, 2)
    class h:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 3.6e12, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 3.6e9, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 3.6e6, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 3.6e3, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 60, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n / 24, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n / 168, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n / 730, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n / 876e1, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n / 876e2, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n / 876e3, 2)
    class d:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 8.64e13, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 8.64e10, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 8.64e7, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 8.64e4, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.44e3, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 24, 2)
        @staticmethod
        def wk(n: Number) -> Number:
            return round(n / 7, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n / 3.417e1, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 365, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 365e1, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 365e2, 2)
    class wk:
        @staticmethod
        def ns(n: Number) -> Number:
            return round(n * 6.048e14, 2)
        @staticmethod
        def mcs(n: Number) -> Number:
            return round(n * 6.048e11, 2)
        @staticmethod
        def ms(n: Number) -> Number:
            return round(n * 6.048e8, 2)
        @staticmethod
        def s(n: Number) -> Number:
            return round(n * 6.048e5, 2)
        @staticmethod
        def m(n: Number) -> Number:
            return round(n * 1.008e4, 2)
        @staticmethod
        def h(n: Number) -> Number:
            return round(n * 1.68e2, 2)
        @staticmethod
        def d(n: Number) -> Number:
            return round(n * 7, 2)
        @staticmethod
        def mn(n: Number) -> Number:
            return round(n * 2.3e-1, 2)
        @staticmethod
        def yr(n: Number) -> Number:
            return round(n * 1.917e-2, 2)
        @staticmethod
        def dc(n: Number) -> Number:
            return round(n * 1.917e-3, 2)
        @staticmethod
        def c(n: Number) -> Number:
            return round(n * 1.917e-4, 2)
    
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
def fetch(url: str) -> dict|list:
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.RequestException as e:
        print(f"Error fetching data: {e}")
        return None
def internet_access() -> bool:
    try:
        requests.get("https://www.google.com", timeout=5)
        return True
    except requests.ConnectionError:
        return False
def filepath(filename: str) -> str:
    return os.path.join(os.getcwd(), filename)

def main() -> none:
    dictionary: obj = obj(key="value")
    cloned = clone(dictionary)
    cloned.key = 4
    print(dictionary)
    print(cloned)
    name = "Misty"
    x=4
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
    curframe: Optional[FrameType] = inspect.currentframe()
    caller_locals: obj = obj(curframe.f_locals | curframe.f_globals)
    while hasattr(curframe, "f_back") and curframe.f_back != None:
        caller_locals = caller_locals | curframe.f_locals | curframe.f_globals
        curframe = curframe.f_back
        # keep retrieving until you hit the oldest ancestor
    print(caller_locals)
    
if __name__ == "__main__":
    main()
