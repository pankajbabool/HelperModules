package com.pankajbabool.modules.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Any?.extShowKeyboard(view: View) {
    view.requestFocus()
    val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}
fun Any?.extHideKeyboard(view: View) {
    val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}