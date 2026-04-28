package com.example.weather

import android.app.Application
import com.example.weather.di.initKoin

class Apple : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}