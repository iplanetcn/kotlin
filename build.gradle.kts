import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    idea
    kotlin("jvm") version "1.2.71"
    id("com.adarshr.test-logger") version "1.5.0"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("com.google.code.gson:gson:2.8.5")
    testCompile("junit:junit:4.12")
}

testlogger {
    theme = ThemeType.MOCHA
    showStandardStreams = true
}