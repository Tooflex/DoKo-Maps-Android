package com.tooflexdev.dokomaps.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    val places: List<Place>,
    val title: String
){
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
}