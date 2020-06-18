package com.bright.data.db

import com.bright.data.entities.NewDataRealm
import com.bright.data.mapper.NewsMapperLocal
import com.bright.domain.entities.NewsDataEntity
import com.vicpin.krealmextensions.deleteAll
import com.vicpin.krealmextensions.queryAll
import com.bright.domain.util.EntityResult
import com.vicpin.krealmextensions.save
import com.vicpin.krealmextensions.saveAll

class NewsDataDao {

    fun getAllNews(): EntityResult<List<NewsDataEntity>> {
        val mapper = NewsMapperLocal()
        val realmNews = NewDataRealm().queryAll()
        val convertedEntities = ArrayList<NewsDataEntity>()
        realmNews.forEach {
            convertedEntities.add(mapper.transform(it))
        }
        return EntityResult.Success(convertedEntities)
    }

    fun updateNews(news: NewsDataEntity) {
        val mapperLocal = NewsMapperLocal()
        val convertedEntity = mapperLocal.transformToRepository(news)
        convertedEntity.save()
    }

    fun clearAll() {
        NewDataRealm().deleteAll()
    }

    fun saveAllNews(news: List<NewDataRealm>) {
        news.saveAll()
    }
}
