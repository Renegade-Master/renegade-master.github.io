/*
 *    Copyright 2024 Renegade-Master [webmaster.portly274@passfwd.com]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.renegademaster.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.renegademaster.Constants.LinkBuilders.personalVercelAppApi
import com.renegademaster.Constants.Strings.username
import com.renegademaster.components.ContainerInSection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtTexts

private val personalWebsite = ProjectData(
    title = "This website",
    description = """
        A personal website created using the Kotlin Jetpack Compose library by JetBrains and Google. The source code is 
        stored on GitHub with an Action to automatically upload new files to be hosted using GitHub Pages. Finally, the 
        domain is registered using CloudFlare.
    """.trimIndent(),
    repo = "renegade-master.github.io",
    link = "https://github.com/Renegade-Master/renegade-master.github.io"
)

private val dotfiles = ProjectData(
    title = "My Dotfiles",
    description = """
        This repository contains the configuration files that I generally use. There are configurations and scripts that
         can be used for me to quickly set up my working environment on any host.
    """.trimIndent(),
    repo = "dotfiles",
    link = "https://github.com/Renegade-Master/dotfiles"
)

private val projectZomboidProject = ProjectData(
    title = "Project Zomboid Dedicated Server",
    description = """
        A simple Container Image for running a Project Zomboid Dedicated Server. Contains RCON for remote Server 
        Administration.
    """.trimIndent(),
    repo = "zomboid-dedicated-server",
    link = "https://github.com/Renegade-Master/zomboid-dedicated-server"
)

private val steamCmdMinimalProject = ProjectData(
    title = "Minimum SteamCMD Binary Base Image",
    description = """
        A Container Image containing the minimum runtime requirements for a SteamCMD binary. Intended to be used as a 
        base image for building other images with.
    """.trimIndent(),
    repo = "steamcmd-minimal",
    link = "https://github.com/Renegade-Master/steamcmd-minimal"
)

private val asusWrtGoClient = ProjectData(
    title = "Go Client for ASUS WRT Routers",
    description = """
        A HTTP/S Client written in Golang for interacting with the undocumented ASUS WRT API. Using this package it is 
        possible to monitor and administrate Asus Routers running the AsusWRT firmware.
    """.trimIndent(),
    repo = "asuswrt-api",
    link = "https://github.com/Renegade-Master/asuswrt-api"
)

private val allProjects = arrayOf(
    personalWebsite,
    dotfiles,
    projectZomboidProject,
    steamCmdMinimalProject,
    asusWrtGoClient,
)

private var currentProject: ProjectData by mutableStateOf(allProjects[0])
private var selectedProjectIx: Int by mutableStateOf(0)


/**
 * This Composable is for displaying a Switcher containing Projects to be displayed.
 */
@Composable
fun projectSamples() {
    ContainerInSection {
        Div({
            classes(WtRows.wtRow)
            style {
                justifyContent(JustifyContent.SpaceBetween)
            }
        }) {
            Div({ classes(WtCols.wtCol6, WtCols.wtColMd4, WtCols.wtColSm12) }) {
                H1({
                    classes(WtTexts.wtH2)
                }) {
                    Text("Public Projects")
                }
            }

            Div({ classes(WtOffsets.wtTopOffsetSm24) }) {
                ProjectSwitcher(count = allProjects.size, current = selectedProjectIx) {
                    selectedProjectIx = it
                    currentProject = allProjects[it]
                }
            }
        }

        projectShowcase(currentProject)
    }
}


@Composable
private fun projectShowcase(project: ProjectData) {
    H3({
        classes(WtTexts.wtH3, WtOffsets.wtTopOffset48)
    }) {
        Text(project.title)
    }

    Div({
        classes(WtOffsets.wtTopOffset24)
        style {
            backgroundColor(rgba(39, 40, 44, 0.05))
            borderRadius(8.px, 8.px, 8.px)
            padding(12.px, 16.px)
        }
    }) {
        projectShowcaseCard(project)
    }
}

@Composable
private fun projectShowcaseCard(project: ProjectData) {
    Div({
        style {
            maxHeight(25.em)
            overflow("auto")
            height(auto)
        }
    }) {
        A(
            href = project.link
        ) {
            Img(
                src = "${personalVercelAppApi}/pin/?username=${username}&repo=${project.repo}"
            )
        }

        P({
            classes(WtTexts.wtText1, WtOffsets.wtTopOffset24)
        }) {
            Text(project.description)
        }
    }
}

private data class ProjectData(
    val title: String,
    val description: String = "",
    val repo: String,
    val link: String,
)
