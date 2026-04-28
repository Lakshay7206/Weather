package com.example.weather.domain

import kotlinx.datetime.Instant

data class Weather(
    val temperature: Float,
    val windSpeed: Float,
    val time: Instant,
    val windDirection: Int,
    val isDay: Int,
    val weatherCode: Int,
    val description: String
)