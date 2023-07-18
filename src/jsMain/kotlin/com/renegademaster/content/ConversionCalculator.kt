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
import com.renegademaster.Constants.LinkBuilders.exchangeRateApi
import com.renegademaster.components.ContainerInSection
import com.renegademaster.external.axios
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.style.WtCols
import org.jetbrains.style.WtDisplay
import org.jetbrains.style.WtOffsets
import org.jetbrains.style.WtRows
import org.jetbrains.style.WtTexts

@Composable
fun ConversionCalculator() {
    ContainerInSection {
        Div({
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
        }) {

            Div({
                classes(
                    WtCols.wtCol10,
                    WtCols.wtColMd8,
                    WtCols.wtColSm12,
                    WtOffsets.wtTopOffsetSm12
                )
            }) {
                H1(attrs = { classes(WtTexts.wtHero) }) {
                    Text("Conversion Calculator Page!")
                }
            }

            Div({
                classes(WtDisplay.wtDisplayMdNone)
            }) {
                Calculator()
            }
        }
    }
}

@Composable
private fun Calculator() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {

        Div({
            classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
        }) {
            P(attrs = { classes(WtTexts.wtText1) }) {
                Text("This is a test")
            }
            Text(getApiRates())
        }
    }
}

private fun getApiRates(): String {
    var response = ""

    axios(exchangeRateApi)
        .then { resp ->
            console.log("Running then")
            response = resp.toString()
        }.catch { err ->
            console.log("Error occurred: $err")
        }.finally {
            console.log("Finally")
        }

    return response
}
