package com.example.simpletextview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.FrameLayout

class HtmlView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val webView: WebView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.html_view, this, true)
        webView = view.findViewById(R.id.webview)
        setupWebView()
    }

    private fun setupWebView() {
        webView.settings.javaScriptEnabled = false
        webView.setBackgroundColor(Color.TRANSPARENT)
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
    }

    fun loadStyledHtml(rawHtml: String, themeColor: Int = Color.WHITE) {
        val hexColor = String.format("#%06X", 0xFFFFFF and themeColor)
        val cleaned = HtmlCleaner.stripStyleTags(rawHtml)

        val html = HtmlStyler.injectTheme(cleaned, hexColor)
        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
    }
}