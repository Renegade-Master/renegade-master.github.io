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
    /**
     * Initialize messageResource.js
     *
     * @sample config.filePath - Path(directory) of message resource files.
     * @sample config.fileExtension= .properties] - File extension of message resource files.
     * @sample config.defaultLocale= en_US] - Default locale.
     * @sample config.debugMode= false] - Enable/Disble debug mode.
     *
     * @param config - Configuration JSON object.
     */
    fun init(config: JSON)

    /**
     * Set current locale to be used. This configured locale
     * will be used by load and get functions if locale not specified.
     * If current locale is not set config.defaultLocale will be used as
     * current locale, which is en_US by default.
     *
     * @param locale - Locale identifier like en.
     */
    fun setCurrentLocale(locale: String)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * Module name and locale can be empty or null, then the file name will be
     * resolved to _default.properties.
     */
    fun load()

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * Module name and locale can be empty or null, then the file name will be
     * resolved to _default.properties.
     *
     * @param module - Module name or list of module names.
     */
    fun load(module: String)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * @param module - Module name or list of module names.
     * @param callback - Callback to be executed after loading message resource.
     */
    fun load(module: String, callback: (newValue: String) -> Unit)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * @param module - Module name or list of module names.
     * @param callback - Callback to be executed after loading message resource.
     * @param locale - Locale identifier like en_US. Configured
     *   current locale will be used if not given.
     */
    fun load(module: String, callback: (newValue: String) -> Unit, locale: String)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * @param module - Module name or list of module names.
     * @param locale - Locale identifier like en_US. Configured
     *   current locale will be used if not given.
     * @param callback - Callback to be executed after loading message resource.
     */
    fun load(module: List<String>)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * @param module - Module name or list of module names.
     * @param locale - Locale identifier like en_US. Configured
     *   current locale will be used if not given.
     * @param callback - Callback to be executed after loading message resource.
     */
    fun load(module: List<String>, callback: (newValue: String) -> Unit)

    /**
     * Load a message resource file. The file name is constructed based on
     * the given module name and locale.
     *
     * @param module - Module name or list of module names.
     * @param locale - Locale identifier like en_US. Configured
     *   current locale will be used if not given.
     * @param callback - Callback to be executed after loading message resource.
     */
    fun load(module: List<String>, callback: (newValue: String) -> Unit, locale: String)

    /**
     * Get property value from loaded message resource files.
     *
     * @param key - Message resource property key.
     *
     * @return Message resource property value if exists else defaultValue passed.
     */
    fun get(key: String): String

    /**
     * Get property value from loaded message resource files.
     *
     * @param key - Message resource property key.
     * @param module - Module name
     *
     * @return Message resource property value if exists else defaultValue passed.
     */
    fun get(key: String, module: String): String

    /**
     * Get property value from loaded message resource files.
     *
     * @param key - Message resource property key.
     * @param module - Module name
     * @param locale - Locale identifier like en. Configured
     *        current locale will be used if not given.
     *
     * @return Message resource property value if exists else defaultValue passed.
     */
    fun get(key: String, module: String, locale: String): String

    /**
     * Get property value from loaded message resource files.
     *
     * @param key - Message resource property key.
     * @param module - Module name
     * @param locale - Locale identifier like en. Configured
     *        current locale will be used if not given.
     * @param defaultValue - Default value to return if value not found.
     *        If defaultValue is empty key will be used as defaultValue.
     *
     * @return Message resource property value if exists else defaultValue passed.
     */
    fun get(key: String, module: String, locale: String, defaultValue: String): String

}
