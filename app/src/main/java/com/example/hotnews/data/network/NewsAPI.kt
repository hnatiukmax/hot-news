package com.example.hotnews.data.network

import com.example.hotnews.domain.News
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import java.net.ResponseCache

const val BASE_URL = "http://allcom.lampawork.com/api/v1.0/"

open interface NewsAPI {
    @GET("products/")
    suspend fun getNews() : NewsResponse
}