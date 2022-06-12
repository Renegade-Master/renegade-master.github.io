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

import com.renegademaster.utils.PropertiesReader2.PropertiesReader2

/**
 *  Manages access to the Resources.
 */
object ResourceHandler {
    val extension: String = ".properties"
    val debugMode: Boolean = true
    val locale: String = getConfigValue2("default.locale")
    val properties: Map<String, String> = loadProperties(locale)

    /**
     *  Retrieves a String from a resources file by the given ID.
     *
     *  @param id The ID of the String to retrieve.
     *  @return The String with the given ID.
     */
    fun getString(id: String, counter: Int = 0): String {
        js("console.log('This is message [' + counter + ']');")
        return properties[id] ?: "NOT_FOUND"
    }

    private fun getConfigValue2(key: String): String {
        val propertiesReader: PropertiesReader2 = PropertiesReader2(app_config)

        propertiesReader.get(arrayOf("default", "locale"))

        return "NOT_IMPLEMENTED"
    }

    private fun getConfigValue(key: String): String {
        val propertiesReader: PropertiesReader = PropertiesReader
        val locale: String = "config"
        val readerConfig: JSON = JSON.parse(
            """
            {
                "filePath": "./",
                "fileExtension": "$extension",
                "defaultLocale": "$locale",
                "debugMode": "$debugMode"
            }
            """.trimIndent()
        )

        propertiesReader.init(readerConfig)

        propertiesReader.load("app_config")

        val justReadValue = propertiesReader.get(key, "app_config", locale, "VALUE_NOT_FOUND")

        return justReadValue
    }

    private fun loadProperties(locale: String): Map<String, String> {
        val propertiesReader: PropertiesReader = PropertiesReader
        val readerConfig: JSON = JSON.parse(
            """
            {
                "filePath": "./strings/",
                "fileExtension": "$extension",
                "defaultLocale": "$locale",
                "debugMode": "$debugMode"
            }
            """.trimIndent()
        )

        propertiesReader.init(readerConfig)

        propertiesReader.load("strings", ::testCallBack, locale)

        val justReadValue = propertiesReader.get("navigation.destination.about", "strings", locale, "VALUE_NOT_FOUND")

        console.log("Just read value: $justReadValue")

        val propertyFile: Map<String, String> = when (locale) {
            "de" -> mapOf(
                "hello" to "Hallo Welt", "goodbye" to "Tschüss Welt"
            )
            "fr" -> mapOf(
                "hello" to "Bonjour le monde", "goodbye" to "Au revoir le monde"
            )
            "test" -> {
                mapOf("hello" to "Hello Test", "goodbye" to "Goodbye Test")
            }
            else -> mapOf(
                "hello" to "Hello World", "goodbye" to "Goodbye World"
            )
        }

        return propertyFile
    }

    private fun testCallBack(newValue: String) {
        console.log("This is a test print statement")
        console.log("New value is: $newValue")
    }
}
