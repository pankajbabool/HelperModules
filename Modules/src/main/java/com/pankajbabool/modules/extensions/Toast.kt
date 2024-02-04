package com.pankajbabool.modules.extensions

import android.content.Context
import android.widget.Toast

fun Any?.extShowToast(context: Context, message: String, duration: Int = Toast.LENGTH_LONG) {
    context.extShowDebugLog("Toast: $message")
    Toast.makeText(context, message, duration).show()
}