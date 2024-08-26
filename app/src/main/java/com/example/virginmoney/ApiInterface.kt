package com.example.virginmoney
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{
    @GET("people")
    fun getPeople(): Call<List<Person>>

    @GET("rooms")
    fun getRooms(): Call<List<Room>>

}
