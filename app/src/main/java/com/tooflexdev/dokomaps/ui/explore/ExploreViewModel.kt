package com.tooflexdev.dokomaps.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tooflexdev.dokomaps.model.Country
import com.tooflexdev.dokomaps.repository.DokoRepository

class ExploreViewModel : ViewModel() {

    private val dokoRepository: DokoRepository = DokoRepository()
    private var countries: LiveData<List<Country>>

    init {
        countries = dokoRepository.getCountries()
    }

    fun getCountries() : LiveData<List<Country>> {
        return countries
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}