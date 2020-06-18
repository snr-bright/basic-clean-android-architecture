package com.bright.data.entities

import com.google.gson.annotations.SerializedName

data class NewsApiResponse(
    @SerializedName("author")  var author: String? = "",
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("publishedDate") var publishedDate: String? = null)