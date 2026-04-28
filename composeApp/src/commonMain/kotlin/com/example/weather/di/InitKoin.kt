package com.example.weather.di

import org.koin.core.context.startKoin

fun initKoin(){
    startKoin { modules(
        appModule
    )
    }
}