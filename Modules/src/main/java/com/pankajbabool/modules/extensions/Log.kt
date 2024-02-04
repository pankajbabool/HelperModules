package com.pankajbabool.modules.extensions

import android.util.Log

fun Any.extShowErrorLog(message: String) {
    Log.e(this::class.java.simpleName, message)
}

fun Any.extShowDebugLog(message: String) {
    Log.d(this::class.java.simpleName, message)
}