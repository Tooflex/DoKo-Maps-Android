package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "properties")
data class Properties(
    @PrimaryKey val id: Int,
    val name: String
)