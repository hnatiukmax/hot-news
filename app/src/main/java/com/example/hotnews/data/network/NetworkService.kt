package com.example.hotnews.data.network

import retrofit2.Retrofit

class NetworkService(
    private var retrofit : Retrofit
) {
    val getNewsApi: NewsAPI
        get() = retrofit.create(NewsAPI::class.java)
}