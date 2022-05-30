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

package com.renegademaster.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.renegademaster.utils.ResourceHandler.getString
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtContainer
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtSections
import org.jetbrains.style.WtTexts


/**
 * Navigation component to facilitate navigation between pages
 */
@Composable
fun Navigation() {
    var counter: Int = remember { 0 }
    var btnText = remember { "Press Me" }
    var btnCounter = remember { 0 }

    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {
                NavItem(getString("hello", counter++), "https://renegade-master.github.io/")
            }
        }
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {


                Button(attrs = {
                    onClick {
                        btnCounter++
                        btnText = "Pressed $btnCounter times"
                        js("console.log('Pressed ' + btnCounter + ' times')")
                        console.log("Pressed [$btnCounter] times")
                    }

                }) {
                    Text(btnText)
                }
            }
        }
    }
}

/**
 * A simple navigation item
 *
 * @param name The name of the navigation item
 * @param url The url of the navigation item
 */
@Composable
fun NavItem(name: String, url: String) {

    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        H1(attrs = {
            classes(WtCols.wtColInline, WtTexts.wtHero, WtTexts.wtText1ThemeDark)
        }) {
            A(attrs = {
                target(ATarget.Blank)
            }, href = url) {
                Button(attrs = {

                }) {
                    Text(name)
                }
            }
        }
    }
}
