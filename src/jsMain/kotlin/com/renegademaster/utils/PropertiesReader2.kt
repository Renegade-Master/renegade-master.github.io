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

@JsModule("messageformat-runtime/messages")
@JsNonModule
external object PropertiesReader2 {
    /**
     *
     */
    fun PropertiesReader2(target: Any): PropertiesReader2

    fun get(path: Array<String>, config: JSON): String

    fun get(path: Array<String>): String
}


@JsModule("./app_config.properties")
@JsNonModule
external object app_config
