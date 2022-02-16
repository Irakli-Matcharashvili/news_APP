package com.example.news_app.ui.news.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app.model.NewsResponse
import com.example.news_app.repositories.news.NewsRepository
import com.example.news_app.repositories.news.NewsRepositoryImpl
import com.example.news_app.util.Constants.API_KEY
import com.example.news_app.util.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsVm : ViewModel() {
    private val repository: NewsRepository by lazy { NewsRepositoryImpl() }

    private val _successNewsLiveData: MutableLiveData<NewsResponse> = MutableLiveData()
    val successNewsLiveData: LiveData<NewsResponse> = _successNewsLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> get() = _errorLiveData

    fun getCustomCategoryNews(category: String, ) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCustomCategoryNews(category = category, apiKey = API_KEY)
            when (response) {
                is Resources.Success -> _successNewsLiveData.postValue(response.data!!)
                is Resources.Error -> _errorLiveData.postValue(response.message!!)
            }

        }
    }
}