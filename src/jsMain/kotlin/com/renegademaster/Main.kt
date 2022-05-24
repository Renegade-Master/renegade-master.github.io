/*
 *    2022 Renegade-Master [Ciaran Bent] <renegade.master.dev@protonmail.com>
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

package com.renegademaster

import com.renegademaster.content.Header
import com.renegademaster.content.Navigation
import org.jetbrains.components.Layout
import org.jetbrains.components.MainContentLayout
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.style.AppStylesheet

/**
 * Main entry point for the application.
 */
fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        Layout {
            Header()
            Navigation()
            MainContentLayout {
//                Intro()
            }
//            PageFooter()
        }
    }
}
