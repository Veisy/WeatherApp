package com.plcoding.weatherapp.features.weather.data.repository

import com.plcoding.weatherapp.features.weather.data.mappers.toWeatherInfo
import com.plcoding.weatherapp.features.weather.data.remote.WeatherApi
import com.plcoding.weatherapp.features.weather.domain.model.WeatherInfo
import com.plcoding.weatherapp.features.weather.domain.repository.WeatherRepository
import com.plcoding.weatherapp.features.weather.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> =
        withContext(Dispatchers.IO) {
            try {
                Resource.Success(
                    data = api.getWeatherData(
                        lat = lat,
                        long = long
                    ).toWeatherInfo()
                )
            } catch (e: Exception) {
                Resource.Error(e.message ?: "An unknown error occurred.")
            }
        }
}