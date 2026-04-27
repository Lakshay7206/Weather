package com.example.weather.data.mapper

import com.example.weather.data.CurrentWeather
import com.example.weather.domain.Weather

fun CurrentWeather.toWeather(): Weather = Weather(
        temperature = temperature,
        windSpeed = windspeed,
        time = time,
        windDirection = winddirection,
        isDay = is_day,
        weatherCode = weathercode,
        description = weatherDescription(weathercode)
    )


fun weatherDescription(code: Int): String = when (code){
    0 -> "Clear Sky"
    1, 2, 3 -> "Partly Cloudy"
    45, 48 -> "Foggy"
    51, 53, 55 -> "Drizzle"
    61, 63, 65 -> "Rain"
    71, 73, 75 -> "Snow"
    80, 81, 82 -> "Rain Showers"
    95 -> "Thunderstorm"
    else -> "Unknown"
}