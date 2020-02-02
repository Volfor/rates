package com.gitlab.volfor.rates.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.hideKeyboard(v: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(v.windowToken, 0)
}

fun Activity.hideKeyboard() = hideKeyboard(currentFocus ?: View(this))

fun Context.showKeyboard(v: View) {
    v.requestFocus()
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
}