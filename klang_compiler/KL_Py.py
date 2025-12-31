from types import *
from typing import List, Callable, TypeVar, NewType, Any, Optional, Union, Final, Self, Generic
from collections import defaultdict
from collections.abc import Sequence
from functools import reduce, lru_cache, cache
from dataclasses import dataclass
from math import *
from random import randint, uniform, randrange, choice, sample
from numbers import Number
import time as timer
from threading import Timer
from datetime import datetime
from copy import deepcopy
from pathlib import Path
import os, sys, platform, json, shutil, base64, requests, math, re, ast, webbrowser
from re import escape
import enum # NOTE: to allow enum.auto without making it global
# both of these imports are needed ^V
from enum import Enum
from inspect import *
from hindGui import *
Iterable = str | list | tuple
argv = sys.argv = sys.argv[1:]
date = time = datetime
rand_int = randint
rand_flt = uniform
rand_from = rand_of = any_from = any_of = choice
choices = sample
# not possible directly, add later
# BY creating a CUSTOM LIST type, and then adding them
# list.add = list.push = list.append
# list.add_at = list.push_at = list.insert
haal = filhal = filhaal = bool
nahi = lambda x: not(x)
class Char(str):
	def __new__(cls, value):
		if value is None or str(value) == "":
			return ""
		value = str(value)[0]
		return super().__new__(cls, value)
Str = lafz = jumla = Str = lambda x: str(x).strip() # trim the string after parsing
# no one needs additional whitespace
nr = num = Number
Infinity = infinity = inf
IntInfinity = int_infinity = int_inf = intinf = sys.maxsize
goto = webbrowser.open
link = webbrowser
typename = TypeT = typeT = TypeVar("T")
def Int(x: str|int|float, base: int = 10) -> int:
    try:
        x = replace(Str(x).strip(), r"[^e\+\-\d\.]", "") # NOTE: keep the ., it's needed for now. keep. the. dot.
        # ^ allow the dot . to pass through, for now, so 23.5 does NOT become 253
        if "." in x and len(x) >= 2:
            # and later, remove it gracefully
            x = x.split(".")[0]
        return int(x, base)
    except (ValueError, TypeError):
        return 0
def Flt(x: str|int|float) -> float:
    try:
        if isinstance(x, str):
        	x = replace(x.strip(), r"[^e\+\-\d\.]", "")
        return float(x)
    except (ValueError, TypeError):
        return 0.0
def th(n: Number) -> str:
    if n is None or not isinstance(n, Number):
    	return ""
    n = int(n)
    if 10 <= n % 100 <= 20:
        suffix = "th"
    else:
        suffix = {1: "st", 2: "nd", 3: "rd"}.get(n % 10, "th")
    return str(n) + suffix
def fus(amount: Number) -> str:
    if amount is None or not isinstance(amount, Number):
    	return ""
    amount = round(amount, 1)
    parts = str(amount).split('.')
    integer_part = '{:,}'.format(int(parts[0]))
    decimal_part = f".{parts[1]}" if len(parts) > 1 else ''
    return f"{integer_part}{decimal_part}"
def fpk(amount: Number) -> str:
    if amount is None or not isinstance(amount, Number):
    	return ""
    amount = round(amount, 1)
    parts = str(amount).split('.')
    # Indian formatting for integer part
    integer_part = parts[0]
    if len(integer_part) > 3:
        last_three = integer_part[-3:]
        rest = integer_part[:-3]
        rest = ','.join(reversed([rest[max(0, i-2):i] for i in range(len(rest), 0, -2)]))
        integer_part = f"{rest},{last_three}" if rest else last_three
    decimal_part = f".{parts[1]}" if len(parts) > 1 else ''
    format: str = f"{integer_part}{decimal_part}"
    # fixing a bug...
    result: str = format.replace("-,", "-")
    return result
