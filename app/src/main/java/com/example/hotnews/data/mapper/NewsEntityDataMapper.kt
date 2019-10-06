package com.example.hotnews.data.mapper

import com.example.hotnews.data.entity.NewsEntity
import com.example.hotnews.domain.News

fun transform(listNewsEntity: List<NewsEntity>): List<News> {
    val resultList = ArrayList<News>()
    for (item in listNewsEntity) {
        resultList.add(transform(item))
    }
    return resultList
}

fun transform(newsEntity: NewsEntity): News {
    var news: News
    newsEntity.apply {
        news = News(
            id = id,
            description = description,
            poster = transform(poster),
            viewCount = viewCount,
            isFavorite = isFavorite,
            date = date
        )
    }
    return news
}

private fun transform(posterEntity: NewsEntity.PosterEntity): News.Poster {
    var poster: News.Poster
    posterEntity.apply {
        poster = News.Poster(
            url = url,
            width = width,
            height = height
        )
    }
    return poster
}
