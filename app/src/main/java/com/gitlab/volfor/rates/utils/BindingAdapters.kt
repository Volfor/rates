package com.gitlab.volfor.rates.utils

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

@BindingConversion
fun convertBooleanToVisibility(isVisible: Boolean) = if (isVisible) View.VISIBLE else View.GONE

@BindingAdapter("currencyFlag")
fun setCurrencyFlagImage(v: ImageView, currencyCode: String) {
    val resName = "ic_${currencyCode.toLowerCase()}"
    val resId = v.resources.getIdentifier(resName, "drawable", v.context.packageName)
    val drawable = if (resId != 0) ContextCompat.getDrawable(v.context, resId) else null
    v.setImageDrawable(drawable)
}

@BindingAdapter("isLink")
fun setLinkMovementMethod(v: TextView, isLink: Boolean) {
    if (isLink) v.movementMethod = LinkMovementMethod.getInstance()
}