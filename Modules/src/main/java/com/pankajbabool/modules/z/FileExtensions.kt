package com.pankajbabool.modules.z

import android.media.MediaMetadataRetriever
import java.io.File
import java.text.DecimalFormat

fun formatMillisSeconds(milliseconds: Long): String {
    val hours = (milliseconds / (1000 * 60 * 60)).toInt()
    val minutes = (milliseconds % (1000 * 60 * 60)).toInt() / (1000 * 60)
    val seconds = (milliseconds % (1000 * 60 * 60) % (1000 * 60) / 1000).toInt()
    return if (minutes < 1) {
        "$seconds s"
    } else if (minutes in 2..60) {
        "$minutes s : $seconds s"
    } else if (hours > 1) {
        "$hours h : $minutes m : $seconds s"
    } else {
        ""
    }
}

fun getDuration(file: File): String {
    val mediaMetadataRetriever = MediaMetadataRetriever()
    mediaMetadataRetriever.setDataSource(file.absolutePath)
    val durationStr = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
    return durationStr?.let { formatMillisSeconds(it.toLong()) }.toString()
}

fun getMediaDuration(file: File): Long {
    if (!file.exists()) return 0
    val retriever = MediaMetadataRetriever()
    retriever.setDataSource(file.absolutePath)
    val duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
    retriever.release()
    return duration?.toLong() ?: 0
}

fun getSizeInKBMBGB(size: Long): String {
    val df = DecimalFormat("0.00")
    val sizeKb = 1024.0f
    val sizeMb = sizeKb * sizeKb
    val sizeGb = sizeMb * sizeKb
    val sizeTerra = sizeGb * sizeKb
    if (size < sizeMb) {
        return df.format(size / sizeKb).toString() + " KB"
    } else if (size < sizeGb) {
        return df.format(size / sizeMb).toString() + " MB"
    } else if (size < sizeTerra) {
        return df.format(size / sizeGb).toString() + " GB"
    }
    return ""
}