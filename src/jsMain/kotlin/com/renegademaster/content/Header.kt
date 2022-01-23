package com.renegademaster.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
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
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {
                Logo()
                Banner()
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
        }, href = "https://github.com/Renegade-Master/") {
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
