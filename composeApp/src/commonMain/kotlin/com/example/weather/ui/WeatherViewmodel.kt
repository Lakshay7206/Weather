package com.example.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.WeatherRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherState(isLoading = true))
    val state: StateFlow<WeatherState> = _state.asStateFlow()
    private var pollingJob: Job? = null

    init {
        startPolling()
    }

    private fun startPolling() {
        pollingJob?.cancel()
        pollingJob = viewModelScope.launch {
            weatherRepository.getWeather()
                .onEach { result ->
                    result.fold(
                        onSuccess = { weather ->
                            _state.update {
                                it.copy(
                                    weather = weather,
                                    isLoading = false,
                                    isRefreshing = false,
                                    error = null
                                )
                            }
                        },
                        onFailure = { error ->
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    isRefreshing = false,
                                    error = error.message ?: "Something went wrong"
                                )
                            }
                        }
                    )
                }
                .launchIn(this)
        }
    }

    fun refresh() {
        _state.update { it.copy(isRefreshing = true) }
        startPolling()
    }
}