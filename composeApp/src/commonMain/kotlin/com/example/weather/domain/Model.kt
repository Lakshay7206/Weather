package com.example.weather.domain

import kotlinx.datetime.Instant
import kotlin.time.ExperimentalTime

data class Weather @OptIn(ExperimentalTime::class) constructor(
    val temperature: Float?,
    val windSpeed: Float?,
    val time: Instant,
    val windDirection: Float?,
    val isDay: Int?,
    val weatherCode: Int?,
    val description: String
)