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
import com.airbnb.lottie.LottieAnimationView
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.DokoMap
import com.tooflexdev.dokomaps.model.Owner
import com.tooflexdev.dokomaps.util.MarginItemDecoration
import kotlinx.android.synthetic.main.city_details_fragment.*

class CityDetailsFragment : Fragment() {

    private val tvWeatherCardCityName by lazy { view?.findViewById<TextView>(R.id.textViewCardCityName) }
    private val tvCardWeatherDescription by lazy { view?.findViewById<TextView>(R.id.textViewCardWeatherDescription) }
    private val ivCardWeatherIcon by lazy { view?.findViewById<LottieAnimationView>(R.id.animationImageViewCardWeatherIcon) }
    private val tvCardCurrentTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardCurrentTemp) }
    private val tvCardMaxTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardMaxTemp) }
    private val tvCardMinTemp by lazy { view?.findViewById<TextView>(R.id.textViewCardMinTemp) }
    private val tvCity by lazy { view?.findViewById<TextView>(R.id.tvTopSearchCityDetails) }



    private lateinit var dokoMapAdapter: DokoMapAdapter


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

        dokoMapAdapter = DokoMapAdapter()

        rvTopSearchCityDetails.adapter = dokoMapAdapter

        rvTopSearchCityDetails.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt())
        )

        val dokoMaps = populateDokoMaps()

        dokoMapAdapter.setDokoMaps(dokoMaps)

        dokoMapAdapter.notifyDataSetChanged()

        viewModel.getCityWeather().observe(this, Observer {
            tvWeatherCardCityName?.text = it.name
            tvTopSearchCityDetails?.text = context?.getString(R.string.city_maps, it.name)
            tvCardWeatherDescription?.text = it.weather[0].description
            tvCardCurrentTemp?.text = "${it.main.temp.toInt()} °C"
            tvCardMinTemp?.text = "${it.main.temp_min.toInt()} °C"
            tvCardMaxTemp?.text = "${it.main.temp_max.toInt()} °C"
        })

        // Get city from intent then pass it to view model
        val city = activity?.intent?.extras?.getString("city")
        city?.let { viewModel.setCity(it) }

    }

    private fun populateDokoMaps(): List<DokoMap>? {

        val maps = ArrayList<DokoMap>()
        maps.add(DokoMap(
            emptyList(),
            emptyList(),
            emptyList(),
            1,
            "My best list ever",
            1,
            "https://cdn.getyourguide.com/img/tour_img-1621839-145.jpg",
            "EN",
            35.658581,
            139.745438,
            Owner(1,"otourou@gmail.com",1,1,"",1,"toto"),
            emptyList(),
            10,
            true,
            "Best places",
            emptyList(),
            1,
            1))

        maps.add(DokoMap(
            emptyList(),
            emptyList(),
            emptyList(),
            1,
            "Paris best places",
            1,
            "https://www.toureiffel.paris/themes/custom/tour_eiffel/img/picto_myGoogleBusiness_1.jpg",
            "EN",
            35.658581,
            139.745438,
            Owner(1,"otourou@gmail.com",1,1,"",1,"toto"),
            emptyList(),
            10,
            true,
            "So So Good",
            emptyList(),
            1,
            1))

        return maps
    }

}
