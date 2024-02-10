package com.pankajbabool.modules.z

import android.app.ActivityManager
import android.content.Context

fun isAudio(path: String) = path.endsWith(".mp3", true)  || path.endsWith(".3gp", true) || path.endsWith(".wav", true)
fun isImage(path: String) = path.endsWith(".jpeg", true) || path.endsWith(".jpg", true) || path.endsWith(".png", true)
fun isVideo(path: String) = path.endsWith(".mp4", true)

fun extIsForegroundServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val runningServices = activityManager.getRunningServices(Int.MAX_VALUE)
    return runningServices.any { it.service.className == serviceClass.name }
}

//fun getAppsVersionCode(context: Context): Long? {
//    return try {
//        context.packageManager.getPackageInfo(context.packageName, 0).longVersionCode
//    } catch (e: PackageManager.NameNotFoundException) {
//        Logger.reportLog("AppVersion", e.message.toString())
//        null
//    }
//}