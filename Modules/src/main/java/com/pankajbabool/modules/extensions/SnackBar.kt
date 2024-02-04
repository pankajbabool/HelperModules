package com.pankajbabool.modules.extensions

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Any?.extShowSnackBar(
    activity: Activity,
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    maxLines: Int = 3,
    buttonText: String? = null,
    listener: View.OnClickListener? = null
) {
    activity.extShowDebugLog("SnackBar: $message")
    val snackBar = Snackbar.make(activity.findViewById(android.R.id.content), message, duration)
    snackBar.setTextMaxLines(maxLines)
    if (buttonText != null && listener != null) {
        snackBar.setAction(buttonText, listener)
    }
    snackBar.show()
}

fun Any?.extShowSnackBar(
    view: View,
    message: String,
    duration: Int = Snackbar.LENGTH_LONG,
    maxLines: Int = 3,
    actionText: String? = null,
    listener: View.OnClickListener? = null
) {
    view.extShowDebugLog("SnackBar: $message")
    val snackBar = Snackbar.make(view, message, duration)
    snackBar.setTextMaxLines(maxLines)
    if (actionText != null && listener != null) {
        snackBar.setAction(actionText, listener)
    }
    snackBar.show()
}