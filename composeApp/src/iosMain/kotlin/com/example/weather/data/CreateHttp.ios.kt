package com.example.weather.data

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual fun CreateHttpClientEngine(): HttpClientEngine {
    return Darwin.create()
}