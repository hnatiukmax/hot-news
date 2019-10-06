package com.example.hotnews.application.utils

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.Single

fun isInternetOn(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}