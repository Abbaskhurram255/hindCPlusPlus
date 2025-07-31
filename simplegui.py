from FreeSimpleGUI import *

theme("DarkTeal4")

lay = [
    [T("Please fill the following fields:")],
    [T("Name", size=(15,1)), I(key="Name")],
    [Submit(), Exit()]
]


window = Window("Simple Data Entry Form", lay)

while True:
    event, values = window.read()
    if event == WIN_CLOSED or event == "Exit":
        break
    elif event == "Submit":
        print(event, values)
window.close()
