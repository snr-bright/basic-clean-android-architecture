package com.bright.domain.entities


data class NewsDataEntity(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var source: String? = null,
    var publishedDate: String? = null,
    var author: String? = null)