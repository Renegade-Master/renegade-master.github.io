plugins {
    kotlin("multiplatform") version "2.0.10"
    id("org.jetbrains.compose") version "1.6.11"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

group = "com.renegademaster"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true

                useKarma {
                    useFirefox()
                }
            }
        }

        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)

                implementation(npm("highlight.js", "11.8.0"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