athwa: float = 0.125
chotha: float = 0.25
adha: float = 0.5
dedh: float = 1.5
dhai: float = 2.5
tin: int = 3
chaar: int = 4
ath: int = 8
aath = ath
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
def collect(x, *rest):
    if not x or len(rest) == 0 or not is_iterable(x) or not all(is_iterable(it) for it in [x, *rest]):
        return [[], []]
    args: list = [x, *rest]
    return list(zip(args))
class numlist(list[Number]):
	def __init__(self, *items: Number|list[Number]):
		super().__init__()
		self.push(*items)
	def __add__(self, other: Number|list[Number]):
		if isinstance(other, list):
			lst: numlist = numlist()
			for a, b in zip(self, other):
				lst.append(a+b)
			return lst
		if isinstance(other, Number):
			self.append(other)
		return self
	def __radd__(self, other: Number|list[Number]):
		if isinstance(other, list):
			lst: numlist = numlist()
			for a, b in zip(self, other):
				lst.append(b+a)
			return lst
		if isinstance(other, Number):
			self.insert(0, other)
		return self
	def __sub__(self, other: list[Number]):
		lst: numlist = numlist()
		for a, b in zip(self, other):
			lst.append(a-b)
		return lst
	def __rsub__(self, other: list[Number]):
		lst: numlist = numlist()
		for a, b in zip(self, other):
			lst.append(b-a)
		return lst
	def __mul__(self, other: list[Number]):
		lst: numlist = numlist()
		for a, b in zip(self, other):
			lst.append(a*b)
		return lst
	def __truediv__(self, other: list[Number]):
		lst: numlist = numlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(a/b)
		return lst
	def __pos__(self):
		return numlist(-x for x in self)
	def __neg__(self):
		return numlist(-x for x in self)
	def __abs__(self):
		return numlist(abs(x) for x in self)
	def __pow__(self, other: list[Number]):
		lst: numlist = numlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(a ** b)
		return lst
	def __gt__(self, other: list[Number]):
		return all(a > b for a, b in zip(self, other))
	def __lt__(self, other: list[Number]):
		return all(a < b for a, b in zip(self, other))
	def __ge__(self, other: list[Number]):
		return all(a >= b for a, b in zip(self, other))
	def __le__(self, other: list[Number]):
		return all(a <= b for a, b in zip(self, other))
	def __eq__(self, other: list[Number]):
		return all(a == b for a, b in zip(self, other))
	def __ne__(self, other: list[Number]):
		return not all(a == b for a, b in zip(self, other))
	def __str__(self):
		return f"numlist([{', '.join(map(str, self))}])"
	def __repr__(self):
		return f"numlist([{', '.join(map(repr, self))}])"
	def sum(self):
		return sum(self)
	"""
	def difference(self):
		return sum(self)
	diff = difference
	def product(self):
		return sum(self)
	prd = product
	def quotient(self):
		return sum(self)
	quo = quotient
	"""
	def max(self):
		return max(self)
	def min(self):
		return min(self)
	def combine(self, *args: list[Number]) -> Self:
		if not args:
			return self
		for arg in args:
			if not isinstance(arg, (Number, list)) and not all(isinstance(x, Number) for x in arg):
				# if neither of the supported types
				# don't push anything
				continue
			if isinstance(arg, tuple):
				arg = list(arg)
				# what's that, a tuple?
				# we don't need that
				# we need a list
			if isinstance(arg, list):
			    self.extend(arg)
			else:
			    self.append(arg)
		return self
	add = push = combine
	def push_at(self, i: int, *items) -> Self:
		if not len(items):
			return self
		if not isinstance(i, int):
			i = len(self)
		if i < 0:
			i = 0
		elif i > len(self):
			i = len(self)
		updated_list: numlist = numlist(self[:i] + items + self[i+len(items):])
		self.clear()
		self.extend(updated_list)
		return self
	def push_start(self, item) -> None:
		self.push_at(0, item)
	def shift(self) -> Any|None:
		if len(self) == 0:
			return None
		return self.pop(0)
	#def pop
	#def pop_at
	def contains(self, item) -> bool:
		return self.count(item) > 0
	has = includes = contains
	find = find_index = index_of = list[Number].index
	no_of = list[Number].count
