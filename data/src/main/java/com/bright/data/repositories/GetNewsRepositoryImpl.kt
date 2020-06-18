package com.bright.data.repositories

import android.util.Log
import com.bright.data.api.RemoteNewsService
import com.bright.data.db.NewsDataDao
import com.bright.data.entities.NewDataRealm
import com.bright.data.mapper.NewsMapperLocal
import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.repositories.GetNewsRepository
import com.bright.domain.util.EntityResult

class GetNewsRepositoryImpl(
    private val newsDataDao: NewsDataDao,
    private val remoteNewsService: RemoteNewsService,
    private val newsMapperService: NewsMapperLocal
) : GetNewsRepository {


    override fun getNews(getFromRemote: Boolean): EntityResult<List<NewsDataEntity>> {
        return if (getFromRemote) {
            val entityResult = remoteNewsService.getNews()
            if (entityResult is EntityResult.Success) {
                val convertLocalData =
                    entityResult.data.map { newsMapperService.transformToRepository(it) }
                updateAllRecords(convertLocalData)
            }
            entityResult
        } else {
            newsDataDao.getAllNews()
        }
    }

    private fun updateAllRecords(records: List<NewDataRealm>) {
        newsDataDao.clearAll()
        newsDataDao.saveAllNews(records)
    }
}