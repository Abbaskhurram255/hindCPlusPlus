from FreeSimpleGUI import *
from KL_Py import *

theme("Reds")

lay = [
    [Text("Please fill the following fields:")],
    [T("Email", size=(15,2)), I(key="email")],
    [T("Password", size=(15, 2)), I(password_char="*", key="pwd"), B("Show", size=(4, 1), key="reveal-password")],
    [Submit(), Exit()]
]

ui = Window("Simple Data Entry Form", lay)
admin: obj = obj(email="abbaskhurram255@gmail.com", password="00000000")
password_hidden: filhal = Ha

while Yes:
    event, values = ui.read()
    if event == WIN_CLOSED or event == "Exit":
        break
    elif event == "Submit":
        email, password = values["email"], values["pwd"]
        print("Event: " + event)
        print("{")
        print(f"    Email={email},")
        print(f"    Password={password}")
        print("}")
        if email == admin.email and password == admin.password:
            popup(f"Logged in as {email}")
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
