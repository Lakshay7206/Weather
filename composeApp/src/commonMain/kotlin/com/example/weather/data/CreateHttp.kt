package com.example.weather.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

expect fun CreateHttpClientEngine(): HttpClientEngine