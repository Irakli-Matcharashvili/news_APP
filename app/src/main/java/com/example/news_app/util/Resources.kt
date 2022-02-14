package com.example.news_app.util

sealed class Resources<T> {
    data class Success<T>(val data: T?) : Resources<T>()
    data class Error<T>(val message: String?) : Resources<T>()
}