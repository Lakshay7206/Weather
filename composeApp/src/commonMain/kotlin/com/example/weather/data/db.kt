package com.example.weather.data

import app.cash.sqldelight.db.SqlDriver

fun createDatabase(driverFactory: DatabaseDriverFactory): WeatherDatabase {
    return WeatherDatabase(driverFactory.createDriver())
}

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}