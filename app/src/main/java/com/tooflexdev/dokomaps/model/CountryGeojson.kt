package com.tooflexdev.dokomaps.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_geo_json")
data class CountryGeojson(
    @Embedded(prefix = "geometry_")
    val geometry: Geometry,
    @PrimaryKey val id: String,
    @Embedded(prefix = "properties_")
    val properties: Properties,
    val type: String
)