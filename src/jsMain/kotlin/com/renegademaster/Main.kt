package com.renegademaster

import com.renegademaster.content.Header
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
            MainContentLayout {
//                Intro()
            }
//            PageFooter()
        }
    }
}
