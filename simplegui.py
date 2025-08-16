from FreeSimpleGUI import *
from KL_Py import *

theme("Reds")

lay = [
    [Text("Please fill the following fields:")],
    [T("Email", size=(15,2)), I(key="email")],
    [T("Password", size=(15, 2)), I(password_char="*", key="pwd"), B("Show", size=(4, 1), key="reveal-password")],
    [Submit(), Exit()]
]

ui = Window("Simple Data Entry Form", lay, margins=(12, 8))
admin: obj = obj(email="abbaskhurram255@gmail.com", password="00000000")
password_hidden: filhal = Ha

while Yes:
    values: dict | obj
    event, values = ui.read()
    # changing the type of variable values to obj for quicker dot-driven access
    if values is not None:
        values = obj(values)
    if event == WIN_CLOSED or event == "Exit":
        break
    elif event == "Submit":
        email, pwd = values.values()
        print("Event: " + event)
        print("{")
        print(f"    Email={email},")
        print(f"    Password={pwd}")
        print("}")
        if email == admin.email and pwd == admin.password:
            ui["email"].update(text_color="#000")
            ui["pwd"].update(text_color="#000")
            popup(f"Logged in as {email}")
        elif email == "" or pwd == "":
            popup("Neither the email nor the password field can be empty.")
        elif not re.search(r"^[\w\-]+@\w+\.\w+$", email):
            popup("Invalid Email Format.")
        elif not email == admin.email and pwd == admin.password:
            popup("Incorrect Email address.")
        elif email == admin.email and pwd != admin.password:
            popup("Incorrect password.")
        else:
            ui["email"].update(text_color="red")
            ui["pwd"].update(text_color="red")
            popup("Invalid Credentials!")
    elif event == "reveal-password":
        if password_hidden:
            ui["pwd"].update(password_char="")
        else:
            ui["pwd"].update(password_char="*")
        password_hidden = nahi(password_hidden)
ui.close()
