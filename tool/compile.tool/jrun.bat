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
@echo ����ͨ�� :)
cscript /B %RYANHOME%\bin\testOkVoice.vbs
goto endend


:error1
@echo ����������飡��
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error2
@echo �ļ������ڣ�
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error3
@echo ���г������飡��
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs
:endend
