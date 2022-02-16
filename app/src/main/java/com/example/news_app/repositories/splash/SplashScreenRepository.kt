package com.example.news_app.repositories.splash

import kotlinx.coroutines.flow.Flow

interface SplashScreenRepository {
    suspend fun getValue(key: String): Flow<String?>
}