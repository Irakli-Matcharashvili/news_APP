package com.example.news_app.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
    )
