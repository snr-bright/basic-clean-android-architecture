package com.bright.data.entities

data class NewsApiData(
        var id: Int = 0,
        var title: String? = null,
        var description: String? = null,
        var url: String? = null,
        var urlToImage: String? = null,
        var source: String? = null,
        var publishedDate: String? = null,
        var author: String? = null)