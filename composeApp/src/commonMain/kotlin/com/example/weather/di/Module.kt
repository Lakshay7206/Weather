package com.example.weather.di

import com.example.weather.WeatherDatabase
import com.example.weather.data.ApiService
import com.example.weather.data.CreateHttpClientEngine
import com.example.weather.data.HttpClientFactory
import com.example.weather.data.HttpClientFactory.createHttpClient
import com.example.weather.data.createDatabase
import com.example.weather.domain.WeatherRepository
import com.example.weather.ui.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.logging.LoggingFormat
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

expect val platformModule: Module

val appModule = module {
    single { WeatherRepository(get(), get()) }
    viewModel { WeatherViewModel(get()) }
    single { ApiService(get()) }
    single { HttpClientFactory.createHttpClient(get()) }
    single { CreateHttpClientEngine() }
    single { createDatabase(get()) }
    single { get<WeatherDatabase>().weatherQueries }
}


