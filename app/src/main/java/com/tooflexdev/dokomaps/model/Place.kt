package com.tooflexdev.dokomaps.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place")
data class Place(
    val address: String,
    val city: String,
    val comment: String,
    val country: String,
    val createdAt: Long,
    val google_id: String,
    val google_url: String,
    val icon: String,
    @PrimaryKey val id: Int,
    val international_phone_number: String,
    val latitude: Double,
    val longitude: Double,
    val opening_hours: String,
    @Embedded(prefix = "photo_")
    val photos: List<Photo>,
    val rating: Double,
    val ratings: Int,
    @Embedded(prefix = "reviews_")
    val reviews: List<Review>,
    val title: String,
    val types: List<String>,
    val updatedAt: Long,
    val website: String
)