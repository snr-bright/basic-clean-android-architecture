package com.bright.data.mapper

import com.bright.data.entities.NewsApiResponse
import com.bright.data.entities.NewsApiSource
import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.entities.NewsSourceDataEntity


open class NewsMapperService : BaseMapperRepository<NewsApiResponse, NewsDataEntity> {

    override fun transform(type: NewsApiResponse): NewsDataEntity =
        NewsDataEntity(
            type.author,
            type.title,
            type.description,
            type.url,
            type.urlToImage,
            type.source?.let { mapSource(it) },
            type.publishedDate
        )

    override fun transformToRepository(type: NewsDataEntity): NewsApiResponse =
        NewsApiResponse(
            type.author,
            type.title,
            type.description,
            type.url,
            type.urlToImage,
            type.source?.let { mapSource(it) },
            type.publishedDate
        )

    private fun mapSource(source: NewsApiSource) =
        NewsSourceDataEntity(source.id, source.name)

    private fun mapSource(source: NewsSourceDataEntity) =
        NewsApiSource(source.id, source.name)
}
