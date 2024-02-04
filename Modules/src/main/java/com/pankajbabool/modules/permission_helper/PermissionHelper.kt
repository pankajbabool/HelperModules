package com.pankajbabool.modules.permission_helper

import android.view.View
import androidx.activity.ComponentActivity

interface PermissionHelper {

    fun ComponentActivity.superInitPermissionHelperInOnCreate()

    fun ComponentActivity.superIsGranted(permission: String): Boolean

    fun ComponentActivity.superIsRationaleAvailable(permission: String): Boolean

    fun ComponentActivity.superRequestPermission(handler: PermissionResponseHandler)

    fun ComponentActivity.superShowSettingsSnackBar(message: String = "Permission is permanently denied. Please go to settings to enable it.")

    fun ComponentActivity.superShowSnackBar(
        message: String = "Please grant the required permission to continue.",
        buttonText: String = "Grant",
        listener: View.OnClickListener
    )

    fun ComponentActivity.superShowAlertDialog(
        title: String = "Permission Required",
        message: String = "Please grant the required permission to continue.",
        negativeButtonText: String = "Cancel",
        positiveButtonText: String = "Grant",
        listener: () -> Unit
    )
}