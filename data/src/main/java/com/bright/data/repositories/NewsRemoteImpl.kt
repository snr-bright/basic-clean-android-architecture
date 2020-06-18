package com.bright.data.repositories

import com.bright.data.api.RemoteNewsApi
import com.bright.data.mapper.NewsDataToEntity
import com.bright.domain.entities.NewsStatusDataEntity
import com.rakshitjain.presentation.entities.DataEntity
import com.bright.domain.entities.ErrorEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import java.lang.Exception

class NewsRemoteImpl constructor(private val api: RemoteNewsApi) : NewsDataStore {

    private val newsMapper = NewsDataToEntity()

    override suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {
        val producer = GlobalScope.produce<DataEntity<NewsStatusDataEntity>> {
            try {
                val news = api.getNews().await()
                newsMapper.mapToEntity(news.articles).let { send(DataEntity.SUCCESS(it)) }
            } catch (e: Exception) {
                send(DataEntity.ERROR(ErrorEntity(e.message)))
            }
        }

        return producer
    }

}