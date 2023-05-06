chmod +x ./gradlew
./gradlew clean -Dorg.gradle.java.home="$JAVA_17"
./gradlew build -Dorg.gradle.java.home="$JAVA_17"

cp build/libs/UnikAPI-Laby4-release.jar ../merge/UnikAPI-Laby4.jar
