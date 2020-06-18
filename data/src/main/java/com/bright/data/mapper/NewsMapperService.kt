package com.bright.data.mapper

import com.bright.data.entities.NewsApiResponse
import com.bright.domain.entities.NewsDataEntity


open class NewsMapperService : BaseMapperRepository<NewsApiResponse, NewsDataEntity> {

    override fun transform(type: NewsApiResponse): NewsDataEntity =
        NewsDataEntity(
            type.title,
            type.description
        )

    override fun transformToRepository(type: NewsDataEntity): NewsApiResponse =
        NewsApiResponse(
            type.id,
            type.title,
            type.description
        )
}
