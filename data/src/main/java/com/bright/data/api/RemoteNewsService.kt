package com.bright.data.api

import android.util.Log
import com.bright.data.mapper.NewsMapperService
import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.util.EntityResult


class RemoteNewsService {

    private val api: NetworkClient = NetworkClient()
    private val mapper: NewsMapperService = NewsMapperService()

    fun getNews(): EntityResult<List<NewsDataEntity>> {
        val callResponse = api.createService(RemoteNewsApi::class.java).getNews()
        val response = callResponse.execute()
        if (response != null) {
            if (response.isSuccessful) {
                response.body()?.news?.let {
                    val entityDataList = ArrayList<NewsDataEntity>()
                    it.forEach { newData ->
                        entityDataList.add(mapper.transform(newData))
                    }
                    return EntityResult.Success(entityDataList)
                }
                return EntityResult.Failure(Exception("No data found"))
            }
            return EntityResult.Failure(Exception(response.message()))
        }
        return EntityResult.Failure(Exception("Bad request/response"))
    }

}
