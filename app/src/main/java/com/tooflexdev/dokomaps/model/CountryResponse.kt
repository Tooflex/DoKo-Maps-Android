package com.tooflexdev.dokomaps.model

data class CountryResponse(
    val countries: List<String>,
    val description: String,
    val id: Int,
    val image: String,
    val owner: OwnerX,
    val title: String,
    val types: List<String>
)