from KL_Py import *


lay1 = [
    [Text("Please enter your name and email address")],
    [Text("Name: ", size=11, p=(0, 8)), Input(event="name")],
    [Text("Email address: ", p=(0, 8)), Input(event="email")]
]

lay2 = [
    [Text("Thank you for registering!")],
    [Radio("Trump", "vote", selected=No)],
    [Radio("Biden", "vote", selected=No)]
]

lay3 = [
    [Text("Thanks for voting!", event="instructions")]
]

lay = [
    [Column(lay1, event="col1", nazar=ae),
    Column(lay2, event="col2", nazar=nae),
    Column(lay3, event="col3", nazar=nae)],
    [Button("Next", hover="Click to go to the next page"), Button(text="Return to Start", nazar=nae), Button("Exit")]
]


app: hindGui = hindGui("Dynamic App", lay, fasla=(12, 6), on_top=Yes)
username: str
layout_number: int = 1

while app.chal_rahi_he:
    event, values = app.parh()
    print(event)
    if hissa(event, [None, "Exit", "escape"]):
        break
    if event == "Next":
        app[f("col$layout_number")].change(nazar=nae)
        if layout_number == 1:
            app["Return to Start"].change(text="Return to Start")
            username = values["name"].strip()
        if layout_number < 3:
            app["Return to Start"].change(nazar=ae)
            app["Next"].change(nazar=ae)
            layout_number += 1
            app[f("col$layout_number")].change(nazar=ae)
        else:
            app["col3"].change(nazar=ae)
        if layout_number == 2:
            app["instructions"].change(f"Thank you for voting{', ' + username if len(username) > 0 else ''}")
        if layout_number == 3:
            app["Next"].change(nazar=nae)
            app["Return to Start"].change(text="Refill")
        kaho("New Layout: $layout_number")
    elif event == "Return to Start":
        if layout_number == 3:
            # if the user is on the last page, clear all input fields before sending them back home
            for rows in lay1:
                for el in rows:
                    if not isinstance(el, Input):
                        continue
                    el(value="")
        app["Next"].change(nazar=ae)
        app[f("col$layout_number")].change(nazar=nae)
        app["col1"].change(nazar=ae)
        layout_number = 1
        kaho("New Layout: $layout_number")
        app["Return to Start"].change(nazar=nae)
app.die()
