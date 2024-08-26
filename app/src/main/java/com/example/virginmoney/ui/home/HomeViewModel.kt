package com.example.virginmoney.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.RecyclerView

class HomeViewModel : ViewModel() {

    private val _people = MutableLiveData<List<Person>>()
    val people: LiveData<List<Person>> get() = _people

    init {
        fetchPeople()
    }

    private fun fetchPeople() {
        RetrofitClient.apiService.getPeople().enqueue(object : Callback<List<Person>> {
            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                if (response.isSuccessful) {
                    _people.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
            }
        })
    }
}
