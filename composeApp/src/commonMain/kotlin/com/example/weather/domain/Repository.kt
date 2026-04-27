package com.example.weather.domain

import com.example.weather.data.ApiService
import com.example.weather.data.CurrentWeather
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val CALLING_TIME_INTERVAL = 60 * 60 * 1000L

class WeatherRepository(

){
    private val api = ApiService()
     fun getWeather(): Flow<Result<Weather>> = flow {
        while (true) {
            try {
                val dto = api.getWeather()
                emit(Result.success(dto.toWeather))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
            delay(CALLING_TIME_INTERVAL)
        }
    }
}

