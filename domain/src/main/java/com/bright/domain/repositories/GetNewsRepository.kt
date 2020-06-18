package com.bright.domain.repositories

import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.util.EntityResult

interface GetNewsRepository {
    fun getNews(getFromRemote: Boolean):  EntityResult<List<NewsDataEntity>>
}