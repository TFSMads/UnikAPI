chmod +x ./gradlew
./gradlew clean -Dorg.gradle.java.home=$JAVA_8
./gradlew build -Dorg.gradle.java.home=$JAVA_8

cp build/libs/UnikAPI-Core-1.0-all.jar ../merge/UnikAPI-Core.jar
cp build/libs/UnikAPI-Core-1.0-all.jar ../UnikApi-Laby4/core/libs/UnikAPI-Core.jar

