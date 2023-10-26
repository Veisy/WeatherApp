package com.plcoding.weatherapp.features.weather.domain.repository

import com.plcoding.weatherapp.features.weather.domain.model.WeatherInfo
import com.plcoding.weatherapp.features.weather.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}