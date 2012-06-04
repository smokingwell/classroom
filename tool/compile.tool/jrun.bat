@echo off
if exist "%JAVA_HOME%\bin\java.exe" goto begin2
set JAVA_HOME=d:\autobuild\j2sdk1.4.0
set PATH=%JAVA_HOME%\bin;%PATH%
set CLASSPATH=.

:begin2
set inputFile=%1
if not exist %inputFile% goto error2
if "%inputFile~-1,5%"==".java" javac -g %1

@if errorlevel 1 goto error1
java %*
@if errorlevel 1 goto error3
@echo 测试通过 :)
cscript /B %RYANHOME%\bin\testOkVoice.vbs
goto endend


:error1
@echo 编译出错，请检查！！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error2
@echo 文件不存在！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error3
@echo 运行出错，请检查！！
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs
:endend
