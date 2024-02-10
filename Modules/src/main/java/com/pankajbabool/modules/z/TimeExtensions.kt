package com.pankajbabool.modules.z

import java.text.SimpleDateFormat
import java.util.Date
import java.util.concurrent.TimeUnit

fun getTimeInHHMMSSFormat(milliseconds: Long): String = milliseconds.let {
    var finalTimerString = ""
    var secondsString = ""
    val hours = (milliseconds / (1000 * 60 * 60)).toInt()
    val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
    val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()
    if (hours > 0) finalTimerString = "$hours:"
    secondsString = if (seconds < 10) "0$seconds" else "" + seconds
    finalTimerString = "$finalTimerString$minutes:$secondsString"
    finalTimerString
}

fun covertTimeToText(dataDate: Long?): String {
    var convTime: String? = null
    val suffix = "ago"
    try {
        val nowTime = Date()
        val dateDiff = nowTime.time - dataDate!!
        val second = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
        val minute = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
        val hour = TimeUnit.MILLISECONDS.toHours(dateDiff)
        val day = TimeUnit.MILLISECONDS.toDays(dateDiff)
        if (second < 60) convTime = "$second sec $suffix"
        else if (minute < 60) convTime = "$minute min $suffix"
        else if (hour < 24) convTime = "$hour hr $suffix"
        else if (day >= 7) {
            convTime = if (day > 360) (day / 360).toString() + " Years " + suffix
            else if (day > 30) (day / 30).toString() + " Months " + suffix
            else (day / 7).toString() + " Week " + suffix
        } else if (day < 7) convTime = "$day Days $suffix"
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return "$convTime, ${SimpleDateFormat("h:mm a").format(dataDate!!)}"
}

fun covertTimeToText2(longTime: Long): String? {
    try {
        val nowTime = Date()
        val dateDiff = nowTime.time - longTime
        val hour = TimeUnit.MILLISECONDS.toHours(dateDiff)
        val dateTimePattern = if (hour < 24) "h:m a" else "d/M/yyyy"
        return SimpleDateFormat(dateTimePattern).format(longTime)
    } catch (e: Exception) {
        e.printStackTrace()
        return "null"
    }
}