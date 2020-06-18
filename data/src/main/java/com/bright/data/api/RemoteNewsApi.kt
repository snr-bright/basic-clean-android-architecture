package com.bright.data.api

import com.bright.data.entities.BaseNewsApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface RemoteNewsApi {
    @GET("top-headlines?country=us")
    fun getNews(): Call<BaseNewsApiResponse>

}