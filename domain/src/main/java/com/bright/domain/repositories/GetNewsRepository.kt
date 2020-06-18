package com.bright.domain.repositories

import com.bright.domain.entities.NewsStatusDataEntity
import com.rakshitjain.presentation.entities.DataEntity
import kotlinx.coroutines.channels.ReceiveChannel

interface GetNewsRepository {
    suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>>
    suspend fun getLocalNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>>
    suspend fun getRemoteNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>>

}