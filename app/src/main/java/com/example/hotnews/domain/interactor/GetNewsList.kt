package com.example.hotnews.domain.interactor

import com.example.hotnews.data.mapper.transform
import com.example.hotnews.domain.News
import com.example.hotnews.domain.repository.NewsRepository
import io.reactivex.Single

class GetNewsList(
    private var newsRepository : NewsRepository
) {
    suspend fun getNews() = transform(newsRepository.news().newsList)
}