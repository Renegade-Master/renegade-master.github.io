# Renegade-Master Website

# References

Makes use of the [JetBrains Official Compose Documentation](https://github.com/JetBrains/compose-jb/) for structural
templates, and to help understand how Compose for Web is supposed to work.

Examples that I learned from to create this website can be found under
the [`examples` directory](https://github.com/JetBrains/compose-jb/tree/master/examples). All JetBrains files taken from
their examples are held in their unmodified state under the [`org.jetbrains`](./src/jsMain/kotlin/org/jetbrains/)
package.

## Description

This repository hosts the source code for my personal website.

The website is written in Kotlin '[Compose for Web](https://compose-web.ui.pages.jetbrains.team/)' by JetBrains, and
compiled using Gradle.

The source is hosted on this [`main`](https://github.com/Renegade-Master/renegade-master.github.io) branch, while the
compiled web files are stored on the
[`gh-pages`](https://github.com/Renegade-Master/renegade-master.github.io/tree/gh-pages) branch.

Changes to the code in this `main` branch are automatically pushed to the `gh-pages` branch using GitHub Actions.

The website can be viewed at [`renegade-master.com`](https://renegade-master.com)
or [`renegade-master.github.io`](https://renegade-master.github.io).

## Building

### Updating

#### DevContainer

This section details how to update/modify the default DevContainer configuration.

* [Reference](https://containers.dev/implementors/json_reference/)
* [Schema](https://containers.dev/implementors/json_reference/#schema)

#### Languages/Build Frameworks

This section details how to update the dependencies of this project.

| Dependency     | Link                                                                                                                            |
|----------------|---------------------------------------------------------------------------------------------------------------------------------|
| Gradle         | [Compatibility](https://docs.gradle.org/current/userguide/compatibility.html#kotlin)                                            |
| Kotlin Compose | [Compatibility and Versions](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-compatibility-and-versioning.html) |

| Dependency                          | Gradle Link                                                                   |
|-------------------------------------|-------------------------------------------------------------------------------|
| org.jetbrains.compose               | [Link](https://plugins.gradle.org/plugin/org.jetbrains.compose)               |
| org.jetbrains.kotlin.plugin.compose | [Link](https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.compose) |
