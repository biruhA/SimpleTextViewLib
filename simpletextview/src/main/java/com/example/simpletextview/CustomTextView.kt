package com.example.simpletextview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.withStyledAttributes

class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatTextView(context, attrs, defStyle) {

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomTextView) {
            val customText = getString(R.styleable.CustomTextView_customText)
            text = customText ?: "Default Text"
        }
    }

    fun setCustomText(value: String) {
        text = value
    }
}