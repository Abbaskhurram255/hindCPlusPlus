@echo off
if exist "assets/app.ico" (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" --icon="assets/app.ico" assignment.py
)
else if exist "assets/favicon.ico" (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" --icon="assets/favicon.ico" assignment.py
)
else (
    pyinstaller --noconfirm --onefile --windowed --add-data "KL_Py.py:." --add-data "assets;assets" assignment.py
)
if not exist "assets" (
    md assets
)
rmdir /q /s build && mkdir build && xcopy /f /s /q /y dist\* build && rmdir /q /s dist && xcopy "assets" "build/assets"  /s /e /i /h /c /y && echo Exported to "build" successfully. && echo Launching for test... && cd build && assignment.exe && cd ..\