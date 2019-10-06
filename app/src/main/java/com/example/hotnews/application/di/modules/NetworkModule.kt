package com.example.hotnews.application.di.modules

import com.example.hotnews.data.network.BASE_URL
import com.example.hotnews.data.network.NetworkService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun getGsonConverter() : Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun getCallAdapter() : CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(getGsonConverter())
            .addCallAdapterFactory(getCallAdapter())
            .build()
    }

    @Singleton
    @Provides
    @Named("networkService")
    fun getNetworkService() : NetworkService {
        return NetworkService(getRetrofit())
    }
}