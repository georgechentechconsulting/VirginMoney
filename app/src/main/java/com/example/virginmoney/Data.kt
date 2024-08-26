package com.example.virginmoney

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("firstName")
    val name: String,
    val avatar: String,
    @SerializedName("favouriteColor")
    val favoriteColor: String
)

data class Room(
    val id: String,
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
)
