import os, sys, base64, requests, math, re, inspect, ast
from collections import defaultdict
from functools import reduce
from typing import List, Callable
obj = dict
# allows obj(name=$x, age=$y)
haal = bool
nahi = lambda x: not(x)
sort = sorted
sortMutate = lambda x: x.sort()
reverseSort = lambda arr: sorted(arr, reverse=Yes)
reverseSortMutate = lambda arr: arr.sort(reverse=Yes)
Yes = Ha = true = True
No = Na = false = False
def reverse(x):
	if type(x) != str and type(x) != list: return None
	if type(x) == list:
		x.reverse()
		return x
	return x[::-1]
filter = lambda arr, condition: filter(condition, arr)
# test this
rng = lambda *args, **kwargs: list(range(*args, **kwargs))
def f(*args):
    formatted = ""
    caller_locals = inspect.currentframe().f_back.f_back.f_locals
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
            arg = re.sub(r"[\{\$]+([^\s\{\$]+)\}?", r"{\1}", arg)
            formatted += eval(f"f'{arg}'", {"__builtins__": {}}, caller_locals)
        except Exception:
            ...
    return formatted
def kaho(*args):
    print(f(*args))
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
    pi = 3.141592653589793
    speed_of_light = 2.99792e8
    earth_gravity = 9.80665
    earth_mass = 5.9722e24
    earth_radius = 6.378137e3
def encode(data):
    return base64.b64encode(data.encode()).decode()
def decode(data):
    return base64.b64decode(data).decode()
def fetch(url):
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.RequestException as e:
        print(f"Error fetching data: {e}")
        return None
def internet_access():
    try:
        requests.get("https://www.google.com", timeout=5)
        return True
    except requests.ConnectionError:
        return False
def get_file_path(filename):
    return os.path.join(os.getcwd(), filename)

def main():
    print("test")
    
if __name__ == "__main__":
    main()
