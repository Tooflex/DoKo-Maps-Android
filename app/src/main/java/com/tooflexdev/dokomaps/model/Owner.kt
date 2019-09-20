package com.tooflexdev.dokomaps.model

data class Owner(
    val createdAt: Long,
    val email: String,
    val id: Int,
    val lastSeenAt: Long,
    val password: String,
    val updatedAt: Long,
    val username: String
)