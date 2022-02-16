package com.example.news_app.ui.splash_screen.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.repositories.splash.SplashScreenRepository
import com.example.news_app.repositories.splash.SplashScreenRepositoryImpl
import com.example.news_app.util.Constants.ON_BOARDING_SCREEN_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashScreenVm: ViewModel() {

    private val repository: SplashScreenRepository by lazy { SplashScreenRepositoryImpl(App.dataStore) }

    private val _splashScreenLiveData: MutableLiveData<String> = MutableLiveData()
    val splashScreenLiveData: LiveData<String> = _splashScreenLiveData

    fun getValue() {
        viewModelScope.launch(Dispatchers.IO) {
            _splashScreenLiveData.postValue(repository.getValue(ON_BOARDING_SCREEN_KEY).first())
        }
    }
}