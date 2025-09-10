from KL_Py import *

lay1 = [
    [Text("Please enter your name and email address")],
    [Text("Name: ", size=11, p=(0, 8)), Input(event="name")],
    [Text("Email address: ", p=(0, 8)), Input(event="email")]
]

lay2 = [
    [Text("Thank you for registering!")],
    [Radio("Trump", "vote")],
    [Radio("Biden", "vote")]
]

lay3 = [
    [Text("Thanks for voting!", event="instructions")]
]

lay = [
    [Column(lay1, event="col1", visible=True),
    Column(lay2, event="col2", visible=False),
    Column(lay3, event="col3", visible=False)],
    [Button("Next"), Button("Return to Start", visible=False), Button("Exit")]
]


app: hindGui = hindGui("Dynamic App", lay, fasla=(12, 6))
username: str
layout_number: int = 1

while True:
    event, values = app.parh()
    if event in (None, "Exit"):
        break
    if event == "Next":
        app[f"col{layout_number}"].change(visible=False)
        if layout_number == 1:
            username = values["name"].strip()
        if layout_number < 3:
            app["Return to Start"].change(visible=True)
            app["Next"].change(visible=True)
            layout_number += 1
            app[f"col{layout_number}"].change(visible=True)
        else:
            app["col3"].change(visible=True)
        if layout_number == 2:
            app["instructions"].change(f"Thank you for voting{', ' + username if len(username) > 0 else ''}")
        if layout_number == 3:
            app["Next"].change(visible=False)
        print(f"New Layout: {layout_number}")
    elif event == "Return to Start":
        app["Next"].change(visible=True)
        app[f"col{layout_number}"].change(visible=False)
        app[f"col1"].change(visible=True)
        layout_number = 1
        app["Return to Start"].change(visible=False)
        print(f"New Layout: {layout_number}")
app.die()
