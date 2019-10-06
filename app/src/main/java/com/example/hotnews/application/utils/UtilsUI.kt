package com.example.hotnews.application.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import com.example.hotnews.R
import com.example.hotnews.domain.News
import io.reactivex.Single
import java.text.DateFormatSymbols

fun View.on() {
    this.visibility = View.VISIBLE
}

fun View.off() {
    this.visibility = View.INVISIBLE
}

fun View.blink() {
    startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.blink))
}

fun log(tag : String, message: String) {
    Log.i("rating", "$tag $message")
}

fun showMovies(list : List<News>) {
    var str = ""
    for (item in list) {
        str += "${item.description} - ${item.date} - ${item.id} - ${item.isFavorite}"
    }

    log("showKek", str)
}