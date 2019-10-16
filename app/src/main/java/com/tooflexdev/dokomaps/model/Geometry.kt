package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geometry")
data class Geometry(
    val coordinates: List<String>,
    val type: String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}