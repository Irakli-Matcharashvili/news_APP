package com.example.news_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Articles(
    var id: Int? = null,
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String?,

    ) : Parcelable

