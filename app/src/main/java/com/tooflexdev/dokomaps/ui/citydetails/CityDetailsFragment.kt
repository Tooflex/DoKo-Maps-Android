package com.tooflexdev.dokomaps.ui.citydetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.tooflexdev.dokomaps.R

class CityDetailsFragment : Fragment() {

    private val tvWeatherCardCityName by lazy { view?.findViewById<TextView>(R.id.textViewCardCityName) }
    private val tvCardWeatherDescription by lazy { view?.findViewById<TextView>(R.id.textViewCardWeatherDescription) }
    private val ivCardWeatherIcon by lazy { view?.findViewById<ImageView>(R.id.imageViewCardWeatherIcon) }
    private val tvCardCurrentTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardCurrentTemp) }
    private val tvCardMaxTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardMaxTemp) }
    private val tvCardMinTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardMinTemp) }



    companion object {
        fun newInstance() = CityDetailsFragment()
    }

    private lateinit var viewModel: CityDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.city_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CityDetailsViewModel::class.java)

        viewModel.getCityWeather().observe(this, Observer {
            Log.d("Yo", it.toString())
            tvWeatherCardCityName?.text = it.name
            tvCardWeatherDescription?.text = it.weather[0].description
            tvCardCurrentTemp?.text = "${it.main.temp.toInt()} °C"
            tvCardMinTemp?.text = "${it.main.temp_min.toInt()} °C"
            tvCardMaxTemp?.text = "${it.main.temp_max.toInt()} °C"
        })

        // Get city from intent then pass it to view model
        val city = activity?.intent?.extras?.getString("city")
        city?.let { viewModel.setCity(it) }

    }

}
