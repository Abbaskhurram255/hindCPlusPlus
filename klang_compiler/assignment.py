from KL_Py import *
theme("DarkPurple1")
#theme("DarkTeal6")

(default_image_path, default_image_size) = (filepath("assets/placeholder.png"), (280, 256))

lay = [
    Center([
        [Image(event="hero_image", filename=default_image_path, size=default_image_size, p=(20, 40), hover="Sample image")],
        [Text("Please select an image: ", p=(0, 16)), Input(event="selected_image_path", size=(37, 0)), FileBrowse(event="file_picker", allowed_types=(("Image files", "*.png"),), size=(8, 2), p=(14, 0), hover="Load image...")],
        [Button("Upload", hover="Click to upload", hover_color="#003 ke upar whitesmoke", border=4, p=(2, 16), size=(10, 2)), Button("Share", border=2, hover="Share with\nfriends❤", hover_color="white par green", color="blue on #aca6ff", p=(0, 16), size=(10, 2))],
        [HSep(p=5, color="#666")]
    ]),
    [T("© 2025", p=(20, 0), size=(17, 2), text_color="pink"), HP(), T("⭐ KL.hindGui", event="visit_gh_profile", p=(0, 0), size=(13, 2), text_color="pink")]
]

app: hindGui = hindGui("Assignment", lay, fasla=(18, 14), on_top=Yes, icon=filepath("assets/favicon.ico"))

def main() -> none:
    while app.chal_rahi_he:
        event, values = app.parh()
        if hissa(event, [None, "Exit", "escape"]):
            break
        if event == "Upload":
            new_image_path = values["selected_image_path"].strip()
            if new_image_path == "":
                app.offtop()
                error("Please select an image.")
                app.ontop()
                continue
            app["hero_image"].change(filename=new_image_path, size=default_image_size)
        if event == "hero_image":
            app["file_picker"].click()
        if event == "visit_gh_profile":
            goto("https://github.com/abbaskhurram255/")
    app.die()
