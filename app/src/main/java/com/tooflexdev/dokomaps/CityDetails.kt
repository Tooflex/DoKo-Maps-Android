package com.tooflexdev.dokomaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tooflexdev.dokomaps.ui.citydetails.CityDetailsFragment

class CityDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_details_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CityDetailsFragment.newInstance())
                .commitNow()
        }
    }

}
