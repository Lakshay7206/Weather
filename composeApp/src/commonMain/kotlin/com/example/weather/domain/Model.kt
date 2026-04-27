package com.example.weather.domain

data class Weather(
    val temperature: Float,
    val windSpeed: Float,
    val time: String,
    val windDirection: Int,
    val isDay: Int,
    val weatherCode: Int,
    val description: String
)