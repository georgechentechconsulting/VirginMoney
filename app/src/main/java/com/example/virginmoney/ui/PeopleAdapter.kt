import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoney.Person
import com.example.virginmoney.R

import com.google.android.material.snackbar.Snackbar

class PeopleAdapter(
    private val people: List<Person>,
    private val onItemClick: (View, Person) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.item_name)
        val imageView: ImageView = itemView.findViewById(R.id.item_image)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(itemView, people[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.nameTextView.text = person.name
        Glide.with(holder.itemView.context).load(person.imageUrl).into(holder.imageView)
    }

    override fun getItemCount() = people.size
}
