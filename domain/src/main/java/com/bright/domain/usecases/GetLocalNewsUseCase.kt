package com.bright.domain.usecases

import com.bright.domain.entities.NewsStatusDataEntity
import com.bright.domain.repositories.GetNewsRepository
import com.bright.domain.util.BaseJobUseCase
import com.bright.domain.entities.DataEntity
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.coroutines.CoroutineContext

// It will just return the list of articles in local database
class GetLocalNewsUseCase(private val transformer: CoroutineContext,
                          private val repositories: GetNewsRepository
): BaseJobUseCase<NewsStatusDataEntity>(transformer){

    companion object {
        private const val PARAM_FILE_NEWS_ENTITY = "param:NewsStatus"
    }

    override suspend fun getDataChannel(data: Map<String, Any>?): ReceiveChannel<DataEntity<NewsStatusDataEntity>> {
        return repositories.getNews()
    }

    override suspend fun sendToPresentation(data: DataEntity<NewsStatusDataEntity>): DataEntity<NewsStatusDataEntity> {
        return data
    }

    suspend fun getNews(): ReceiveChannel<DataEntity<NewsStatusDataEntity>>{
        val data = HashMap<String, String>()
        return produce(data)
    }
}