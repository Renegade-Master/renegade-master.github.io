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

package com.renegademaster

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.renegademaster.components.Layout
import com.renegademaster.components.MainContentLayout
import com.renegademaster.content.AboutMe
import com.renegademaster.content.Header
import com.renegademaster.content.Intro
import com.renegademaster.content.PageFooter
import com.renegademaster.content.ProjectListing
import com.renegademaster.content.ProjectSamples
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
            val page = remember { mutableStateOf(Constants.Page.LANDING) }

            Header(page)

            MainContentLayout {
                when (page.value) {
                    Constants.Page.LANDING -> {
                        Intro()
                        ProjectSamples()
                    }

                    Constants.Page.ABOUT -> {
                        AboutMe()
                    }

                    Constants.Page.PROJECTS -> {
                        ProjectListing()
                    }
                }
            }

            PageFooter()
        }
    }
}
