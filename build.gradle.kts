plugins {
  kotlin("js") version "1.4.30"
  kotlin("plugin.serialization") version "1.4.30"
}

kotlin {
  js(IR) {
    browser()
    binaries.executable()
  }
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0-RC")
}

repositories {
  mavenCentral()
}
