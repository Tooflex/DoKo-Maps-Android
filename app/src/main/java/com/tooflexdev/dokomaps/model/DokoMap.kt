package com.tooflexdev.dokomaps.model

data class DokoMap(
    val categories: List<Category>,
    val cities: List<String>,
    val countries: List<String>,
    val createdAt: Long,
    val description: String,
    val id: Int,
    val image: String,
    val language: String,
    val latitude: Double,
    val longitude: Double,
    val owner: Owner,
    val places: List<PlaceX>,
    val placesCount: Int,
    val `public`: Boolean,
    val title: String,
    val types: List<String>,
    val updatedAt: Long,
    val zoom: Int
)