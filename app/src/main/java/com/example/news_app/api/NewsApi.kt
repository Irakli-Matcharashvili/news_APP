package com.example.news_app.api

import com.example.news_app.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getCustomCategoryNews(
        @Query("category") category:String,
        @Query("apiKey") apiKey: String,
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getSearchedNews(
        @Query("q") q:String,
        @Query("apiKey") apiKey:Int
    )
}