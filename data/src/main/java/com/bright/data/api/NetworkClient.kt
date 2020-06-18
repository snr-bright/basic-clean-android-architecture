package com.bright.data.api

import android.util.Log
import com.bright.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val PUBLIC_API_KEY_ARG = "apiKey"
private const val BASE_URL = "https://newsapi.org/v2/"
private const val MAX_TRYOUTS = 3
private const val INIT_TRYOUT = 1

class NetworkClient {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .addInterceptor { chain ->
            val defaultRequest = chain.request()
            val defaultHttpUrl = defaultRequest.url()
            val httpUrl = defaultHttpUrl.newBuilder()
                .addQueryParameter(PUBLIC_API_KEY_ARG, BuildConfig.API_KEY)
                .build()

            val requestBuilder = defaultRequest.newBuilder()
                .url(httpUrl)

            chain.proceed(requestBuilder.build())
        }
        .addInterceptor { chain ->
            val request = chain.request()
            var response = chain.proceed(request)
            var tryOuts = INIT_TRYOUT

            while (!response.isSuccessful && tryOuts < MAX_TRYOUTS) {
                Log.e(
                    this@NetworkClient.javaClass.simpleName, "intercept: timeout/connection failure, " +
                            "performing automatic retry ${(tryOuts + 1)}"
                )
                tryOuts++
                response = chain.proceed(request)
            }

            response
        }

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }


}