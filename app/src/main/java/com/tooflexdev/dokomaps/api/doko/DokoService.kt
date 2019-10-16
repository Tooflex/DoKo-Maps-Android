package com.tooflexdev.dokomaps.api.doko

import com.tooflexdev.dokomaps.CityDetails
import com.tooflexdev.dokomaps.model.CountryResponse
import com.tooflexdev.dokomaps.model.DokoMap
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface DokoService {

    @Headers("Accept: application/json",
        "Content-Type: application/json")
    @GET("countries")
    fun getCountries(): Call<CountryResponse>

    @GET("country/{country_code}")
    fun getCountry(@Path("country_code") countryCode:String): Call<CountryResponse>

    @GET("map/{map_id}")
    fun getMap(@Path("map_id") mapId:String): Call<DokoMap>

    @GET("map/{city_code}")
    fun getCityMap(@Path("city_code") mapId:String): Call<CityDetails>

}