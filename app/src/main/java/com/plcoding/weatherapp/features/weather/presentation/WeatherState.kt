package com.plcoding.weatherapp.features.weather.presentation

import com.plcoding.weatherapp.features.weather.domain.model.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