num_list = numlist
class intlist(list[int]):
	def __init__(self, *items: int):
		super().__init__(items)
	def __add__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			lst.append(Int(a)+Int(b))
		return lst
	def __radd__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			lst.append(Int(b)+Int(a))
		return lst
	def __sub__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			lst.append(Int(a)-Int(b))
		return lst
	def __rsub__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			lst.append(Int(b)-Int(a))
		return lst
	def __mul__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			lst.append(Int(a)*Int(b))
		return lst
	def __truediv__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(Int(a)/Int(b))
		return lst
	def __pos__(self) -> Self:
		return intlist(Int(+x) for x in self)
	def __neg__(self) -> Self:
		return intlist(Int(-x) for x in self)
	def __abs__(self) -> Self:
		return intlist(Int(abs(x)) for x in self)
	def __pow__(self, other: list[int]) -> Self:
		lst: intlist = intlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(Int(a) ** Int(b))
		return lst
	def __gt__(self, other: list[int]) -> bool:
		return all(Int(a) > Int(b) for a, b in zip(self, other))
	def __lt__(self, other: list[int]) -> bool:
		return all(Int(a) < Int(b) for a, b in zip(self, other))
	def __ge__(self, other: list[int]) -> bool:
		return all(Int(a) >= Int(b) for a, b in zip(self, other))
	def __le__(self, other: list[int]) -> bool:
		return all(Int(a) <= Int(b) for a, b in zip(self, other))
	def __eq__(self, other: list[int]) -> bool:
		return all(Int(a) == Int(b) for a, b in zip(self, other))
	def __ne__(self, other: list[int]) -> bool:
		return not all(Int(a) == Int(b) for a, b in zip(self, other))
	def __str__(self) -> str:
		return f"intlist([{', '.join(map(str, self))}])"
	def __repr__(self) -> str:
		return f"intlist([{', '.join(map(repr, self))}])"
int_list = intlist
class fltlist(list[float]):
	def __init__(self, *items: int):
		super().__init__(items)
	def __add__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			lst.append(Flt(a)+Flt(b))
		return lst
	def __radd__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			lst.append(Flt(b)+Flt(a))
		return lst
	def __sub__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			lst.append(Flt(a)-Flt(b))
		return lst
	def __rsub__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			lst.append(Flt(b)-Flt(a))
		return lst
	def __mul__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			lst.append(Flt(a)*Flt(b))
		return lst
	def __truediv__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(Flt(a)/Flt(b))
		return lst
	def __pos__(self) -> Self:
		return fltlist(Flt(+x) for x in self)
	def __neg__(self) -> Self:
		return fltlist(Flt(-x) for x in self)
	def __abs__(self) -> Self:
		return fltlist(Flt(abs(x)) for x in self)
	def __pow__(self, other: list[float]) -> Self:
		lst: fltlist = fltlist()
		for a, b in zip(self, other):
			if b == 0:
				b = 1
			lst.append(Flt(a) ** Flt(b))
		return lst
	def __gt__(self, other: list[float]) -> bool:
		return all(Flt(a) > Flt(b) for a, b in zip(self, other))
	def __lt__(self, other: list[float]) -> bool:
		return all(Flt(a) < Flt(b) for a, b in zip(self, other))
	def __ge__(self, other: list[float]) -> bool:
		return all(Flt(a) >= Flt(b) for a, b in zip(self, other))
	def __le__(self, other: list[float]) -> bool:
		return all(Flt(a) <= Flt(b) for a, b in zip(self, other))
	def __eq__(self, other: list[float]) -> bool:
		return all(Flt(a) == Flt(b) for a, b in zip(self, other))
	def __ne__(self, other: list[float]) -> bool:
		return not all(Flt(a) == Flt(b) for a, b in zip(self, other))
	def __str__(self) -> str:
		return f"fltlist([{', '.join(map(str, self))}])"
	def __repr__(self) -> str:
		return f"fltlist([{', '.join(map(repr, self))}])"
