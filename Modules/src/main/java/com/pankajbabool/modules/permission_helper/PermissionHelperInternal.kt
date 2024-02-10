package com.pankajbabool.modules.permission_helper

import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

internal class PermissionHelperInternal {
    private var startMillis = 0L

    private lateinit var mResponse: PermissionResponseHandler
    private lateinit var launcher: ActivityResultLauncher<String>

    fun initializeLauncher(componentActivity: ComponentActivity) {
        launcher = componentActivity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            when {
                isGranted == null -> {
                    Unit
                }
                isGranted -> {
                    mResponse.onGranted()
                }
                isRationaleAvailable(componentActivity, mResponse.permission) -> {
                    mResponse.onRationalAvailable()
                }
                (System.currentTimeMillis() - startMillis) < 500 -> {
                    mResponse.onPermanentlyDenied()
                }
                else -> {
                    mResponse.onRejected()
                }
            }
        }
    }

    fun startLauncher(handler: PermissionResponseHandler) {
        if (!::launcher.isInitialized) {
            throw RuntimeException("Must call superInitPermissionHelperInOnCreate() in onCreate before requesting any Permission")
        } else {
            mResponse = handler
            startMillis = System.currentTimeMillis()
            launcher.launch(handler.permission)
        }
    }

    fun isGranted(componentActivity: ComponentActivity, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(componentActivity, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun isRationaleAvailable(componentActivity: ComponentActivity, permission: String): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(componentActivity, permission)
    }
}