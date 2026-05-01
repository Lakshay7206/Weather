package com.example.weather.data.mapper

import com.example.weather.Weatherdb
import com.example.weather.data.CurrentWeather


fun CurrentWeather.toWeatherdb(): Weatherdb {
    return Weatherdb(
        time = time, // keep raw string OR normalize (we’ll talk below)
        temperature = temperature.toDouble(),
        windSpeed = windspeed.toDouble(),
        windDirection = winddirection.toLong(),
        isDay = is_day.toLong(),
        weatherCode = weathercode.toLong(),
        description = weatherDescription(weathercode)
    )
}
fun weatherDescription(code: Int): String = when (code){
    0 -> "Clear Sky ☀️"
    1, 2, 3 -> "Partly Cloudy 🌤"
    45, 48 -> "Foggy ☁️"
    51, 53, 55 -> "Drizzle"
    61, 63, 65 -> "Rain 🌧"
    71, 73, 75 -> "Snow"
    80, 81, 82 -> "Rain Showers 🌧"
    95 -> "Thunderstorm 🌧"
    else -> "Unknown"
}