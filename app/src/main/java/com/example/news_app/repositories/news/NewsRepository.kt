package com.example.news_app.repositories.news

import com.example.news_app.model.NewsResponse
import com.example.news_app.util.Resources

interface NewsRepository {
    suspend fun getCustomCategoryNews(category:String,apiKey:String):Resources<NewsResponse>
}