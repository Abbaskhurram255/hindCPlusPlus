from KL_Py import *
theme("DarkPurple1")

(default_image_path, default_image_size) = (filepath("assets/placeholder.png"), (300, 256))

lay = [
    [Image(event="hero_image", filename=default_image_path, size=default_image_size, p=(180, 40))],
    [Text("Please select an image: ", p=(24, 16)), Input(event="selected_image_path"), FileBrowse(allowed_types=(("Image files", "*.png"),))],
    [Button("Upload", p=(26, 16), size=(10, 2))]
]

app: hindGui = hindGui("Assignment", lay, fasla=(12, 14), on_top=Yes, icon=filepath("assets/favicon.ico"))

while app.chal_rahi_he:
    event, values = app.parh()
    if hissa(event, [None, "Exit", "escape"]):
        break
    if event == "Upload":
        new_image_path = values["selected_image_path"]
        if new_image_path == "":
            app.offtop()
            error("Please select an image.")
            app.ontop()
            continue
        app["hero_image"].change(filename=new_image_path, size=default_image_size)
app.die()
