package com.example.hotnews.application.di.modules

import com.example.hotnews.domain.interactor.GetNewsList
import com.example.hotnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepositoryModule::class])
class GetListNewsModule {

    @Provides
    @Named("newsListInteractor")
    fun getInteractorGetNewsList(
        @Named("newsRepository") newsRepository: NewsRepository
    ) : GetNewsList {
        return GetNewsList(newsRepository)
    }
}