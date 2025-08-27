import os, sys, base64, requests, math, re, inspect, ast
from collections import defaultdict
from collections.abc import Iterable, Sequence
from functools import reduce
from types import *
from typing import List, Callable, TypeVar, Any, Optional
from numbers import Number
from math import *
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
            raise AttributeError(f"'{self.__class__.__name__}' objectect has no attribute '{key}'")
    def __setattr__(self, key, value):
        if key.startswith('_'):  # Allow setting internal attributes
            super().__setattr__(key, value)
        else:
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
sort = sorted
sortMutate = lambda x: x.sort()
reverseSort = lambda arr: sorted(arr, reverse=Yes)
reverseSortMutate = lambda arr: arr.sort(reverse=Yes)
Yes = Ha = true = True
No = Na = false = False
none: None = None
def reverse(x: str | list[any]):
	if not isinstance(x, str) and not isinstance(x, list): return None
	if isinstance(x, list):
		x.reverse()
		return x
	return x[::-1]
filter = lambda arr, condition: filter(condition, arr)
# test this
rng = lambda *args, **kwargs: list(range(*args, **kwargs))
def f(*args) -> str:
    formatted = ""
    caller_locals = inspect.currentframe().f_back.f_locals
    blacklisted_keywords = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions = ['system', 'popen', 'subprocess']
    for arg in args:
        try:
            ast.parse(f"f'{arg}'")
            arg_lower = arg.lower()
            for keyword in blacklisted_keywords:
                if keyword in arg_lower:
                    print(f"Forbidden keyword in input: '{keyword}'")
                    continue
            for func in blacklisted_functions:
                if func in arg_lower:
                    print(f"Forbidden function in input: '{func}'")
                    continue
            # Evaluate the expression
            arg = re.sub(r"[\{\$]+([^\s\{\}\$]+)\}?", r"{\1}", arg)
            formatted += eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
        except Exception:
            ...
    return formatted
def printf(*args):
    formatted = ""
    caller_locals = inspect.currentframe().f_back.f_locals
    blacklisted_keywords = ['import', '__', 'open', 'exec', 'eval', 'del', 'lambda']
    blacklisted_functions = ['system', 'popen', 'subprocess']
    for arg in args:
        try:
            ast.parse(f"f'{arg}'")
            arg_lower = arg.lower()
            for keyword in blacklisted_keywords:
                if keyword in arg_lower:
                    print(f"Forbidden keyword in input: '{keyword}'")
                    continue
            for func in blacklisted_functions:
                if func in arg_lower:
                    print(f"Forbidden function in input: '{func}'")
                    continue
            # Evaluate the expression
            arg = re.sub(r"[\{\$]+([\w\+\-\*\/]+)\}?", r"{\1}", arg)
            formatted += eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
        except Exception:
            ...
    print(formatted)
kaho = printf
hissa = lambda x, y: x in y
barabar = lambda x, y: x == y
khali = lambda x: len(str(x))
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
    
def encode(data) -> str:
    try:
            return base64.b64encode(str(data).encode()).decode()
    except TypeError as e:
            return ""
def decode(data) -> str:
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
    print(obj(key="value")["key"] == obj(key="value").key)
    name = "Mike"
    printf("$name, you are but a $10+5+2 -year-old kid")
    
if __name__ == "__main__":
    main()
