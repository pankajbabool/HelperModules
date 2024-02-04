package com.pankajbabool.modules.extensions

import android.view.View
import android.view.ViewGroup

fun View.extMakeEnabled() {
    isEnabled = true
}

fun View.extMakeDisabled() {
    isEnabled = false
}

fun View.extMakeGone() {
    visibility = View.GONE
}

fun View.extMakeVisible() {
    visibility = View.VISIBLE
}

fun View.extMakeInvisible() {
    visibility = View.INVISIBLE
}

fun Any?.extClearFocusFromAllViews(view: View) {
    if (view is ViewGroup)
        for (i in 0 until view.childCount) {
            extClearFocusFromAllViews(view.getChildAt(i))
        }
    else {
        view.clearFocus()
    }
}