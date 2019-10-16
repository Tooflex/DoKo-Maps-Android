package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_country")
data class TopCountry(
    val name: String,
    val url: String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}