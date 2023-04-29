import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ml.volder"
version = "1.0"



repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.10.1")

    shadow("org.reflections:reflections:0.10.2")
}


tasks.test {
    useJUnitPlatform()
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    named<ShadowJar>("shadowJar") {
        configurations = listOf(project.configurations.shadow.get())
        archiveBaseName.set("UnikAPI-Core")
        mergeServiceFiles()
    }
}