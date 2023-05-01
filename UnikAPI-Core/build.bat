@echo off

call gradlew clean -Dorg.gradle.java.home="C:\Program Files\Java\jdk1.8.0_281"
call gradlew build -Dorg.gradle.java.home="C:\Program Files\Java\jdk1.8.0_281"

echo F|xcopy /F /Y "%~dp0/build/libs/UnikAPI-Core-1.0-all.jar" "%~dp0..\merge\UnikAPI-Core.jar"
