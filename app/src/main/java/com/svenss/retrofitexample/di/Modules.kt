package com.svenss.retrofitexample.di

import com.svenss.retrofitexample.api.ApiService
import com.svenss.retrofitexample.datasource.RemoteDataSource
import com.svenss.retrofitexample.repository.MainRepository
import com.svenss.retrofitexample.ui.MainActivityViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by miguelleon on 01,junio,2022
 */

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}

val repositoryModule = module {
    single {
        MainRepository(get())
    }
}

val remoteDataSourceModule = module {
    single {
        RemoteDataSource(get())
    }
}

val apiModule = module {
    fun provideApi(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    single { provideApi(get()) }
}

val retrofitModule = module {

    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val builder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)

        return builder.build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://616501fb09a29d0017c88efa.mockapi.io/")
            .client(okHttpClient)
            .build()
    }

    single { providesOkHttpClient() }
    single { provideRetrofit(get()) }
}
