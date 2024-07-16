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

package com.renegademaster.style

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.letterSpacing
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.css.unaryMinus
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.width
import org.jetbrains.style.AppCSSVariables
import org.jetbrains.style.AppStylesheet

object WtTexts : StyleSheet(AppStylesheet) {

    val wtHeroLight by style {
        color(Color("#ffffff"))
        fontSize(60.px)
        fontSize(AppCSSVariables.wtHeroFontSize.value(60.px))
        letterSpacing(-1.5.px)
        fontWeight(900)
        lineHeight(64.px)
        lineHeight(AppCSSVariables.wtHeroLineHeight.value(64.px))

        media(mediaMaxWidth(640.px)) {
            self style {
                AppCSSVariables.wtHeroFontSize(42.px)
                AppCSSVariables.wtHeroLineHeight(48.px)
            }
        }

        property(
            "font-family",
            "Gotham SSm A,Gotham SSm B,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

    val wtHeroDark by style {
        color(Color("#131313"))
        fontSize(60.px)
        fontSize(AppCSSVariables.wtHeroFontSize.value(60.px))
        letterSpacing(-1.5.px)
        fontWeight(900)
        lineHeight(64.px)
        lineHeight(AppCSSVariables.wtHeroLineHeight.value(64.px))

        media(mediaMaxWidth(640.px)) {
            self style {
                AppCSSVariables.wtHeroFontSize(42.px)
                AppCSSVariables.wtHeroLineHeight(48.px)
            }
        }

        property(
            "font-family",
            "Gotham SSm A,Gotham SSm B,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

    val wtSubtitle2 by style {
        color(Color("#27282c"))
        fontSize(28.px)
        fontSize(AppCSSVariables.wtSubtitle2FontSize.value(28.px))
        letterSpacing("normal")
        fontWeight(300)
        lineHeight(40.px)
        lineHeight(AppCSSVariables.wtSubtitle2LineHeight.value(40.px))

        media(mediaMaxWidth(640.px)) {
            self style {
                AppCSSVariables.wtSubtitle2FontSize(24.px)
                AppCSSVariables.wtSubtitle2LineHeight(32.px)
            }
        }

        property(
            "font-family",
            "Gotham SSm A,Gotham SSm B,system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

    val wtText1 by style {
        color(rgba(39, 40, 44, .7))
        fontSize(18.px)
        letterSpacing("normal")
        fontWeight(400)
        lineHeight(28.px)

        property(
            "font-family",
            "system-ui,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Oxygen,Ubuntu,Cantarell,Droid Sans,Helvetica Neue,Arial,sans-serif"
        )
    }

    val wtLink by style {
        property("border-bottom", "1px solid transparent")
        property("text-decoration", "none")
        color(Color("#167dff"))

        hover(self) style {
            property("border-bottom-color", "#167dff")
        }
    }

    val wtButton by style {
        color(Color("white"))
        backgroundColor(Color("#167dff"))
        fontSize(15.px)
        display(DisplayStyle.InlineBlock)
        textDecoration("none")
        borderRadius(24.px)
        padding(12.px, 32.px)
        lineHeight(24.px)
        fontWeight(400)
        property("width", "fit-content")

        hover(self) style {
            backgroundColor(rgba(22, 125, 255, .8))
        }
    }

    val wtSocialButtonItem by style {
        marginRight(16.px)
        marginLeft(16.px)
        padding(12.px)
        backgroundColor(Color("transparent"))
        display(DisplayStyle.LegacyInlineFlex)

        hover(self) style {
            backgroundColor(rgba(255, 255, 255, 0.1))
            borderRadius(24.px)
        }

        media(mediaMaxWidth(640.px)) {
            self style {
                marginRight(8.px)
                marginLeft(8.px)
            }
        }

        width(36.px)
        height(36.px)
    }
}
