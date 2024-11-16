



if not exist %LIBRARY_INC%\\aws\\mqtt\\mqtt.h exit 1
IF %ERRORLEVEL% NEQ 0 exit /B 1
if not exist %PREFIX%\\Library\\bin\\aws-c-mqtt.dll exit 1
IF %ERRORLEVEL% NEQ 0 exit /B 1
exit /B 0
