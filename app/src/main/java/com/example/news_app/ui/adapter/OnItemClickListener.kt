package com.example.news_app.ui.adapter

import com.example.news_app.model.Articles

interface OnItemClickListener {
    fun onItemClick(article: Articles)
}