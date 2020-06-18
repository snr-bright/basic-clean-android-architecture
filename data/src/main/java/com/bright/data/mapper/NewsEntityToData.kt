package com.bright.data.mapper

import com.bright.data.entities.NewsData
import com.bright.domain.entities.NewsStatusDataEntity
import com.bright.domain.entities.NewsDataEntity
import com.rakshitjain.presentation.entities.DataEntity

class NewsEntityToData constructor() {

    fun mapArticleToData(response: NewsDataEntity): NewsData = NewsData(
        id = response.id,
        title = response.title,
        description = response.description,
        url = response.url,
        urlToImage = response.urlToImage,
        source = response.source,
        publishedDate = response.publishedDate,
        author = response.author
    )

    fun mapResponseToData(response: DataEntity<NewsStatusDataEntity>): List<NewsData>? {
        when (response) {
            is DataEntity.SUCCESS<NewsStatusDataEntity> ->
                return@mapResponseToData response.data?.articles?.map { mapArticleToData(it) }
            is DataEntity.ERROR<NewsStatusDataEntity> ->
                return@mapResponseToData response.data?.articles?.map { mapArticleToData(it) }
            is DataEntity.LOADING<NewsStatusDataEntity> ->
                return@mapResponseToData response.data?.articles?.map { mapArticleToData(it) }
        }
    }


}