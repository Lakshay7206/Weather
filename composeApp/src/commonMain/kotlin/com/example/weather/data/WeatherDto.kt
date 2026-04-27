package com.example.weather.data

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val current_weather: CurrentWeather,
    val current_weather_units: CurrentWeatherUnit
)
@Serializable
data class CurrentWeather(
    val time: String,
val interval: Int,
val temperature: Float,
val windspeed: Float,
val winddirection: Int,
val is_day: Int,
val weathercode: Int
)
@Serializable
data class CurrentWeatherUnit(
    val time: String,
    val interval: String,
    val temperature: String,
    val windspeed: String,
    val winddirection: String,
    val is_day: String,
    val weathercode: String
)