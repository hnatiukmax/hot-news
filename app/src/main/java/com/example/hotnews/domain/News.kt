package com.example.hotnews.domain

import java.io.Serializable

data class News(
    val id : Int,
    val description : String,
    val poster : Poster,
    val date : String,
    val viewCount : Int,
    val isFavorite : Boolean
) : Serializable {
    data class Poster(
        val url : String,
        val width : Int,
        val height : Int
    )
}

