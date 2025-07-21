import os, sys, base64, requests, math, re
import tkinter as tk
from tkinter import font as tkFont, messagebox, simpledialog
from collections import defaultdict
from functools import reduce
from typing import List, Callable

obj = dict
# allows obj(name=$x, age=$y)
sort = sorted
sortMutate = lambda x: x.sort()
reverseSort = lambda arr: sorted(arr, reverse=Yes)
reverseSortMutate = lambda arr: arr.sort(reverse=Yes)
Yes = true = True
No = false = False
def reverse(x):
	if type(x) != str and type(x) != list: return None
	if type(x) == list:
		x.reverse()
		return x
	return x[::-1]
filter = lambda arr, condition: filter(condition, arr)
# test this
rng = lambda *args, **kwargs: list(range(*args, **kwargs))

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

class gui:
    def __init__(self, title="Application", width=400, height=600):
        self.root = tk.Tk()
        self.root.title(title)
        self.size(width, height)
        self.root.protocol("WM_DELETE_WINDOW", self.on_close)
        
    def icon(self, iconString):
     	try:
     		self.root.iconbitmap(iconString)
     	except:
     		pass

    def size(self, width:int, height:int):
        if width < 100 or height < 100 or width > 10_000 or height > 10_000:
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

    def resizable(self, resizable):
        self.root.resizable(resizable, resizable)

    def always_on_top(self, on_top):
        self.root.attributes("-topmost", on_top)

    def on_top(self):
        self.always_on_top(True)

    def is_on_top(self) -> bool:
        return self.root.attributes("-topmost") == True

    def is_always_on_top(self) -> bool:
        return self.is_on_top()

    def opacity(self, opacity):
        if 0 <= opacity <= 1:
            self.root.attributes("-alpha", opacity)
    def background(self, color):
        self.root.configure(bg=color)
    
    def bg(self, color):
        self.background(bg=color)

    def font(self, font_family, font_size, bold=False, italic=False):
        font_style = "normal"
        if bold and italic:
            font_style = "bold italic"
        elif bold:
            font_style = "bold"
        elif italic:
            font_style = "italic"
        self.root.option_add("*Font", f"{font_family} {font_size} {font_style}")

    def message(self, title: str, message: str):
        messagebox.showinfo(title, message)
    def msg(self, title: str, message: str):
        self.message(title, message)

    def error(self, title: str, message: str):
        if self.is_on_top():
            self.always_on_top(False)
        messagebox.showerror(title, message)
    def err(self, title: str, message: str):
        self.error(title, message)

    def warning(self, title: str, message: str):
        if self.is_on_top():
            self.always_on_top(False)
        messagebox.showwarning(title, message)

    def confirm(self, title: str, message: str):
        if self.is_on_top():
            self.always_on_top(False)
        return messagebox.askyesno(title, message)

    def ask(self, title: str, message: str) -> str:
        if self.is_on_top():
            self.always_on_top(False)
        return simpledialog.askstring(title, message)

    def askInt(self, title: str, message: str) -> int:
        if self.is_on_top():
            self.always_on_top(False)
        return simpledialog.askinteger(title, message, minvalue=9e-18, maxvalue=9e18)

    def askFlt(self, title: str, message: str) -> int:
        if self.is_on_top():
            self.always_on_top(False)
        return simpledialog.askfloat(title, message, minvalue=9e-18, maxvalue=9e18)

class label(tk.Label):
    def __init__(self, master=None, text="", alignment="center", image=None, **kwargs):
        super().__init__(master, text=text, image=image, **kwargs)
        self.config(justify=alignment)
        self.opaque()

    def opaque(self):
        self.config(bg=self.cget("bg"))

    def bg(self, color):
        self.config(bg=color)
        return self

    def fg(self, color):
        self.config(fg=color)
        return self

    def setBg(self, color):
        return self.bg(color)

    def setFg(self, color):
        return self.fg(color)

    def add(self, *components):
        for component in components:
            if component is not None:
                component.pack()
        return self

    def cursor(self, cursor_type):
        self.config(cursor=cursor_type)
        return self

    def font(self, font_family, font_size, bold=False, italic=False):
        font_style = tkFont.Font(family=font_family, size=font_size, weight="bold" if bold else "normal", slant="italic" if italic else "roman")
        self.config(font=font_style)
        return self

    def align_x(self, pos):
        self.config(anchor=pos)
        return self

    def align_y(self, pos):
        self.config(anchor=pos)
        return self

    def text(self, s=None):
        if s is not None:
            self.config(text=s)
            return self
        return self.cget("text")

    def on(self, key, action):
        self.bind(f"<{key}>", lambda e: action())
        return self

    def add_tooltip(self, text):
        self.tooltip = text
        self.bind("<Enter>", self.show_tooltip)
        self.bind("<Leave>", self.hide_tooltip)
        return self

    def show_tooltip(self, event):
        x = event.x_root + 20
        y = event.y_root + 10
        self.tooltip_window = tk.Toplevel(self)
        self.tooltip_window.wm_overrideredirect(True)
        self.tooltip_window.wm_geometry(f"+{x}+{y}")
        label = tk.Label(self.tooltip_window, text=self.tooltip, background="yellow")
        label.pack()

    def hide_tooltip(self, event):
        if self.tooltip_window:
            self.tooltip_window.destroy()
            self.tooltip_window = None

class panel(tk.Frame):
    def __init__(self, master=None, **kwargs):
        super().__init__(master, **kwargs)

    def bg(self, color):
        self.config(bg=color)
        return self

    def fg(self, color):
        self.config(fg=color)
        return self

    def add(self, *components):
        for component in components:
            if component is not None:
                component.pack()
        return self

    def layout(self, layout):
        self.config(layout)
        return self

    def add_tooltip(self, text):
        self.tooltip = text
        self.bind("<Enter>", self.show_tooltip)
        self.bind("<Leave>", self.hide_tooltip)
        return self

    def show_tooltip(self, event):
        x = event.x_root + 20
        y = event.y_root + 10
        self.tooltip_window = tk.Toplevel(self)
        self.tooltip_window.wm_overrideredirect(True)
        self.tooltip_window.wm_geometry(f"+{x}+{y}")
        label = tk.Label(self.tooltip_window, text=self.tooltip, background="yellow")
        label.pack()

    def hide_tooltip(self, event):
        if self.tooltip_window:
            self.tooltip_window.destroy()
            self.tooltip_window = None
            
def main():
    ui:gui = gui("My GUI")
    ui.size(600, 400)
    ui.start()
    
if __name__ == "__main__":
    main()
