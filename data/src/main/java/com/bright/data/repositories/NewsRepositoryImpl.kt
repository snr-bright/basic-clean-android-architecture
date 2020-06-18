package com.bright.data.repositories

import com.bright.domain.entities.NewsStatusDataEntity
import com.bright.domain.repositories.GetNewsRepository
import com.bright.domain.entities.DataEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

class NewsRepositoryImpl(private val remote: NewsRemoteImpl,
                         private val cache: NewsCacheImpl
) : GetNewsRepository {

    override suspend fun getLocalNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {
        return cache.getNews()
    }

    override suspend fun getRemoteNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {
        return remote.getNews()
    }

    override suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {

        return GlobalScope.produce() {
            launch {
                val localNewsChannel = cache.getNews()
                localNewsChannel.consumeEach { send(it) }
            }

            launch {
                val remoteNews = remote.getNews().receive()
                when (remoteNews) {
                    is DataEntity.SUCCESS -> {
                        cache.saveArticles(remoteNews)
                    }
                    is DataEntity.ERROR -> {
                        send(remoteNews)
                    }
                }
            }
        }
    }
}