@echo off

call gradlew clean -Dorg.gradle.java.home="%JAVA_17%"
call gradlew build -Dorg.gradle.java.home="%JAVA_17%"

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Laby4-release.jar" "%~dp0..\merge\UnikAPI-Laby4.jar"
