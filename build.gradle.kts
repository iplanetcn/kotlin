import com.adarshr.gradle.testlogger.theme.ThemeType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


buildscript {
    repositories { jcenter() }
}

plugins {
    idea
    kotlin("jvm") version "1.3.31"
    id("com.adarshr.test-logger") version "1.6.0"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.0")
    implementation("com.google.code.gson:gson:2.8.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
}

tasks.withType<Wrapper> {
    gradleVersion = "5.4.1"
    distributionType = Wrapper.DistributionType.ALL
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

testlogger {
    theme = ThemeType.MOCHA
    showStandardStreams = true
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}