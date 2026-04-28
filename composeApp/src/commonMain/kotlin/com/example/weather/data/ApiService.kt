package com.example.weather.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiService(val client: HttpClient) {
    private val baseUrl = "https://api.open-meteo.com/v1/forecast?latitude=28.61&longitude=77.23&current_weather=true"
    suspend fun getWeather(): WeatherDto =
        client.get(baseUrl).body()
}

object HttpClientFactory{
    fun createHttpClient(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
    }
}