package com.bright.domain.entities


data class NewsStatusDataEntity(
        var status: String? = null,
        var articles: List<NewsDataEntity> = emptyList()
)