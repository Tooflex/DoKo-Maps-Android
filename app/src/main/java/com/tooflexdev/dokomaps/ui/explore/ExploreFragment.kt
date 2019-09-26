package com.tooflexdev.dokomaps.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.TopCity
import com.tooflexdev.dokomaps.model.TopCountry
import com.tooflexdev.dokomaps.model.TopSearch
import com.tooflexdev.dokomaps.model.TopTag
import com.tooflexdev.dokomaps.util.MarginItemDecoration
import kotlinx.android.synthetic.main.fragment_explore.*


class ExploreFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel

    private lateinit var topCityAdapter: TopCityAdapter
    private lateinit var topSearchAdapter: TopSearchAdapter
    private lateinit var topTagAdapter: TopTagAdapter
    private lateinit var topCountryAdapter: TopCountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreViewModel =
            ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore, container, false)
        val textView: TextView = root.findViewById(R.id.tvExplore)
        exploreViewModel.text.observe(this, Observer {
            // textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        topCityAdapter = TopCityAdapter()
        topSearchAdapter = TopSearchAdapter()
        topTagAdapter = TopTagAdapter()
        topCountryAdapter = TopCountryAdapter()

        rvTopCities.adapter = topCityAdapter
        rvTopSearch.adapter = topSearchAdapter
        rvTopTag.adapter = topTagAdapter
        rvTopCountries.adapter = topCountryAdapter

        rvTopCities.addItemDecoration(
            MarginItemDecoration(
            resources.getDimension(R.dimen.default_padding).toInt())
        )

        rvTopSearch.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt())
        )

        rvTopTag.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt())
        )

        rvTopCountries.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt())
        )


        val cities = populateTopCities()
        val searches = populateTopSearch()
        val tags = populateTopTags()
        val countries = populateTopCountires()


        topCityAdapter.setCities(cities)
        topSearchAdapter.setTopSearches(searches)
        topTagAdapter.setTags(tags)
        topCountryAdapter.setCountries(countries)

        topCityAdapter.notifyDataSetChanged()
        topSearchAdapter.notifyDataSetChanged()
        topTagAdapter.notifyDataSetChanged()
        topCountryAdapter.notifyDataSetChanged()
    }


    private fun populateTopCities(): ArrayList<TopCity> {

        val topCities = ArrayList<TopCity>()
        topCities.add(TopCity("Tokyo", "https://cdn.dokomaps.com/countries/JP.jpg"))
        topCities.add(TopCity("Paris", "https://cdn.dokomaps.com/countries/FR.jpg"))
        topCities.add(TopCity("Brussels", "https://cdn.dokomaps.com/countries/BE.jpg"))
        topCities.add(TopCity("Lisbon", "https://cdn.dokomaps.com/countries/PT.jpg"))

        return topCities

    }

    private fun populateTopSearch(): ArrayList<TopSearch> {

        val topCities = ArrayList<TopSearch>()
        topCities.add(TopSearch("Restaurant", ""))
        topCities.add(TopSearch("Bar", ""))
        topCities.add(TopSearch("Beach", ""))
        topCities.add(TopSearch("Hotel", ""))

        return topCities

    }

    private fun populateTopTags(): ArrayList<TopTag> {

        val topCities = ArrayList<TopTag>()
        topCities.add(TopTag("#Summer", ""))
        topCities.add(TopTag("#Holiday", ""))
        topCities.add(TopTag("#Love", ""))
        topCities.add(TopTag("#Sea", ""))

        return topCities

    }

    private fun populateTopCountires(): ArrayList<TopCountry> {

        val topCities = ArrayList<TopCountry>()
        topCities.add(TopCountry("Japan", "https://cdn.dokomaps.com/countries/JP.jpg"))
        topCities.add(TopCountry("France", "https://cdn.dokomaps.com/countries/FR.jpg"))
        topCities.add(TopCountry("Belgium", "https://cdn.dokomaps.com/countries/BE.jpg"))
        topCities.add(TopCountry("Portugal", "https://cdn.dokomaps.com/countries/PT.jpg"))

        return topCities

    }


}