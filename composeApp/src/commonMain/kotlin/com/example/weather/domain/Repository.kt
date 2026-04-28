package com.example.weather.domain

import com.example.weather.data.ApiService
import com.example.weather.data.CurrentWeather
import com.example.weather.data.mapper.toWeather
import com.example.weather.data.queries
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class WeatherRepository(val api: ApiService,
    private val queries:WeatherQueries){
     fun getWeather(): Flow<Result<Weather>> = flow {
        while (true) {
            try {
                val xyz = api.getWeather()
                emit(Result.success(xyz.toWeather()))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }

        }
    }
}
//
//class WeatherRepository(
//    private val api: ApiService,
//    private val queries: WeatherQueries
//) {
//
//    fun getWeather(): Flow<List<Weather>> = flow {
//        while (true) {
//            try {
//                val response = api.getWeather()
//                val weather = response.toWeather()
//
//                // 🔥 Insert (duplicate auto-handled)
//                queries.insertWeather(
//                    weather.time.toString(),
//                    weather.temperature,
//                    weather.windSpeed,
//                    weather.windDirection,
//                    weather.isDay,
//                    weather.weatherCode,
//                    weather.description
//                )
//
//                // 🔥 Keep only last 4
//                val count = queries.selectAll().executeAsList().size
//                if (count > 4) {
//                    queries.deleteOldest(count - 4)
//                }
//
//                // 🔥 Emit latest 4
//                val list = queries.selectAll()
//                    .executeAsList()
//                    .map { it.toDomain() }
//
//                emit(list)
//
//            } catch (e: Exception) {
//                // fallback to DB
//                val cached = queries.selectAll()
//                    .executeAsList()
//                    .map { it.toDomain() }
//
//                emit(cached)
//            }
//            delay(60 * 60 * 1000L)
//        }
//    }
//}