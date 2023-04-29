@echo off

call gradlew clean
call gradlew build

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Laby4-release.jar" "%~dp0..\merge\UnikAPI-Laby4.jar"
