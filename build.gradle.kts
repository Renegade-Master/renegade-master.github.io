import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.renegademaster"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
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
            kotlin.srcDir("src/jsMain/kotlin")
            resources.srcDir("src/jsMain/resources")

            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }

        val jsTest by getting {
            kotlin.srcDir("src/jsTest/kotlin")
            resources.srcDir("src/jsTest/resources")

            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

// BUG [2022/05/25]: Workaround to fix Gradle 7 insisting that there is a file
//  duplication error for everything in the resources folder.
tasks.named<Copy>("jsProcessResources") {
    duplicatesStrategy = DuplicatesStrategy.WARN
}
