@echo off
if exist *.class (
    echo Clearing class cache...
    del *.class
) else (
    echo No Java class cache found to clear!
)