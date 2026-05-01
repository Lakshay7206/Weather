package com.example.weather.data

import app.cash.sqldelight.db.SqlDriver
import com.example.weather.WeatherDatabase

fun createDatabase(driverFactory: DatabaseDriverFactory): WeatherDatabase {
    return WeatherDatabase(driverFactory.createDriver())
}

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}