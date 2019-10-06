package com.example.hotnews.application.di.component

import com.example.hotnews.application.di.modules.GetListNewsModule
import com.example.hotnews.application.di.modules.NetworkModule
import com.example.hotnews.application.di.modules.RepositoryModule
import com.example.hotnews.application.di.modules.ViewModelModule
import com.example.hotnews.data.network.NetworkService
import com.example.hotnews.domain.interactor.GetNewsList
import com.example.hotnews.domain.repository.NewsRepository
import com.example.hotnews.presentation.boardnews.NewsActivity
import com.example.hotnews.presentation.boardnews.NewsActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    GetListNewsModule::class
])
interface AppComponent {
    fun injectsNewsActivity(view : NewsActivity)
}