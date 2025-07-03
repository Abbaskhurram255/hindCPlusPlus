import base64
import requests
import os

class Money:
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
            if n != 0:
                self.amount /= n
        return self

    def __str__(self):
        return f"{self.currency}{self.amount:.2f}"

    def balance(self):
        return str(self)

class Pesa(Money):
    def __init__(self, amount=0, currency="Rs. "):
        super().__init__(amount, currency)

class KMath:
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


import tkinter as tk
from tkinter import messagebox, simpledialog

class GUI:
    def __init__(self, title="Application", width=400, height=600):
        self.root = tk.Tk()
        self.root.title(title)
        self.set_size(width, height)
        self.root.protocol("WM_DELETE_WINDOW", self.on_close)

    def set_size(self, width, height):
        if width < 100 or height < 100 or width > 10000 or height > 10000:
            width, height = 400, 600
        self.root.geometry(f"{width}x{height}")
        self.root.update_idletasks()


    def center(self):
        self.root.eval('tk::PlaceWindow . center')

    def start(self):
        self.root.deiconify()
        self.root.mainloop()

    def hide(self):
        self.root.withdraw()

    def show(self):
        self.root.deiconify()

    def on_close(self):
        if messagebox.askyesno("Close", "Are you sure you want to exit?"):
            self.root.destroy()

    def set_resizable(self, resizable):
        self.root.resizable(resizable, resizable)

    def set_always_on_top(self, on_top):
        self.root.attributes("-topmost", on_top)

    def always_on_top(self):
        self.set_always_on_top(True)

    def on_top(self):
        self.set_always_on_top(True)

    def is_on_top(self) -> bool:
        return self.root.attributes("-topmost") == True

    def is_always_on_top(self) -> bool:
        return is_on_top()

    def set_opacity(self, opacity):
        if 0 <= opacity <= 1:
            self.root.attributes("-alpha", opacity)

    def set_background(self, color):
        self.root.configure(bg=color)

    def set_font(self, font_family, font_size, bold=False, italic=False):
        font_style = "normal"
        if bold and italic:
            font_style = "bold italic"
        elif bold:
            font_style = "bold"
        elif italic:
            font_style = "italic"
        self.root.option_add("*Font", f"{font_family} {font_size} {font_style}")

    def show_message(self, title: str, message: str):
        messagebox.showinfo(title, message)

    def show_error(self, title: str, message: str):
        if self.is_on_top():
            self.set_always_on_top(False)
        messagebox.showerror(title, message)

    def show_warning(self, title: str, message: str):
        if self.is_on_top():
            self.set_always_on_top(False)
        messagebox.showwarning(title, message)

    def confirm(self, title: str, message: str):
        if self.is_on_top():
            self.set_always_on_top(False)
        return messagebox.askyesno(title, message)

    def ask(self, title: str, message: str) -> str:
        if self.is_on_top():
            self.set_always_on_top(False)
        return simpledialog.askstring(title, message)

    def askint(self, title: str, message: str) -> int:
        if self.is_on_top():
            self.set_always_on_top(False)
        return simpledialog.askinteger(title, message, minvalue=9e-18, maxvalue=9e18)

    def askfloat(self, title: str, message: str) -> int:
        if self.is_on_top():
            self.set_always_on_top(False)
        return simpledialog.askfloat(title, message, minvalue=9e-18, maxvalue=9e18
