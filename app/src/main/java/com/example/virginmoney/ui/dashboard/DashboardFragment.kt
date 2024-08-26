package com.example.virginmoney.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.Room
import com.example.virginmoney.ui.RoomsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var roomsAdapter: RoomsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewRooms)
        recyclerView.layoutManager = LinearLayoutManager(context)

        RetrofitClient.apiService.getRooms().enqueue(object : Callback<List<Room>> {
            override fun onResponse(call: Call<List<Room>>, response: Response<List<Room>>) {
                if (response.isSuccessful) {
                    val rooms = response.body()
                    rooms?.let {
                        roomsAdapter = RoomsAdapter(it)
                        recyclerView.adapter = roomsAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Room>>, t: Throwable) {
                // Handle the error
                t.printStackTrace()
            }
        })
    }
}
