chmod +x ./gradlew
./gradlew clean -Dorg.gradle.java.home=$JAVA_HOME_8_x64
./gradlew build -Dorg.gradle.java.home=$JAVA_HOME_8_x64

cp build/libs/UnikAPI-Core-1.0-all.jar ../merge/UnikAPI-Core.jar
