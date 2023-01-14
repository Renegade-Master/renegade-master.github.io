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

import org.w3c.dom.HTMLElement

/**
 * API Interface for the HighlightJS NPM library
 */
@JsName("hljs")
@JsModule("highlight.js")
@JsNonModule
external class HighlightJs {
    companion object {
        /**
         * Applies highlighting to a DOM node containing code.
         *
         * This function is the one to use to apply highlighting dynamically after page load or within initialization
         * code of third-party JavaScript frameworks.
         *
         * The function uses language detection by default, but you can specify the language in the class attribute of
         * the DOM node. See the scopes reference for all available language names and scopes.
         */
        fun highlightElement(block: HTMLElement)
    }
}
