package com.pankajbabool.modules.permission_helper

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import com.pankajbabool.modules.extensions.extShowAlertDialogType1
import com.pankajbabool.modules.extensions.extShowSnackBar

class PermissionHelperImp : PermissionHelper {
    private val internal by lazy { PermissionHelperInternal() }

    override fun ComponentActivity.superInitPermissionHelperInOnCreate() {
        internal.initializeLauncher(this)
    }

    override fun ComponentActivity.superIsGranted(permission: String): Boolean {
        return internal.isGranted(this, permission)
    }

    override fun ComponentActivity.superIsRationaleAvailable(permission: String): Boolean {
        return internal.isRationaleAvailable(this, permission)
    }

    override fun ComponentActivity.superRequestPermission(handler: PermissionResponseHandler) {
        internal.startLauncher(handler)
    }

    override fun ComponentActivity.superShowSettingsSnackBar(message: String) {
        extShowSnackBar(this, message, Snackbar.LENGTH_INDEFINITE, buttonText = "Settings") {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            intent.data = Uri.fromParts("package", packageName, null)
            startActivity(intent)
        }
    }

    override fun ComponentActivity.superShowSnackBar(message: String, buttonText: String, listener: View.OnClickListener) {
        extShowSnackBar(this, message, buttonText = buttonText, listener = listener)
    }

    override fun ComponentActivity.superShowAlertDialog(title: String, message: String, negativeButtonText: String, positiveButtonText: String, listener: () -> Unit) {
        extShowAlertDialogType1(this, message, title, positiveButtonText, negativeButtonText) { dialog, _ ->
            dialog?.dismiss()
            listener.invoke()
        }
    }
}