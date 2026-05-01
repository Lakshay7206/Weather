package com.example.weather.domain

import com.example.weather.WeatherQueries
import com.example.weather.data.ApiService
import com.example.weather.data.mapper.toWeather
import com.example.weather.data.mapper.toWeatherdb
import kotlinx.coroutines.flow.Flow
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map

class WeatherRepository(
    private val api: ApiService,
    private val queries: WeatherQueries
){
    fun observeWeather(): Flow<List<Weather>> {
        return queries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toWeather() } }
    }
    suspend fun fetchAndStore() {
        try {
            val dto = api.getWeather()

            val entity = dto.toWeatherdb()

            queries.insertWeather(
                time = entity.time,
                temperature = entity.temperature,
                windSpeed = entity.windSpeed,
                windDirection = entity.windDirection,
                isDay = entity.isDay,
                weatherCode = entity.weatherCode,
                description = entity.description
            )

            // 🔥 Keep only latest 5
            queries.deleteOldest()

        } catch (e: Exception) {
            // don’t crash
        }
    }
}






/*class WeatherRepository(
    private val api: ApiService,
    private val queries: WeatherQueries
) {
    fun getWeather(): Flow<Weather> = flow {
        while (true) {
            try {
                val xyz = api.getWeather()
                val weather = xyz.toWeather()

                queries.insertWeather(


                )
                val count = queries.selectAll().executeAsList().size
                if (count > 4) {
                    queries.deleteOldest(count - 4)
                }


                emit(weather)
            } catch (e: Exception) {
                // fallback to DB
                val cached = queries.selectAll()
                    .executeAsList()
                    .map { it.toDomain() }

                emit(cached)
            }
        }
    }


    fun getPast() : Flow<List<Weather>> =flow{
        val ans =queries.selectAll()
                    .executeAsList()
                    .map { it.toDomain() }
        emit(ans)

    }
}*/

/*
class WeatherRepository(
    private val api: ApiService,
    private val queries: WeatherQueries
) {

    fun getWeather(): Flow<List<Weather>> = flow {
        while (true) {
            try {
                val response = api.getWeather()
                val weather = response.toWeather()

                // 🔥 Insert (duplicate auto-handled)
                queries.insertWeather(
                    weather.time.toString(),
                    weather.temperature,
                    weather.windSpeed,
                    weather.windDirection,
                    weather.isDay,
                    weather.weatherCode,
                    weather.description
                )

                // 🔥 Keep only last 4
                val count = queries.selectAll().executeAsList().size
                if (count > 4) {
                    queries.deleteOldest(count - 4)
                }

                // 🔥 Emit latest 4
                val list = queries.selectAll()
                    .executeAsList()
                    .map { it.toDomain() }

                emit(list)

            } catch (e: Exception) {
                // fallback to DB
                val cached = queries.selectAll()
                    .executeAsList()
                    .map { it.toDomain() }

                emit(cached)
            }
        }
    }
}*/
