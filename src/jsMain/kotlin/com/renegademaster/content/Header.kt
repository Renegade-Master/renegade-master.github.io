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
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtContainer
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtSections
import org.jetbrains.style.WtTexts

@Composable
fun header(page: MutableState<Constants.Page>, theme: MutableState<Constants.Theme>) {
    val headerTheme = if (theme.value == Constants.Theme.LIGHT)
        WtSections.wtSectionBgGrayDark
    else WtSections.wtSectionBgGrayLight

    Section(attrs = {
        classes(headerTheme)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {
                logo()
                banner(theme)
                navigation(page, theme)
                theme(theme)
            }
        }
    }
}

@Composable
private fun logo() {
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
private fun banner(theme: MutableState<Constants.Theme>) {
    val headerTheme = if (theme.value == Constants.Theme.LIGHT)
        WtTexts.wtText1ThemeLight
    else WtTexts.wtText1ThemeDark

    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        H1(attrs = {
            classes(WtCols.wtColInline, WtTexts.wtHero, headerTheme)
        }) {
            Text("Renegade Master")
        }
    }
}

@Composable
private fun navigation(page: MutableState<Constants.Page>, theme: MutableState<Constants.Theme>) {
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
                        classes(WtCols.wtColInline, WtTexts.wtButton)
                    }) {
                        A(attrs = {
                            classes(WtCols.wtColInline)
                            target(ATarget.Blank)
                            onClick { page.value = Constants.Page.entries.toTypedArray().random() }
                        }) {
                            Text("Change Page")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun theme(theme: MutableState<Constants.Theme>) {
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
                        classes(WtCols.wtColInline, WtTexts.wtButton)
                    }) {
                        A(attrs = {
                            classes(WtCols.wtColInline)
                            target(ATarget.Blank)
                            onClick { theme.value = theme.value.swap(theme) }
                        }) {
                            Text("Change Theme")
                        }
                    }
                }
            }
        }
    }
}
