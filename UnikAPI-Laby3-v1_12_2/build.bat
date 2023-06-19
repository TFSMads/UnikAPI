@echo off

call gradlew clean -Dorg.gradle.java.home="%JAVA_8%"
call gradlew build -Dorg.gradle.java.home="%JAVA_8%"

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-1.0.jar" "%~dp0..\merge\UnikAPI-Laby3-v1_12_2.jar"
