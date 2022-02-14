package com.example.news_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://newsapi.org/"

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    val newsApi:NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}