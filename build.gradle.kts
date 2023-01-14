plugins {
    kotlin("multiplatform") version "1.7.20"
    id("org.jetbrains.compose") version "1.2.2"
}

group = "com.renegademaster"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true

                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }

        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation(npm("highlight.js", "10.7.2"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
