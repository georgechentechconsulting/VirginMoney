package com.example.virginmoney

data class Person(
    val name: String,
    val imageUrl: String,
    val favoriteColor: String
)

data class Room(
    val id: String,
    val isOccupied: Boolean
)
