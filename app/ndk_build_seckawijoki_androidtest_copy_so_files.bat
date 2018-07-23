@echo off

%mDrive%
cd %mPathProjectAndroid%\app\src\main

del /s /q libs\*
echo a | xcopy /a /s /e /c /l %mDirNdkLibsOut%\* libs\

pause