package com.plcoding.weatherapp.features.weather.di

import com.plcoding.weatherapp.features.weather.data.repository.WeatherRepositoryImp
import com.plcoding.weatherapp.features.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImp
    ): WeatherRepository
}