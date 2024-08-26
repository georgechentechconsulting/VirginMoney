package com.example.virginmoney.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.Room

class RoomsAdapter(
    private val rooms: List<Room>
) : RecyclerView.Adapter<RoomsAdapter.RoomViewHolder>() {

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomIdTextView: TextView = itemView.findViewById(R.id.roomIdTextView)
        val statusIndicator: TextView = itemView.findViewById(R.id.statusIndicator)

        fun bind(room: Room) {
            roomIdTextView.text = "RoomID: ${room.id}"
            statusIndicator.text = "Capacity: ${room.maxOccupancy}"
            itemView.findViewById<LinearLayout>(R.id.llRoom).setBackgroundColor(
                if (room.isOccupied) android.graphics.Color.RED
                else android.graphics.Color.GREEN
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(rooms[position])
    }

    override fun getItemCount() = rooms.size
}
