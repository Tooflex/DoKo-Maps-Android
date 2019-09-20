package com.tooflexdev.dokomaps.api.weather

import com.tooflexdev.dokomaps.model.weather.CityWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
    @GET("weather")
    fun getWeatherCity(
        @Query("q") city: String, @Query("APPID") key: String, @Query("units") units: String, @Query(
            "cnt"
        ) days: Int
    ): Call<CityWeather>

}