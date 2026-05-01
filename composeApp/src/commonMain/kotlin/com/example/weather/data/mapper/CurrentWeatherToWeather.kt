import com.example.weather.domain.Weather

//package com.example.weather.data.mapper
//
//import com.example.weather.data.CurrentWeather
//import com.example.weather.domain.Weather
//import kotlinx.datetime.Instant
//import kotlin.time.ExperimentalTime
//
//@OptIn(ExperimentalTime::class)
//fun CurrentWeather.toWeather(): Weather {
//    val fixedTime = if (time.length == 16) {
//        "${time}:00Z"
//    } else time
//   return Weather(
//        temperature = temperature,
//        windSpeed = windspeed,
//        time = Instant.parse(fixedTime),
//        windDirection = winddirection,
//        isDay = is_day,
//        weatherCode = weathercode,
//        description = weatherDescription(weathercode)
//    )
//}
//val current: Weather? = null,
//val history: List<Weather> = emptyList(),
//
////
////fun weatherDescription(code: Int): String = when (code){
////    0 -> "Clear Sky ☀️"
////    1, 2, 3 -> "Partly Cloudy 🌤"
////    45, 48 -> "Foggy ☁️"
////    51, 53, 55 -> "Drizzle"
////    61, 63, 65 -> "Rain 🌧"
////    71, 73, 75 -> "Snow"
////    80, 81, 82 -> "Rain Showers 🌧"
////    95 -> "Thunderstorm 🌧"
////    else -> "Unknown"
////}