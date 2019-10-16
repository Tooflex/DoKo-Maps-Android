package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo(
    @PrimaryKey val id: String,
    val html_attributions: List<String>,
    val ref: String,
    val url: String
)