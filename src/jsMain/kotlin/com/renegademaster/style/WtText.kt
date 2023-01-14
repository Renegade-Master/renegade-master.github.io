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

package com.renegademaster.style

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.width
import org.jetbrains.style.AppStylesheet

object WtTexts : StyleSheet(AppStylesheet) {

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
