from FreeSimpleGUI import *

theme("Reds")

lay = [
    [Text("Please fill the following fields:")],
    [T("Email", size=(15,2)), I(key="email")],
    [T("Password", size=(15, 2)), I(password_char="*", key="pwd"), B("Show", size=(4, 1), key="reveal-password")],
    [Submit(), Exit()]
]


ui = Window("Simple Data Entry Form", lay)
password_hidden = True

while True:
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
        if email == "abbaskhurram255@gmail.com" and password == "00000000":
            popup(f"Logged in as {email}")
        else:
            popup("Invalid Credentials!")
    elif event == "reveal-password":
        if password_hidden:
            ui["pwd"].update(password_char="")
        else:
            ui["pwd"].update(password_char="*")
        password_hidden = not password_hidden
window.close()
