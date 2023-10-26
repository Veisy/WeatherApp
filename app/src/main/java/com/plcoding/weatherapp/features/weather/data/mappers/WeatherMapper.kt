package com.plcoding.weatherapp.features.weather.data.mappers

import com.plcoding.weatherapp.features.weather.data.remote.WeatherDTO
import com.plcoding.weatherapp.features.weather.domain.model.WeatherData
import com.plcoding.weatherapp.features.weather.domain.model.WeatherInfo
import com.plcoding.weatherapp.features.weather.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun WeatherDTO.toWeatherInfo(): WeatherInfo {
    val now = LocalDateTime.now()
    val weatherDataPerDay = with(weatherData) {
        time.mapIndexed { index, time ->
            WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperatures[index],
                pressure = pressures[index],
                humidity = humidities[index],
                windSpeed = windSpeeds[index],
                weatherType = WeatherType.fromWMO(weatherCodes[index])
            )
        }.chunked(24).withIndex().associate { (index, data) -> index to data }
    }

    val todayWeatherData = weatherDataPerDay.values.firstOrNull {
        it.any { weatherDate ->
            weatherDate.time.toLocalDate() == now.toLocalDate()
        }
    }
    val hour = if (now.minute < 30 || now.hour >= 23) now.hour else now.hour + 1
    return WeatherInfo(
        weatherDataPerDay = weatherDataPerDay,
        todayWeatherData = todayWeatherData,
        currentWeatherData = todayWeatherData?.find { it.time.hour == hour }
    )
}


