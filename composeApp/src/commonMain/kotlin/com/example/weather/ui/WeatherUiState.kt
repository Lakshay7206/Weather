package com.example.weather.ui

import com.example.weather.domain.Weather

data class WeatherState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null
)