package com.tooflexdev.dokomaps.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.tooflexdev.dokomaps.api.weather.WeatherAPI
import com.tooflexdev.dokomaps.model.weather.CityWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData



class WeatherRepository() {
    val TAG = "LibraryRepository"

    fun getCityWeather(city: String): LiveData<CityWeather> {

        val data = MutableLiveData<CityWeather>()

        WeatherAPI.libraryClient.getWeatherCity(city = city, days = 1, key = WeatherAPI.KEY, units = "metric")
            .enqueue(object : Callback<CityWeather> {
                override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                    Log.e(TAG, t.localizedMessage)
                }

                override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                    val cityWeather = response.body()
                    if (cityWeather != null) {
                        Log.d(TAG, "City Weather RETRIEVED:")
                        Log.d(TAG, cityWeather.toString())
                        data.value = cityWeather
                    }
                }

            })
        return data
    }

}
