@echo off
::“¿¿µ”ÎVC±‡“Î∆˜
SETLOCAL

call VCVARS32.BAT
if exist "%1.c" cl /nologo %1.c
if exist "%1.cpp" cl /nologo %1.cpp user32.lib gdi32.lib ole32.lib
@if errorlevel 1 goto error1
%*
@if errorlevel 1 goto error1
@echo ≤‚ ‘Õ®π˝ :{)
cscript /B %RYANHOME%\bin\testOkVoice.vbs
goto endend


:error1
@echo ≤‚ ‘≥ˆ¥Ì£¨«ÎºÏ≤È£°£°
cscript /B %RYANHOME%\bin\testNotOkVoice.vbs

:endend

ENDLOCAL
