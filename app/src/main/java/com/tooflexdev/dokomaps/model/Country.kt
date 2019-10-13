package com.tooflexdev.dokomaps.model

data class Country(
    val count: String,
    val country_code: String,
    val country_code3: String,
    val country_geojson: CountryGeojson,
    val country_id: Int,
    val country_latitude: String,
    val country_longitude: String,
    val country_name: String,
    val country_photo: String,
    val country_photo_attribution: String,
    val country_photo_small: String
)