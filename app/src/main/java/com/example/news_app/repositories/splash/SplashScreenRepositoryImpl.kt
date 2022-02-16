package com.example.news_app.repositories.splash

import kotlinx.coroutines.flow.Flow

class SplashScreenRepositoryImpl (private val dataStore: OnBoardingDataStore) : SplashScreenRepository {

    override suspend fun getValue(key: String): Flow<String?> = dataStore.getValue(key)
}