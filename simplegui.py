from KL_Py import *

theme("Reds")

lay = [ 
    [Text("Please fill the following fields:")],
    [T("Email", size=(15, 2)), I(event="email")],
    [T("Password", size=(15, 2)), I(pwd=Yes, event="pwd"), B("Show", size=(4, 1), event="reveal-password")],
    [Submit(), Exit()]
]

ui = hindGui("Simple Data Entry Form", style=lay, fasla=(12, 8))
admin: obj = obj(email="abbaskhurram255@gmail.com", password="00000000")
password_hidden: filhal = Ha

while ui.is_running:
    values: dict | obj
    event, values = ui.parh()
    # changing the type of variable values to obj for quicker dot-driven access
    if values:
        values = obj(values)
    if hissa(event, [CLOSE, EXIT]):
        # print("hate to see you go!")
        break
    elif event == "Submit":
        email, pwd = values.values()
        print("Event: " + event)
        print("{")
        print(f"    Email={email},")
        print(f"    Password={pwd}")
        print("}")
        if khali(email) or khali(pwd):
            keh("Neither the email nor the password field can be empty.")
        elif nahi(re.search(r"^\w[\w\+\-\.]*@\w{2,}(\.\w{2,}){1,}$", email)):
            keh("Invalid Email Format.")
        elif nahi(barabar(email, admin.email)) and nahi(barabar(pwd, admin.password)):
            ui["email"].change(text_color="red")
            keh("Incorrect Email address.")
        elif barabar(email, admin.email) and nahi(barabar(pwd, admin.password)):
            ui["pwd"].change(text_color="red")
            keh("Incorrect password.")
        else:
            ui["email"].change(text_color="#000")
            ui["pwd"].change(text_color="#000")
            keh(f"Logged in as {email}")
    elif event == "reveal-password":
        if password_hidden:
            ui["pwd"].change(pwd=False)
            ui["reveal-password"].change(text="Hide")
        else:
            ui["pwd"].change(pwd=True)
            ui["reveal-password"].change(text="Show")
        password_hidden = nahi(password_hidden)
ui.die()
