package com.example.simpletextview

object HtmlCleaner {
    fun stripStyleTags(html: String): String {
        return html.replace(Regex("(?s)<style.*?>.*?</style>"), "")
            .replace(Regex("(?s)<title.*?>.*?</title>"), "")
    }
}