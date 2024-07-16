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
import androidx.compose.runtime.MutableState
import com.renegademaster.Constants
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtContainer
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtSections
import org.jetbrains.style.WtTexts

@Composable
fun Header(page: MutableState<Constants.Page>) {
    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {
                Logo()
                Banner()
                Navigation(page)
            }
        }
    }
}

@Composable
private fun Logo() {
    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        A(attrs = {
            target(ATarget.Blank)
        }, href = Constants.Links.renegadeMasterCom.url) {
            Div(attrs = {
                classes("renegademaster-logo", "_logo-renegademaster", "_size-3")
            }) {}
        }
    }
}

@Composable
private fun Banner() {
    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        H1(attrs = {
            classes(WtCols.wtColInline, WtTexts.wtHero, WtTexts.wtText1ThemeDark)
        }) {
            Text("Renegade Master")
        }
    }
}

@Composable
private fun Navigation(page: MutableState<Constants.Page>) {
    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        Section({
            classes(WtSections.wtSectionBgGrayDark)
            style {
                padding(24.px, 0.px)
            }
        }) {
            Div({ classes(WtContainer.wtContainer) }) {
                Div({
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
                    style {
                        justifyContent(JustifyContent.Center)
                        flexWrap(FlexWrap.Wrap)
                    }
                }) {

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        P({
                            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
                        }) {
                            Text("Links")
                        }
                    }

                    Div({
                        classes(WtCols.wtColInline)
                        style {

                        }
                    }) {
                        Button(attrs = {
                            onClick { page.value = Constants.Page.values().random() }
                        }) {
                            Text("Change Page")
                        }
                    }
                }
            }
        }
    }
}
