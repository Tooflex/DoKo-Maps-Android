package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review")
data class Review(
    @PrimaryKey val id: Int,
    val author_name: String,
    val author_url: String,
    val language: String,
    val profile_photo_url: String,
    val rating: Int,
    val relative_time_description: String,
    val text: String,
    val time: Int
)