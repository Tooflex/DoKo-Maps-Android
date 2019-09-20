package com.tooflexdev.dokomaps.api.weather

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object WeatherAPI {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    public val KEY = "79badf94102e008963c2d50b6cfa43f2"


    val libraryClient: WeatherService
        get() {
            if (retrofit == null) {

                val httpClient = OkHttpClient.Builder()

                httpClient.connectTimeout(60, TimeUnit.SECONDS)
                httpClient.readTimeout(60, TimeUnit.SECONDS)

                val okHttpClient=httpClient.build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }
            return retrofit!!.create(WeatherService::class.java)
        }
}