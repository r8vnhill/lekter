@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.6.20"
}

group = "cl.ravenhill"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(group = "io.kotest", name = "kotest-property", version = "5.3.0")
  testImplementation(group = "io.kotest", name = "kotest-common", version = "5.3.0")
  implementation(group = "org.jetbrains.exposed", name = "exposed-core", version = "0.38.2")
  implementation(group = "org.jetbrains.exposed", name = "exposed-dao", version = "0.38.2")
  implementation(group = "org.jetbrains.exposed", name = "exposed-jdbc", version = "0.38.2")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}