package com.bright.data.entities

data class NewsApiStatusData(
        var status: String? = null,
        var articles: List<NewsData> = emptyList()
)