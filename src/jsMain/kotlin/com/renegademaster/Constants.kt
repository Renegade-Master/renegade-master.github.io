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

/**
 * Constant values to be used across the project.
 */
object Constants {

    enum class Page {
        LANDING,
        ABOUT,
        PROJECTS
    }

    object Strings {
        val username = "Renegade-Master"
    }

    /**
     * Structure for holding information to display links to external sites
     */
    data class Link(
        val id: String,
        val url: String,
        val title: String,
        val icon: String,
    )

    object Links {
        val renegadeMasterCom: Link =
            Link("website", "https://renegade-master.com/", "Renegade-Master Website", "favicon_32x32.png")
        val renegadeMasterLinkedIn: Link =
            Link("linkedin", "https://www.linkedin.com/in/ciaran-bent/", "Ciaran Bent on LinkedIn", "ic_linkedin.svg")
        val renegadeMasterGithub: Link =
            Link("github", "https://github.com/Renegade-Master", "Renegade-Master on GitHub", "ic_github.svg")
        val renegadeMasterEmail: Link =
            Link("email", "mailto:webmaster.portly274@passfwd.com", "Renegade-Master Secure Email", "ic_mail.svg")
    }

    object LinkBuilders {
        val personalVercelAppApi = "https://renegade-readme-stats.vercel.app/api/"
    }
}
