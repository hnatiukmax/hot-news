package com.example.hotnews.application.di
//
//import android.app.Application
//import android.os.Build
//import com.example.hotnews.BuildConfig
//import com.example.hotnews.data.network.BASE_URL
//import com.example.hotnews.data.network.NetworkService
//import com.example.hotnews.data.network.NewsAPI
//import com.example.hotnews.data.repository.NewsRepositoryImpl
//import com.example.hotnews.domain.interactor.GetNewsList
//import com.example.hotnews.domain.repository.NewsRepository
//import com.example.hotnews.presentation.boardnews.NewsActivityViewModel
//import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import org.kodein.di.Kodein
//import org.kodein.di.android.x.androidXModule
//import org.kodein.di.conf.ConfigurableKodein
//import org.kodein.di.generic.*
//import retrofit2.CallAdapter
//import retrofit2.Converter
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class DependencyContainer(
//    private val kodein: ConfigurableKodein,
//    private val app: Application
//) {
//
//    private fun addModule(module: Kodein.Module) {
//        kodein.addImport(module, true)
//    }
//
//    fun resetInjection() {
//        kodein.clear()
//        addModule(androidXModule(app))
//        addModule(repositoriesDependencies())
//        addModule(networkDependencies())
//        addModule(viewModelDependencies())
//        addModule(interactorDependencies())
//    }
//
//    private fun repositoriesDependencies() = Kodein.Module("repositoriesModule") {
//        bind<NewsRepository>() with provider {
//            NewsRepositoryImpl(instance())
//        }
//    }
//
//    private fun networkDependencies() = Kodein.Module {
//        bind<Converter.Factory>() with provider { GsonConverterFactory.create() }
//        bind<CallAdapter.Factory>() with provider { RxJava2CallAdapterFactory.create() }
//        bind<Retrofit>() with provider {
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(instance())
//                .addCallAdapterFactory(instance())
//                .build()
//        }
//        bind<NetworkService>() with singleton { NetworkService(instance()) }
//    }
//
//    private fun viewModelDependencies() = Kodein.Module("viewModel") {
//        bind<NewsActivityViewModel>() with provider { NewsActivityViewModel(instance()) }
//    }
//
//    private fun interactorDependencies() = Kodein.Module("interactor") {
//        bind<GetNewsList>() with singleton { GetNewsList(instance()) }
//    }
//}