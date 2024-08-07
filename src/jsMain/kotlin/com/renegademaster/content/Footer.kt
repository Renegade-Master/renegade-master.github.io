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
import com.renegademaster.style.WtTexts.wtSocialButtonItem
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.flexShrink
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtContainer
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtSections
import org.jetbrains.style.WtTexts
import kotlin.js.Date


@Composable
fun PageFooter() {
    Footer({
        style {
            flexShrink(0)
            boxSizing("border-box")
        }
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
                        style {

                        }
                    }) {
                        getSocialLinks().forEach { SocialIconLink(it) }
                    }
                }

                CopyrightInFooter()
            }
        }
    }
}

@Composable
private fun CopyrightInFooter() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter, WtOffsets.wtTopOffset48)
        style {
            justifyContent(JustifyContent.SpaceEvenly)
            flexWrap(FlexWrap.Wrap)
            padding(0.px, 12.px)
        }
    }) {
        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            val currentYear = Date(Date.now()).getFullYear()
            Text("Copyright © 2022-${currentYear}  Renegade-Master Inc.")
        }

        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Website based on ")
            A(href = "https://jb.gg/compose-web", attrs = {
                classes(WtTexts.wtLink)
                target(ATarget.Blank)
            }) {
                Text("Jetpack Compose for Web examples")
            }
            Text(" by JetBrains s.r.o")
        }
    }
}

@Composable
private fun SocialIconLink(link: Constants.Link) {
    A(attrs = {
        classes(wtSocialButtonItem)
        target(ATarget.Blank)
    }, href = link.url) {
        Img(src = link.icon) {}
    }
}

private fun getSocialLinks(): List<Constants.Link> {
    return listOf(
        Constants.Links.renegadeMasterCom,
        Constants.Links.renegadeMasterLinkedIn,
        Constants.Links.renegadeMasterGithub,
        Constants.Links.renegadeMasterEmail,
    )
}
