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
import com.renegademaster.Constants.Links.githubUrl
import com.renegademaster.Constants.Links.linkedInUrl
import com.renegademaster.Constants.Links.renegadeMasterWebsite
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
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtContainer
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtSections
import org.jetbrains.style.WtTexts


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
                    }) {
                        P({
                            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
                        }) {
                            Text("Follow me")
                        }
                    }

                    Div({
                        classes(WtCols.wtColInline)
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
            Text("Copyright © 2022-2023  Renegade-Master Inc.")
        }

        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Website based on Jetpack Compose for Web examples by JetBrains s.r.o")
        }
    }
}

@Composable
private fun SocialIconLink(link: SocialLink) {
    A(attrs = {
        classes(WtTexts.wtSocialButtonItem)
        target(ATarget.Blank)
    }, href = link.url) {
        Img(src = link.iconSvg) {}
    }
}

private data class SocialLink(
    val id: String,
    val url: String,
    val title: String,
    val iconSvg: String
)

private fun getSocialLinks(): List<SocialLink> {
    return listOf(
        SocialLink("website", renegadeMasterWebsite, "Renegade-Master Website", "favicon_32x32.png"),
        SocialLink("linkedin", linkedInUrl, "Ciaran Bent on Linkedin", "ic_linkedin.svg"),
        SocialLink("github", githubUrl, "Renegade-Master on GitHub", "ic_github.svg"),
    )
}
