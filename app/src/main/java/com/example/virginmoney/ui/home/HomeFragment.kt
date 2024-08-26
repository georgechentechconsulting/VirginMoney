package com.example.virginmoney.ui.home


import PeopleAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.Person
import com.example.virginmoney.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var peopleAdapter: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewPeople)
        recyclerView.layoutManager = LinearLayoutManager(context)

        RetrofitClient.apiService.getPeople().enqueue(object : Callback<List<Person>> {
            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                if (response.isSuccessful) {
                    val people = response.body()
                    people?.let {
                        peopleAdapter = PeopleAdapter(it) { view, person ->
                            showFavoriteColorSnackbar(view, person.favoriteColor)
                        }
                        recyclerView.adapter = peopleAdapter
                    }
                } else {
                    // Handle the case where the response is not successful
                }
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                // Handle the error
                t.printStackTrace()
            }
        })
    }

    private fun showFavoriteColorSnackbar(view: View, favoriteColor: String) {
        Snackbar.make(view, "Favorite Color: $favoriteColor", Snackbar.LENGTH_LONG).show()
    }
}

