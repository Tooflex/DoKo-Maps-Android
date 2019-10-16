package com.tooflexdev.dokomaps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "owner")
data class Owner(
    val createdAt: Long,
    val email: String,
    @PrimaryKey val id: Int,
    val lastSeenAt: Long,
    val updatedAt: Long,
    val username: String
)