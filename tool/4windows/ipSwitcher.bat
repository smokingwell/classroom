@rem echo off
@rem if "%1" ==""  goto :static

@Rem use dhcp ip configuration
netsh exec offnet.bat 
goto :finish

:static
@Rem use the static ip configuration
netsh exec onnet.bat 
:finish
pause
netsh exec offnet.bat
exit