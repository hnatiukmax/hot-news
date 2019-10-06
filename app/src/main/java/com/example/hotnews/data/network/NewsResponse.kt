package com.example.hotnews.data.network

import com.example.hotnews.data.entity.NewsEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("next")
    @Expose
    val nextPage : String = "",

    @SerializedName("results")
    @Expose
    val newsList : List<NewsEntity> = ArrayList()
)