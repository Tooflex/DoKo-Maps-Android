package com.tooflexdev.dokomaps.model

data class CountryGeojson(
    val geometry: Geometry,
    val id: String,
    val properties: Properties,
    val type: String
)