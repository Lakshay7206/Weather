package com.example.weather.data.mapper

import com.example.weather.Weatherdb
import com.example.weather.domain.Weather
import kotlinx.datetime.Instant
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun Weatherdb.toWeather(): Weather {
    val fixedTime = if (time.length == 16) {
        "${time}:00Z"
    } else time
    return Weather(
        temperature = temperature?.toFloat(),
        windSpeed = windSpeed?.toFloat(),
        time = Instant.parse(fixedTime), // 🔥 parse string
        windDirection = windDirection?.toFloat(),
        isDay = isDay?.toInt(),
        weatherCode = weatherCode?.toInt(),
        description = description ?: ""
    )
}