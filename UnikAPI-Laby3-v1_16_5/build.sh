chmod +x ./gradlew
./gradlew clean -Dorg.gradle.java.home="$JAVA_8"
./gradlew build -Dorg.gradle.java.home="$JAVA_8"

cp build/libs/UnikAPI-1.0.0.jar ../merge/UnikAPI-Laby3-v1_16_5.jar
