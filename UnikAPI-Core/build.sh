chmod +x ./gradlew
./gradlew clean -Dorg.gradle.java.home=$JAVA_8
./gradlew build -Dorg.gradle.java.home=$JAVA_8

cp build/libs/UnikAPI-Core-1.0-all.jar ../merge/UnikAPI-Core.jar
mkdir ../UnikApi-Laby4/core/libs/
cp build/libs/UnikAPI-Core-1.0-all.jar ../UnikApi-Laby4/core/libs/UnikAPI-Core.jar
mkdir ../UnikApi-Laby3-v1_8_8/libs/
cp build/libs/UnikAPI-Core-1.0-all.jar ../UnikApi-Laby3-v1_8_8/libs/UnikAPI-Core.jar
mkdir ../UnikApi-Laby3-v1_12_2/libs/
cp build/libs/UnikAPI-Core-1.0-all.jar ../UnikApi-Laby3-v1_12_2/libs/UnikAPI-Core.jar
mkdir ../UnikApi-Laby3-v1_16_5/libs/
cp build/libs/UnikAPI-Core-1.0-all.jar ../UnikApi-Laby3-v1_16_5/libs/UnikAPI-Core.jar

