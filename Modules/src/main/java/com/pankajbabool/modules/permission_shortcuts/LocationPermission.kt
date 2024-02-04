package com.pankajbabool.modules.permission_shortcuts

import android.Manifest
import androidx.activity.ComponentActivity
import com.pankajbabool.modules.permission_helper.PermissionHelper
import com.pankajbabool.modules.permission_helper.PermissionResponseHandler

// TODO (Must Use superInitPermissionHelperInOnCreate before using below Functions)

fun<T> T.extUseFineOrCoarseLocationOrRequestAndUseIt(usePermissionFinally: () -> Unit) where T: ComponentActivity, T: PermissionHelper {
    val finePermission = Manifest.permission.ACCESS_FINE_LOCATION
    val coarsePermission = Manifest.permission.ACCESS_COARSE_LOCATION
    val coarseHandler = object : PermissionResponseHandler {
        override val permission = coarsePermission
        override fun onGranted() = usePermissionFinally()
        override fun onPermanentlyDenied() = superShowSettingsSnackBar()
        override fun onRationalAvailable() = superShowSnackBar(message = "Please grant the Approximate Location permission to continue.") { superRequestPermission(this) }
        override fun onRejected() = superShowSnackBar(message = "Please grant the Approximate Location permission to continue.") { superRequestPermission(this) }
    }
    val fineHandler = object : PermissionResponseHandler {
        override val permission = finePermission
        override fun onGranted() = usePermissionFinally()
        override fun onPermanentlyDenied() = superShowSettingsSnackBar()
        override fun onRationalAvailable() = superShowSnackBar(message = "Please grant the Precise Location permission to continue.") { superRequestPermission(this) }
        override fun onRejected() = superShowSnackBar(message = "Please grant the Precise Location permission to continue.") { superRequestPermission(this) }
    }
    if (superIsGranted(coarsePermission) || superIsGranted(finePermission)) {
        usePermissionFinally()
    } else if (superIsRationaleAvailable(finePermission)) {
        superShowAlertDialog(message = "Please grant the Precise Location permission to continue.") {
            superRequestPermission(fineHandler)
        }
    } else if (superIsRationaleAvailable(coarsePermission)) {
        superShowAlertDialog(message = "Please grant the Approximate Location permission to continue.") {
            superRequestPermission(coarseHandler)
        }
    } else {
        superRequestPermission(object : PermissionResponseHandler {
            override val permission = finePermission
            override fun onGranted() = usePermissionFinally()
            override fun onPermanentlyDenied() = superRequestPermission(coarseHandler)
            override fun onRationalAvailable() {
                superShowAlertDialog(message = "Please grant the Precise Location permission to continue.") {
                    superRequestPermission(fineHandler)
                }
            }
            override fun onRejected() = superRequestPermission(coarseHandler)
        })
    }
}