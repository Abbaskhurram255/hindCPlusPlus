@echo off
if exist app.ico (
    echo Exporting <to "build" folder, where app.ico is being used as the app icon>...
    pyinstaller --noconfirm --onefile --windowed --add-data "assets;assets" --icon=app.ico KL_py.py
)
else if exist icon.ico (
    echo Exporting <to "build" folder, where icon.ico is being used as the app icon>...
    pyinstaller --noconfirm --onefile --windowed --add-data "assets;assets" --icon=icon.ico KL_py.py
)
else (
    echo Exporting <to "build" folder, where the default icon will be used since no "app.ico" or "icon.ico" files were located in the project's root directory>...
    pyinstaller --noconfirm --onefile --windowed --add-data "assets;assets" KL_py.py
)
if not exist "assets" (
    md assets
)
rmdir /q /s build && mkdir build && xcopy /f /s /q /y dist\* build && rmdir /q /s dist && xcopy "assets" "build/assets"  /s /e /i /h /c /y && echo Exported to "build" successfully. && echo Launching for test... && cd build && KL_Py.exe && cd ..\