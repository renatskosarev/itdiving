package dev.skosarev.itdiving

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CustomRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    private var cities = listOf("Санкт-Петербург", "Москва", "Пермь", "Новосибирск", "Екатеринбург",
    "Казань", "Нижний Новгород", "Красноярск", "Уфа", "Самара", "Ростов-на-Дону", "Омск")

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val userCity: TextView = itemView.findViewById(R.id.user_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userName.text = names[position]
        holder.userCity.text = cities[Random.nextInt(cities.size)]
    }

    override fun getItemCount(): Int {
        return names.size
    }
}