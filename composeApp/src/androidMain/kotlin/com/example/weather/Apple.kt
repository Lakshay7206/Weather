package com.example.weather

import android.app.Application
import com.example.weather.di.appModule
import com.example.weather.di.platformModule
import com.example.weather.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Apple : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Apple)
            modules(appModule, platformModule) // 🔥 THIS is what you're missing
        }
    }
}