@echo off
if exist "app.ico" (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" --icon="app.ico" simplegui.py
)
else if exist "icon.ico" (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" --icon="icon.ico" simplegui.py
)
else (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" simplegui.py
)
if not exist "assets" (
    md assets
)
rmdir /q /s build && mkdir build && xcopy /f /s /q /y dist\* build && rmdir /q /s dist && xcopy "assets" "build/assets"  /s /e /i /h /c /y && echo Exported to "build" successfully. && echo Launching for test... && cd build && simplegui.exe && cd ..\