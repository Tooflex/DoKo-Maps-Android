package com.tooflexdev.dokomaps.api.doko

import com.tooflexdev.dokomaps.api.weather.WeatherService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DokoAPI {
    private var retrofit: Retrofit? = null
    private val BASE_URL = ""


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