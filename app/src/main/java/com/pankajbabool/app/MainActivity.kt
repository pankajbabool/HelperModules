package com.pankajbabool.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.pankajbabool.modules.extensions.extShowAlertDialogType1
import com.pankajbabool.modules.extensions.extShowToast
import com.pankajbabool.modules.extensions.extShowSnackBar
import com.pankajbabool.modules.permission_helper.PermissionHelper
import com.pankajbabool.modules.permission_helper.PermissionHelperImp
import com.pankajbabool.modules.permission_shortcuts.extRequestNotificationPermission

class MainActivity : AppCompatActivity(), PermissionHelper by PermissionHelperImp() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        superInitPermissionHelperInOnCreate()
        findViewById<View?>(android.R.id.content)?.setOnClickListener(::onCLick)
    }


    private fun onCLick(view: View) {
//        extShowAlertDialogType1(this,"This is Material 3 Alert Dialog") { dialog , i ->
//            dialog.dismiss()
//            extShowSnackBar(this, "This is Long SnackBar With Action", buttonText = "Show Toast") {
//                extShowToast(this, "This is Long Toast")
//            }
//        }
//        extRequestNotificationPermission()
    }
}