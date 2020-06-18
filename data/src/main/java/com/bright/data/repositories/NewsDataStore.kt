package com.bright.data.repositories

import com.bright.domain.entities.NewsStatusDataEntity
import com.rakshitjain.presentation.entities.DataEntity
import kotlinx.coroutines.channels.ReceiveChannel


interface NewsDataStore{
    suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>>
}