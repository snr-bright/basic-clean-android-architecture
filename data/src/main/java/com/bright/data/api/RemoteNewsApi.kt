package com.bright.data.api

import com.bright.data.entities.NewsApiStatusData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RemoteNewsApi {
    @GET("top-headlines?country=us")
    fun getNews(): Deferred<NewsApiStatusData>
}