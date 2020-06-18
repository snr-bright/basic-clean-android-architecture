package com.bright.data.entities

import com.google.gson.annotations.SerializedName

data class BaseNewsApiResponse(
        @SerializedName("articles") val news: List<NewsApiResponse>,
        @SerializedName("status") val status: String,
        @SerializedName("totalResults") val totalResults: Int
)
