package com.example.hotnews.domain.repository

import com.example.hotnews.data.network.NewsResponse
import com.example.hotnews.domain.News
import io.reactivex.Single

interface NewsRepository {
    suspend fun news() : NewsResponse
}