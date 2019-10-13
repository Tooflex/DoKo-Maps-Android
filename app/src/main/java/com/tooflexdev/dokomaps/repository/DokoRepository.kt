package com.tooflexdev.dokomaps.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tooflexdev.dokomaps.api.doko.DokoAPI
import com.tooflexdev.dokomaps.model.Country
import com.tooflexdev.dokomaps.model.CountryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DokoRepository {
    val TAG = "DokoRepository"

    fun getCountries(): LiveData<List<Country>> {

        val data = MutableLiveData<List<Country>>()

        DokoAPI.dokoClient.getCountries()
            .enqueue(object : Callback<CountryResponse> {
                override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                    Log.e(TAG, t.localizedMessage)

                }

                override fun onResponse(
                    call: Call<CountryResponse>,
                    response: Response<CountryResponse>
                ) {
                    val countries = response.body()
                    if (countries != null) {
                        Log.d(TAG, "Countries RETRIEVED:")
                        Log.d(TAG, countries.toString())
                        data.value = countries.countries
                    }
                }

            })
        return data
    }

    fun getCountry(countryCode: String) {
        val data = MutableLiveData<Country>()

        DokoAPI.dokoClient.getCountries()
            .enqueue(object : Callback<CountryResponse> {
                override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                    Log.e(TAG, t.localizedMessage)

                }

                override fun onResponse(
                    call: Call<CountryResponse>,
                    response: Response<CountryResponse>
                ) {
                    val countries = response.body()
                    if (countries != null) {
                        Log.d(TAG, "Countries RETRIEVED:")
                        Log.d(TAG, countries.toString())
                        data.value = countries.countries
                    }
                }

            })
        return data
    }
}