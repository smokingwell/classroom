@echo off
if exist "%JAVA_HOME%\bin\java.exe" goto begin2
set JAVA_HOME=d:\autobuild\j2sdk1.4.0
set PATH=%JAVA_HOME%\bin;%PATH%
set CLASSPATH=.

:begin2
javac -g %1.java
@if errorlevel 1 goto error1
java %*
@if errorlevel 1 goto error1
@echo ����ͨ�� ����
goto endend


:error1
@echo ���Գ������飡��
beep

:endend
