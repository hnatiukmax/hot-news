package com.example.hotnews.application

import android.app.Application
import android.content.Context
import com.example.hotnews.application.di.component.AppComponent
import com.example.hotnews.application.di.component.DaggerAppComponent
import com.example.hotnews.domain.News

class MyApplication : Application() {

    companion object {
        private lateinit var context : Context
        private lateinit var component : AppComponent
        fun getAppContext() = MyApplication.context
        fun getAppComponent() = MyApplication.component
    }

    override fun onCreate() {
        super.onCreate()
        MyApplication.context = applicationContext
        component = DaggerAppComponent.create()
    }
}