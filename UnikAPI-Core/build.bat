@echo off

call gradlew clean
call gradlew build

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0..\merge\UnikAPI-Core.jar"
