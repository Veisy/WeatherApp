package com.plcoding.weatherapp.features.weather.domain.model

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val todayWeatherData: List<WeatherData>?,
    val currentWeatherData: WeatherData?
)
