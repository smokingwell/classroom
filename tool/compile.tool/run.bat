@echo off
SETLOCAL

set inputFile=%1
if not exist %inputFile% goto error2
if "%inputFile~-1,2%"==".c" gcc -S %inputFile%
if "%inputFile~-1,4%"==".cpp" g++ -S  %inputFile%
@if errorlevel 1 goto error1
%*
@if errorlevel 1 goto error3
@echo ����ͨ�� :{)
cscript /B %RYANHOME%\bin\testOkVoice.vbs
goto endend


:error1
@echo ����������飡��
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error2
@echo �ļ������ڣ�
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:error3
@echo ���Գ������飡��
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs
:endend

ENDLOCAL
