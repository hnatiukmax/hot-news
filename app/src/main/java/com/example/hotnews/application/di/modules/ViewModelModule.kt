package com.example.hotnews.application.di.modules

import com.example.hotnews.domain.interactor.GetNewsList
import com.example.hotnews.presentation.boardnews.NewsActivityViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [GetListNewsModule::class])
class ViewModelModule {

    @Provides
    fun getNewsViewModel(
        @Named("newsListInteractor")
        newsInteractor : GetNewsList
    ) : NewsActivityViewModel {
        return NewsActivityViewModel(newsInteractor)
    }
}