flt_list = fltlist
class Stack(Generic[TypeT]):
    def __init__(self, *items: TypeT):
        self.array: list[TypeT] = []
        self.length: int = -1
        if len(items) != 0:
            for item in items:
                self.push(item)
    def push(self, item: TypeT) -> Self:
        self.array.append(item)
        self.length += 1
        return self
    def pop(self) -> Optional[TypeT]:
        if self.length == -1:
            return None
        popped: TypeT = self.array[self.length]
        self.length -= 1
        return popped
    def top(self) -> Optional[TypeT]:
        if self.length == -1:
            return None
        return self.array[self.length]
    def len(self) -> int:
        return self.length + 1
    def size(self) -> int:
        return self.len()
    def __len__(self) -> int:
        return self.len()
    def __str__(self) -> str:
        return str(self.array)
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
    def __getattr__(self, key) -> Any|dict:
        try:
            return self[key]
        except KeyError as e:
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
    return list(dictionary.items())
get_keys = keys_of = keys
get_values = values_of = values
get_entries = entries_of = entries
def remove_duplicates(lst: list) -> list:
	if not lst or not isinstance(lst, list):
		return []
	return list(dict.fromkeys(lst).keys())
def get_local_declarations() -> obj:
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
def get_global_declarations() -> obj:
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
def rng(x: str|list|tuple|Number, y: str|list|tuple|Number|None = None, step: Number = 1, **kwArgs) -> list[int] | list[float]:
    if x is None or not isinstance(x, (str, list, tuple, Number)) or not isinstance(y, (str, list, tuple, Number, NoneType)) or step is None or not isinstance(step, Number):
    	return []
    if len(kwArgs.keys()) > 0:
    	if "s" in kwArgs:
    	    step = kwArgs.get("s", 0)
    	elif "step" in kwArgs:
    		step = kwArgs.get("step", 0)
    if step <= 0:
        step = 1
    if isinstance(y, Number) and step >= y:
        step = 1
    if isinstance(x, (str, list, tuple)) and step >= len(x):
        step = 1
    if isinstance(y, (str, list, tuple)) and step >= len(y):
        step = 1
    return_list: list[int] | list[float] = []
    if y is None:
    	if not isinstance(x, Number) and isinstance(step, int):
        	i: int = 0
        	while i < len(x):
        		return_list.append(i)
        		i += step
        	return return_list
    	x = abs(x)
    	if isinstance(x, int) and isinstance(step, int):
    	    i: int = 0
    	    while i < x:
        		return_list.append(i)
        		i += step
    	if isinstance(x, float):
    	    i: float = 0
    	    while i < x:
    	    	return_list.append(i)
    	    	i += step
    	return return_list
    if (isinstance(x, int) and isinstance(step, int)) and not isinstance(y, Number):
    	y_length: int = len(y)
    	if x < 0 or x >= y_length:
    		return []
    	while x < y_length:
        	return_list.append(x)
        	x += step
    	return return_list
    if isinstance(x, int) and isinstance(y, int) and isinstance(step, int):
    	if x == y:
    	    return []
    	if x > y:
    	    while x >= y:
    	        return_list.append(x)
    	        x -= step
    	else:
    		while x <= y:
                                        return_list.append(x)
                                        x += step
    if isinstance(x, float) or isinstance(y, float):
    	if x == y:
    		return []
    	if x > y:
    	    while x >= y:
    	        return_list.append(x)
    	        x -= step
    	else:
    		while x <= y:
    		    return_list.append(x)
    		    x += step
    return return_list
