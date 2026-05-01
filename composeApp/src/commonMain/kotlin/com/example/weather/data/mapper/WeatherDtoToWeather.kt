package com.example.weather.data.mapper

import com.example.weather.Weatherdb
import com.example.weather.data.WeatherDto
import com.example.weather.domain.Weather

//fun WeatherDto.toWeather(): Weather {
//    return current_weather.toWeather()
//}
fun WeatherDto.toWeatherdb(): Weatherdb{
    return current_weather.toWeatherdb()

}