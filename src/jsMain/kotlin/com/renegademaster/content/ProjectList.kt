/*
 *    Copyright 2023 Renegade-Master [renegade@renegade-master.com]
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.renegademaster.HighlightJs
import com.renegademaster.components.ContainerInSection
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.pt
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtTexts
import org.w3c.dom.HTMLElement

private fun HTMLElement.setHighlightedCode(code: String) {
    innerText = code
    HighlightJs.highlightElement(this)
}

private val projectZomboidProject = ProjectData(
    title = "Project Zomboid Dedicated Server",
    link = "https://github.com/Renegade-Master/zomboid-dedicated-server"
)

private val steamCmdMinimalProject = ProjectData(
    title = "Minimum SteamCMD Binary Base Image",
    link = "https://github.com/Renegade-Master/steamcmd-minimal"
)

private val asusWrtGoClient = ProjectData(
    title = "Go Client for ASUS WRT Routers",
    link = "https://github.com/Renegade-Master/asuswrt-api"
)

private val allProjects = arrayOf(
    projectZomboidProject,
    asusWrtGoClient,
    steamCmdMinimalProject,
)

private var currentProject: ProjectData by mutableStateOf(allProjects[0])
private var selectedProjectIx: Int by mutableStateOf(0)


@Composable
fun ProjectSamples() {
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

        ProjectSample(title = currentProject.title, link = currentProject.link)
    }
}


@Composable
private fun ProjectSample(title: String, link: String) {
    H3({
        classes(WtTexts.wtH3, WtOffsets.wtTopOffset48)
    }) {
        Text(title)
    }

    Div({
        classes(WtOffsets.wtTopOffset24)
        style {
            backgroundColor(rgba(39, 40, 44, 0.05))
            borderRadius(8.px, 8.px, 8.px)
            padding(12.px, 16.px)
        }
    }) {
        ProjectSampleCard(link = link)
    }
}

@Composable
fun ProjectSampleCard(link: String, language: String = "kotlin") {
    Pre({
        style {
            maxHeight(25.em)
            overflow("auto")
            height(auto)
        }
    }) {
        Code({
            classes("language-$language", "hljs")
            style {
                property("font-family", "'JetBrains Mono', monospace")
                property("tab-size", 4)
                fontSize(10.pt)
                backgroundColor(Color("transparent"))
            }
        }) {
            DisposableEffect(link) {
                scopeElement.setHighlightedCode(link)
                onDispose { }
            }
        }
    }
}

private data class ProjectData(
    val title: String,
    val link: String
)
