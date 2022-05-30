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

package com.renegademaster.utils

@JsModule("./messageResource.js")
@JsNonModule

external object PropertiesReader {
    fun init(config: Map<String, Any>)

    fun setCurrentLocale(locale: String)

    fun load(fileName: String, callBackFunction: (newValue: String) -> Unit, locale: String)
    fun load(fileNames: List<String>, callBackFunction: (newValue: String) -> Unit, locale: String)

    fun get(key: String, moduleName: String, locale: String, defaultValue: String): String
}
