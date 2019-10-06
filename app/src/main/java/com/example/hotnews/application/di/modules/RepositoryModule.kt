package com.example.hotnews.application.di.modules

import com.example.hotnews.data.network.NetworkService
import com.example.hotnews.data.repository.NewsRepositoryImpl
import com.example.hotnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Provides
    @Named("newsRepository")
    fun getNewsRepository(
        @Named("networkService") networkService: NetworkService
    ) : NewsRepository {
        return NewsRepositoryImpl(networkService)
    }
}