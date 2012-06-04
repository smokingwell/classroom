@echo off
SETLOCAL

set inputFile=%1
if not exist %inputFile% goto error2
if "%inputFile~-1,2%"==".c" gcc -S %inputFile%
if "%inputFile~-1,4%"==".cpp" g++ -S  %inputFile%
@if errorlevel 1 goto error1
%*
@if errorlevel 1 goto error3
@echo 测试通过 :{)
cscript /B %RYANHOME%\bin\testOkVoice.vbs
goto endend


:error1
@echo 编译出错，请检查！！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error2
@echo 文件不存在！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error3
@echo 测试出错，请检查！！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs
:endend

ENDLOCAL
