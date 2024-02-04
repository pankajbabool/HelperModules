package com.pankajbabool.modules.extensions

import android.content.Context
import android.content.DialogInterface
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Any?.extShowOptionsAlertDialog(
    context: Context,
    options: List<String> = listOf("Option 1", "Option 2"),
    title: String = "Select an option",
    onOptionClick: DialogInterface.OnClickListener = DialogInterface.OnClickListener { it, _-> it.dismiss()}
) {
    val alertDialog = MaterialAlertDialogBuilder(context)
    alertDialog.setTitle(title)
    alertDialog.setItems(options.toTypedArray(), onOptionClick)
    alertDialog.show()
}

fun Any?.extShowAlertDialogType1(
    context: Context,
    message: String,
    title: String = "Alert Dialog",
    positiveButtonText: String = "OK",
    negativeButtonText: String = "Cancel",
    onNegativeClick: DialogInterface.OnClickListener = DialogInterface.OnClickListener { it, _ -> it.dismiss() },
    onPositiveClick: DialogInterface.OnClickListener
) {
    val alertDialog = MaterialAlertDialogBuilder(context)
    alertDialog.setTitle(title)
    alertDialog.setCancelable(false)
    alertDialog.setMessage(message)
    alertDialog.setNegativeButton(negativeButtonText, onNegativeClick)
    alertDialog.setPositiveButton(positiveButtonText, onPositiveClick)
    alertDialog.show()
}

fun Any?.extShowAlertDialogType2(
    context: Context,
    message: String,
    title: String = "Alert Dialog",
    positiveButtonText: String = "OK",
    negativeButtonText: String = "NO",
    neutralButtonText: String = "Cancel",
    onNeutralClick: DialogInterface.OnClickListener = DialogInterface.OnClickListener { it, _ -> it.dismiss() },
    onNegativeClick: DialogInterface.OnClickListener = DialogInterface.OnClickListener { it, _ -> it.dismiss() },
    onPositiveClick: DialogInterface.OnClickListener
) {
    val alertDialog = MaterialAlertDialogBuilder(context)
    alertDialog.setTitle(title)
    alertDialog.setCancelable(false)
    alertDialog.setMessage(message)
    alertDialog.setNeutralButton(neutralButtonText, onNeutralClick)
    alertDialog.setNegativeButton(negativeButtonText, onNegativeClick)
    alertDialog.setPositiveButton(positiveButtonText, onPositiveClick)
    alertDialog.show()
}