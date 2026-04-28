package com.example.weather.di

import com.example.weather.data.ApiService
import com.example.weather.data.CreateHttpClientEngine
import com.example.weather.data.HttpClientFactory
import com.example.weather.data.HttpClientFactory.createHttpClient
import com.example.weather.data.createDatabase
import com.example.weather.domain.WeatherRepository
import com.example.weather.ui.WeatherViewModel
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { WeatherRepository(get()) }
    viewModel { WeatherViewModel(get()) }
    single { ApiService(get()) }
    single { HttpClientFactory.createHttpClient(get()) }
    single { CreateHttpClientEngine() }
    single {
        createDatabase(get())
    }

    single {
        get<WeatherDatabase>().weatherQueries
    }
}


