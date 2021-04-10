package com.example.peliculasapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeliculaAdapter(val peliculas: List<Pelicula>) : RecyclerView.Adapter<PeliculaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val layoutInflater: LayoutInflater =LayoutInflater.from(parent.context)
        return PeliculaViewHolder(
            layoutInflater.inflate(R.layout.pelicula_card,parent,false))
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        holder.bind(peliculas[position])
    }

    override fun getItemCount(): Int {
        return peliculas.size

    }

}