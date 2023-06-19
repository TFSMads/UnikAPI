@echo off

call gradlew clean -Dorg.gradle.java.home="%JAVA_8%"
call gradlew build -Dorg.gradle.java.home="%JAVA_8%"

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0..\merge\UnikAPI-Core.jar"
mkdir "%~dp0../UnikApi-Laby4/core/libs/"
echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0../UnikApi-Laby4/core/libs/UnikAPI-Core.jar"
mkdir "%~dp0../UnikApi-Laby3-v1_8_8/libs/"
echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0../UnikApi-Laby3-v1_8_8/libs/UnikAPI-Core.jar"
mkdir "%~dp0../UnikApi-Laby3-v1_12_2/libs/"
echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0../UnikApi-Laby3-v1_12_2/libs/UnikAPI-Core.jar"
mkdir "%~dp0../UnikApi-Laby3-v1_16_5/libs/"
echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0../UnikApi-Laby3-v1_16_5/libs/UnikAPI-Core.jar"
