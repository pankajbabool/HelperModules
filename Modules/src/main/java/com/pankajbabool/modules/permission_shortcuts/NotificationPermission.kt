package com.pankajbabool.modules.permission_shortcuts

import android.Manifest
import android.os.Build
import androidx.activity.ComponentActivity
import com.pankajbabool.modules.permission_helper.PermissionHelper
import com.pankajbabool.modules.permission_helper.PermissionResponseHandler

// TODO (Must Use superInitPermissionHelperInOnCreate before using below Functions)

fun<T> T.extRequestNotificationPermission() where T: ComponentActivity, T: PermissionHelper {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        superRequestPermission(object : PermissionResponseHandler {
            override val permission = Manifest.permission.POST_NOTIFICATIONS
        })
    }
}