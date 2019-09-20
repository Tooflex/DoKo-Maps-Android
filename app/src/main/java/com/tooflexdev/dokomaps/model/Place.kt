package com.tooflexdev.dokomaps.model

data class Place(
    val address: String,
    val city: String,
    val comment: String,
    val country: String,
    val createdAt: Long,
    val google_id: String,
    val google_url: String,
    val icon: String,
    val id: Int,
    val international_phone_number: String,
    val latitude: Double,
    val longitude: Double,
    val opening_hours: Any,
    val photos: List<Photo>,
    val rating: Double,
    val ratings: Int,
    val reviews: List<Review>,
    val title: String,
    val types: List<String>,
    val updatedAt: Long,
    val website: String
)