def f(*args) -> str:
    formatted: str = ""
    curframe: Optional[FrameType] = currentframe()
    frames: list[Optional[FrameType]] = []
    caller_locals: dict[str, Any] = {}
    while curframe is not None:
        frames.append(curframe)
        curframe = curframe.f_back
        # keep retrieving until you hit the oldest ancestor
    frames = reversed(frames)
    # reverse the frames to prioritize the closest local scope first
    for scope in frames:
    	caller_locals.update(scope.f_globals | scope.f_locals)
    blacklisted_keywords: list[str] = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions: list[str] = ['system', 'popen', 'subprocess']
    blacklisted_items: list[str] = blacklisted_keywords + blacklisted_functions
    for arg in args:
        if isinstance(arg, bool):
        	arg = "Yes" if arg == True else "No"
        try:
            ast.parse(f"f'{arg}'")
            arg_lower: str = arg.lower()
            for item in blacklisted_items:
                if item in arg_lower:
                    print(f"Forbidden keyword/function in input: '{item}'")
                    continue
            # Evaluate the expression
            arg = re.sub(r"(?<!\\)[\$\{]+([^\s\{\}\(\)\$]+(?:\(([\w\.\-]+(,\s*)?)*\))?)(\}(?!#{4}))?", r"{\1}", arg)
            # (?<!\\) means recognize escapes, and only match if the dollar '$', and opening_brace '{'' are not precededed by a forward slash '\' (which is the standard pattern for regex escapes)
            evaluation: str = eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
            WHITESPACE_CHAR = " "
            # for readability, there should be a whitespace character after each argument, except the last one (though, for the last one, it does not really matter, as it usually goes unnoticed)
            formatted += evaluation + WHITESPACE_CHAR
        except Exception as e:
            print(e)
    formatted = formatted.rstrip()
    return formatted
def printf(*args, **kwargs):
    print(f(*args), **kwargs)
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
def clone(item: list|tuple|dict) -> list|tuple|dict:
    if item is None:
        return None
    return deepcopy(item)
    """
    __KL_Py.deepcopy__
    
    @param       item
      @@type     (list, tuple, dict)
						:: object to clone
    @return        
       @@type    (list, tuple, dict)
                        :: a cloned object
                           depending on
                           the type passed
                           in as the argument
    """
def hissa(x: str|list|tuple|dict, y: str|list|tuple|dict) -> haal:
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
    if x is None:
        return False
    return len(x) == 0
is_empty = isempty = khali
# type checks
is_none = isnone = is_null = isnull = lambda x: x is None
isnt_none = isntnone = non_none = nonnone = lambda x: not is_none(x)
is_string = isstring = is_str = isstr = lambda x: isinstance(x, str)
isnt_string = isntstring = isnt_str = isntstr = non_string = nonstring = non_str = nonstr = lambda x: not is_string(x)
is_integer = isinteger = is_int = isint = lambda x: isinstance(x, int) and not isinstance(x, bool)
isnt_integer = isntinteger = isnt_int = isntint = non_integer = noninteger = non_int = nonint = lambda x: not is_integer(x)
def is_int_like(x: str) -> bool:
	x = str(x)
	parsed: int = 0
	try:
		parsed = int(x)
		return True
	except ValueError:
		...
	return False
is_float = isfloat = is_flt = isflt = lambda x: isinstance(x, float) and not isinstance(x, bool)
isnt_float = isntfloat = isnt_float = isntfloat = non_float = nonfloat = non_flt = nonflt = lambda x: not is_float(x)
def is_float_like(x: str) -> bool:
	x = str(x)
	parsed: float = 0.0
	try:
		parsed = float(x)
		return True
	except ValueError:
		...
	return False
