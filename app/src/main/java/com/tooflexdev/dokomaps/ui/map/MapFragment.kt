package com.tooflexdev.dokomaps.ui.map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.*
import com.tooflexdev.dokomaps.R

import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.SupportMapFragment
import com.tooflexdev.dokomaps.model.Category
import com.tooflexdev.dokomaps.model.TopSearch
import com.tooflexdev.dokomaps.ui.explore.TopSearchAdapter
import com.tooflexdev.dokomaps.util.MarginItemDecoration
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapViewModel: MapViewModel

    private var map: SupportMapFragment? = null

    @Nullable
    private var googleMap: GoogleMap? = null

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var topSearchAdapter: TopSearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mapViewModel =
            ViewModelProviders.of(this).get(MapViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_map, container, false)

        // Gets the MapView from the XML layout and creates it
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        categoryAdapter = CategoryAdapter()
        topSearchAdapter = TopSearchAdapter()

        rvMapCategories.adapter = topSearchAdapter

        rvMapCategories.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt())
        )

        // val categories = populateCategories()

        // categoryAdapter.setCategories(categories)
        topSearchAdapter.setTopSearches(populateTopSearch())

        // categoryAdapter.notifyDataSetChanged()
        topSearchAdapter.setTopSearches(populateTopSearch())

    }

    override fun onResume() {
        super.onResume()
        map?.onResume()
    }

    override fun onPause() {
        super.onPause()
        map?.onPause()
    }

    override fun onStart() {
        super.onStart()
        map?.onStart()
    }

    override fun onStop() {
        super.onStop()
        map?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        map?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map?.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap

        // Add a marker in Sydney, Australia, and move the camera.
        val sydney = LatLng(-34.0, 151.0)
        googleMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))

    }

    private fun populateCategories(): ArrayList<Category> {

        val topCities = ArrayList<Category>()
        topCities.add(Category(emptyList(), "Bars"))
        topCities.add(Category(emptyList(), "Resto"))
        topCities.add(Category(emptyList(), "Club"))
        topCities.add(Category(emptyList(), "Sights"))

        return topCities

    }

    private fun populateTopSearch(): ArrayList<TopSearch> {

        val topCities = ArrayList<TopSearch>()
        topCities.add(TopSearch("Restaurant", "https://cdn.dokomaps.com/chizus/10.jpeg"))
        topCities.add(TopSearch("Bar", "https://cdn.dokomaps.com/chizus/9.jpg"))
        topCities.add(TopSearch("Beach", "https://www.planetware.com/photos-large/USHI/hawaii-honolulu-beaches-oahu-kailua-beach.jpg"))
        topCities.add(TopSearch("Hotel", "https://ghc.anitab.org/wp-content/uploads/sites/2/2017/07/rosen-center-hotel-700x466.jpg"))

        return topCities

    }
}