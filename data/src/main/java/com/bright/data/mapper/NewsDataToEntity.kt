package com.bright.data.mapper

import com.bright.data.entities.NewsData
import com.bright.domain.entities.NewsStatusDataEntity
import com.bright.domain.entities.NewsDataEntity

class NewsDataToEntity constructor() {

    fun mapToEntity(mapArticles: List<NewsData>?) =
        NewsStatusDataEntity(articles = mapListNewsToEntity(mapArticles))

    private fun mapListNewsToEntity(articles: List<NewsData>?)
            : List<NewsDataEntity> = articles?.map { mapNewsToEntity(it) } ?: emptyList()

    private fun mapNewsToEntity(response: NewsData): NewsDataEntity = NewsDataEntity(
        id = response.id,
        title = response.title,
        description = response.description,
        url = response.url,
        urlToImage = response.urlToImage
    )
}