is_flt_like = is_float_like
is_boolean = isboolean = is_bool = isbool = lambda x: isinstance(x, bool)
isnt_boolean = isntboolean = isnt_bool = isntbool = non_boolean = nonboolean = non_bool = nonbool = lambda x: not is_boolean(x)
def is_bool_like(x: str) -> bool:
	x = str(x)
	parsed: bool = False
	if x == "True":
		parsed = True
	elif x == "False":
		parsed = False
	return parsed
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
def split(srcString: str, regex: str = "", maxsplits: int = IntInfinity, flags: int = 0) -> list[str]:
    if not srcString or not isinstance(srcString, str) or not isinstance(regex, str):
    	# allow regex to be empty, as it will be sometimes
    	return []
    regex = re.sub(r"(\?)(<\w+>)", r"\1P\2", regex)
    raw_list: list[str] = re.split(regex, srcString, maxsplit=maxsplits, flags=flags)
    result: list[str] = []
    for x in raw_list:
    	if x.strip():
    		result.append(x)
    return result
def replace(src: str, to_replace: str, replacement: str = "") -> str:
    if not src or not isinstance(src, str) or not to_replace or not isinstance(to_replace, str) or not isinstance(replacement, str):
    	# allow empty replacement for removals
    	return ""
    to_replace = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_replace)
    replacement = re.sub(r"\$\{?(\d+)(\}(?!#{4}))?", r"\\\1", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like numbered-group convention ^
    replacement = re.sub(r"\$\{?([A-Za-z]+\w*)(\}(?!#{4}))?", r"\\g<\1>", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like named-group convention ^
    src = re.sub(to_replace, replacement, src)
    return src
def replace_i(src: str, to_replace: str, replacement: str = "") -> str:
    if not src or not isinstance(src, str) or not to_replace or not isinstance(to_replace, str) or not isinstance(replacement, str):
    	# allow empty replacement for removals
    	return ""
    to_replace = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_replace)
    replacement = re.sub(r"\$\{?(\d+)(\}(?!#{4}))?", r"\\\1", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like numbered-group convention ^
    replacement = re.sub(r"\$\{?([A-Za-z]+\w*)(\}(?!#{4}))?", r"\\g<\1>", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like named-group convention ^
    src = re.sub(to_replace, replacement, src, flags=re.IGNORECASE)
    return src
def replace_one(src: str, to_replace: str, replacement: str = "") -> str:
    if not src or not isinstance(src, str) or not to_replace or not isinstance(to_replace, str) or not isinstance(replacement, str):
    	# allow empty replacement for removals
    	return ""
    to_replace = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_replace)
    replacement = re.sub(r"\$\{?(\d+)(\}(?!#{4}))?", r"\\\1", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like numbered-group convention ^
    replacement = re.sub(r"\$\{?([A-Za-z]+\w*)(\}(?!#{4}))?", r"\\g<\1>", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like named-group convention ^
    src = re.sub(to_replace, replacement, src, count=1)
    return src
replace_first: Callable[[str, str, str, Optional[bool]], str] = replace_one
def replace_one_i(src: str, to_replace: str, replacement: str = "") -> str:
    if not src or not isinstance(src, str) or not to_replace or not isinstance(to_replace, str) or not isinstance(replacement, str):
    	# allow empty replacement for removals
    	return ""
    to_replace = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_replace)
    replacement = re.sub(r"\$\{?(\d+)(\}(?!#{4}))?", r"\\\1", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like numbered-group convention ^
    replacement = re.sub(r"\$\{?([A-Za-z]+\w*)(\}(?!#{4}))?", r"\\g<\1>", replacement) # the function sees and uses 4 hashes (####) as an escape sequence for a replacement regex group's closing brace
    # achieve JavaScript-like named-group convention ^
    src = re.sub(to_replace, replacement, src, flags=re.IGNORECASE, count=1)
    return src
replace_first_i: Callable[[str, str, str, Optional[bool]], str] = replace_one_i
def find_matches(src: str, to_find: str) -> list[str]:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return []
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = re.findall(to_find, src)
    return matches
def find_matches_i(src: str, to_find: str) -> list:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return []
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = re.findall(to_find, src, re.IGNORECASE)
    return matches
def find_match(src: str, to_find: str) -> str:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return ""
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = find_matches(src, to_find)
    if len(matches) == 0:
        return ""
    return matches[0]
def find_match_i(src: str, to_find: str) -> str:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return ""
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = find_matches_i(src, to_find)
    if len(matches) == 0 or not matches[0]:
        return ""
    return matches[0]
def match(src: str, to_find: str) -> bool:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return []
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = find_matches(src, to_find)
    if len(matches) == 0:
        return False
    return True
def match_i(src: str, to_find: str) -> bool:
    if not src or not isinstance(src, str) or not to_find or not isinstance(to_find, str):
    	return []
    to_find = re.sub(r"(\?)(<\w+>)", r"\1P\2", to_find)
    matches: list[str] = find_matches_i(src, to_find)
    if len(matches) == 0:
        return False
    return True
class money:
    def __init__(self, amount=0, currency="Rs. "):
        self.amount = amount if amount >= 0 else 0
        self.currency = currency if currency and len(currency) <= 4 else "Rs. "
    def set_currency(self, currency):
        if currency and len(currency) <= 4:
            self.currency = currency
        return self
    def set_amount(self, new_amount):
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
            if n == 0:
            	n = 1
            self.amount /= n
        return self
    def __str__(self):
        return f"{self.currency}{self.amount:.2f}"
    def balance(self):
        return str(self)
class pesa(money):
    def __init__(self, amount, currency):
        super().__init__(amount, currency)
def open_file_case_ins(filename: str, mode: str = 'r'):
    if not filename or not os.path.isfile(filename):
        raise FileNotFoundError(f"File '{filename}' doesn't exist")
    directory, name = os.path.split(filename)
    directory = directory or '.'  # Default to current directory if none specified
    name_lower = name.lower()
    for actual_file_name in os.listdir(directory):
        if actual_file_name.lower() == name_lower:
            actual_path = os.path.join(directory, actual_file_name)
            if os.path.isfile(actual_path):
                return open(actual_path, mode)
open_case_ins = open_file_case_ins
class File:
    def __init__(self, path: Union[str, Path]):
        self.pathname = Path(path)
    def __str__(self) -> str:
    	return str(self.pathname)
    def path(self) -> Path:
        return self.pathname
    def absolute_path(self) -> str:
        return str(self.pathname.absolute())
    def abs_path(self) -> str:
        return self.absolute_path()
    def is_file(self) -> bool:
        return self.pathname.is_file()
    def is_folder(self) -> bool:
        return self.pathname.is_dir()
    def exists(self) -> bool:
        return self.pathname.exists()
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
            with open_case_ins(fname, 'r') as f:
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

import time
def time_it(fn):
	if not callable(fn):
		return 
	def wrapper(*args, **kwargs):
		start: float = timer.time()
		return_value = fn(*args, **kwargs)
		# if possible, get the return value
		end: int = timer.time()
		duration: int = end - start
		print(f"@timeit:\n\tFunction `{fn.__name__}` took {duration:.3f} second(s) to fulfil its job")
		return return_value
	return wrapper
def time_lia(fn):
	if not callable(fn):
		return 
	def wrapper(*args, **kwargs):
		start: float = timer.time()
		return_value = fn(*args, **kwargs)
		# if possible, get the return value
		end: int = timer.time()
		duration: int = end - start
		print(f"@timelia:\n\tFunction `{fn.__name__}` ne apna kaam {duration:.1f} second(s) me kia")
		return return_value
	return wrapper
timeme = time_me = timeit = time_it
timelia = time_lia
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
    printf("$name dont! You are, but a $10+5-8 -year-old kid. $x")
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
    printf("hi, $75000.77778:,")
    x = 12345.6789
    print(f("$x", "$x:.2f", f"{x:,}", f"{x:,.2f}"))
    array = intlist(1.4, 2.9, 3.5)
    array2 = fltlist(2, 4, 6)
    result = array * array2
    print(result)
    nlist: numlist = numlist(1, 3, 5, 7)
    print(nlist.push([9, 11]))
    #pprint({"name": "Mike", "age": 17, "hobbies": ["horse riding", "country music", "farming"]})
    
if __name__ == "__main__":
    main()
