package com.bright.data.repositories

import com.bright.data.db.NewsDataDao
import com.bright.data.db.NewsDatabase
import com.bright.data.mapper.NewsDataToEntity
import com.bright.data.mapper.NewsEntityToData
import com.bright.domain.entities.NewsStatusDataEntity
import com.bright.domain.entities.DataEntity
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription

class NewsCacheImpl(
    database: NewsDatabase,
    private val entityToDataMapper: NewsEntityToData,
    private val dataToEntityMapper: NewsDataToEntity
) : NewsDataStore {

    private val newsDataDao: NewsDataDao = database.getNewsDao()

    override suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {
        val mappedValue = newsDataDao.getAllNewsData().map { it ->
            DataEntity.SUCCESS(dataToEntityMapper.mapToEntity(it))
        }
        return mappedValue.openSubscription()
    }

    fun saveArticles(response: DataEntity<NewsStatusDataEntity>) {
        entityToDataMapper.mapResponseToData(response)?.let {
            newsDataDao.clear()
            newsDataDao.saveAllNewsData(it)
        }
    }

}