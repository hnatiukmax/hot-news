package com.example.hotnews.data.entity

import com.google.gson.annotations.SerializedName


data class NewsEntity(
    @SerializedName("id")
    var id : Int = 0,

    @SerializedName("name")
    var description: String = "",

    @SerializedName("price")
    var date : String = "",

    @SerializedName("image")
    var poster : PosterEntity = PosterEntity(),

    @SerializedName("favorite")
    var isFavorite : Boolean = false,

    @SerializedName("view_count")
    var viewCount : Int = 0)
{
    class PosterEntity(
        @SerializedName("url")
        var url : String = "",

        @SerializedName("width")
        var width : Int = 0,

        @SerializedName("height")
        var height : Int = 0
    )
}