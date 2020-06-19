package com.bright.domain.entities


data class NewsDataEntity(
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var source: NewsSourceDataEntity? = null,
    var publishedDate: String? = null
)