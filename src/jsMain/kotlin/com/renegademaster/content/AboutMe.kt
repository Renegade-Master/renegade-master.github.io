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
import com.renegademaster.Constants
import com.renegademaster.components.ContainerInSection
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtDisplay
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtTexts

@Composable
fun AboutMe() {
    ContainerInSection {
        Div({
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
        }) {

            Div({
                classes(
                    WtCols.wtCol10,
                    WtCols.wtColMd8,
                    WtCols.wtColSm12,
                    WtOffsets.wtTopOffsetSm12
                )
            }) {
                H1(attrs = { classes(WtTexts.wtHero) }) {
                    Text("About Me Page!")
                }
            }

            Div({
                classes(WtDisplay.wtDisplayMdNone)
            }) {
                IntroAbout()
            }
        }
    }

    Div(attrs = {
        classes(WtDisplay.wtDisplayNone, WtDisplay.wtDisplayMdBlock)
    }) {
        IntroAbout()
    }
}


@Composable
private fun IntroAbout() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {

        Div({
            classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
        }) {
            P({
                classes(WtTexts.wtSubtitle2, WtOffsets.wtTopOffset24)
                style {
                    whiteSpace("nowrap")
                }
            }) {
                Text("to the Renegade-Master landing page.")
            }

            P({
                classes(WtTexts.wtText1, WtOffsets.wtTopOffset24)
            }) {
                Text("Renegade-Master is the working name for Software developed by ")

                A(href = Constants.Links.renegadeMasterLinkedIn.url, attrs = {
                    classes(WtTexts.wtLink)
                    target(ATarget.Blank)
                }) {
                    Text("Ciaran Bent")
                }
            }

            A(
                attrs = {
                    classes(WtTexts.wtButton, WtOffsets.wtTopOffset24)
                    target(ATarget.Blank)
                },
                href = Constants.Links.renegadeMasterGithub.url
            ) {
                Text("View my projects on GitHub")
            }
        }
    }
}
