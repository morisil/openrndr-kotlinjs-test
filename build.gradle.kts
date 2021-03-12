val kotlinVersion = "1.4.31"
val spekVersion = "2.0.0-alpha.2"
val kluentVersion = "1.64"

plugins {
    kotlin("multiplatform") version "1.4.31"
    `maven-publish`
}

group = "org.openrndr"
version = "1.0"

repositories {
    jcenter()
    maven {
        url = uri("https://dl.bintray.com/spekframework/spek-dev/")
    }
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }

    }
    js(IR) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
                runtimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
                implementation("org.amshove.kluent:kluent-common:$kluentVersion")
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}
