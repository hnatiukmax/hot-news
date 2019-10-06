package com.example.hotnews.presentation.boardnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotnews.application.MyApplication
import com.example.hotnews.application.utils.isInternetOn
import com.example.hotnews.application.utils.log
import com.example.hotnews.application.utils.showMovies
import com.example.hotnews.domain.News
import com.example.hotnews.domain.interactor.GetNewsList
import kotlinx.coroutines.*
import kotlinx.coroutines.launch

class NewsActivityViewModel(
    private val newsInteractor : GetNewsList
) : ViewModel() {

    private var viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val statusConnection = MutableLiveData<Boolean>()
    val noResult = MutableLiveData<Boolean>()
    val newsList = MutableLiveData<List<News>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        loadNews()
    }

    fun loadNews() {
        if(isInternetOn(MyApplication.getAppContext())) {
            statusConnection.postValue(true)
        } else {
            statusConnection.postValue(false)
            if (newsList.value.isNullOrEmpty()){
                isLoading.postValue(false)
            }
            return
        }

        isLoading.postValue(true)
        try {
            viewModelScope.launch {
                val list = async {
                    newsInteractor.getNews()
                }
                newsList.postValue(list.await())

            }
        } finally {
            isLoading.postValue(false)
        }
    }

    fun onSearch(string : String) {

    }

    fun onDestroy() {
        viewModelScope.cancel()
    }
}