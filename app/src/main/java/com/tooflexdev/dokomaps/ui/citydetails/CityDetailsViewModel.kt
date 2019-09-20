package com.tooflexdev.dokomaps.ui.citydetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.tooflexdev.dokomaps.model.weather.CityWeather
import com.tooflexdev.dokomaps.repository.WeatherRepository


class CityDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val cityLive = MutableLiveData<String>()
    private val weatherRepository: WeatherRepository = WeatherRepository()
    private var cityWeather: LiveData<CityWeather>

    init {

        cityWeather = Transformations.switchMap(cityLive){
            if(it.isNotEmpty()) {
                weatherRepository.getCityWeather(it)
            } else {
                MutableLiveData()
            }
        }

    }

    fun getCityWeather() : LiveData<CityWeather> {
        return cityWeather
    }

    fun setCity(city: String) {
        this.cityLive.value = city
    }

}
