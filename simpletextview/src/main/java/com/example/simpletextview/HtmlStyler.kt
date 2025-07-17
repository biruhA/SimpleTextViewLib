package com.example.simpletextview

object HtmlStyler {
    fun injectTheme(content: String, hexColor: String): String {
        return """
            <html>
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body {
                        background-color: $hexColor;
                        color: #222222;
                        font-family: 'Roboto', sans-serif;
                        font-size: 16px;
                        margin: 0;
                        padding: 0;
                    }
                    h1, h2, h3, h4 { font-weight: bold; color: black; }
                    p, li, ul { margin: 0; padding: 0; line-height: 1.6; }
                </style>
            </head>
            <body>$content</body>
            </html>
        """.trimIndent()
    }
}