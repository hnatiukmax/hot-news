package com.example.hotnews.data.repository

import com.example.hotnews.data.network.NetworkService
import com.example.hotnews.data.network.NewsAPI
import com.example.hotnews.data.network.NewsResponse
import com.example.hotnews.domain.News
import com.example.hotnews.domain.repository.NewsRepository
import io.reactivex.Single
import kotlinx.coroutines.Deferred

class NewsRepositoryImpl : NewsRepository {

    private val networkService : NetworkService

    constructor(networkService : NetworkService) {
        this.networkService = networkService
    }

    override suspend fun news(): NewsResponse {
        return networkService.getNewsApi.getNews()
    }
}