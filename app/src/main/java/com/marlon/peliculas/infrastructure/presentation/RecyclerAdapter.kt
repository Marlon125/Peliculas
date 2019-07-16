package com.marlon.peliculas.infrastructure.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marlon.peliculas.R

class RecyclerAdapter(item:ArrayList<HashMap<String, String>>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var itemMovies: ArrayList<HashMap<String, String>> = ArrayList()

    init {
        this.itemMovies = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_detail, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemMovies[position]
    }

    override fun getItemCount(): Int {
        return itemMovies.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val itemRate: TextView = itemView.findViewById(R.id.txtRate)
        val itemHomePage: TextView = itemView.findViewById(R.id.txtHomePage)

    }
}