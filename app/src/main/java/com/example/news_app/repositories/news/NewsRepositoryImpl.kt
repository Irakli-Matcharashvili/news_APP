package com.example.news_app.repositories.news

import com.example.news_app.api.RetrofitInstance.newsApi
import com.example.news_app.model.NewsResponse
import com.example.news_app.util.Resources
import java.lang.Exception

class NewsRepositoryImpl : NewsRepository {
    override suspend fun getCustomCategoryNews(
        category: String,
        apiKey: String
    ): Resources<NewsResponse> {
        return try {
            val response = newsApi.getCustomCategoryNews(category = category,apiKey = apiKey)
            if (response.isSuccessful){
                Resources.Success(response.body())
            }else{
                Resources.Error (response.message())
            }
        }catch (e:Exception){
            Resources.Error(e.message)
        }
    }
}