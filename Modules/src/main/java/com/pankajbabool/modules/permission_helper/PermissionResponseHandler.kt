package com.pankajbabool.modules.permission_helper

interface PermissionResponseHandler {
    val permission: String
    fun onPermanentlyDenied() = Unit
    fun onRationalAvailable() = Unit
    fun onRejected() = Unit
    fun onGranted() = Unit
}