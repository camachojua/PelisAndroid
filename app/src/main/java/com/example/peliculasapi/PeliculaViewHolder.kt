package com.example.peliculasapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculasapi.databinding.PeliculaCardBinding
import com.squareup.picasso.Picasso

class PeliculaViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = PeliculaCardBinding.bind(view)

    fun bind(pelicula: Pelicula) {
        binding.peliculaTitulo.text = pelicula.nombre?: "Título no encontrado"
        binding.peliculaDirector.text = pelicula.director?: "Director no disponible"
        binding.peliculaGenero.text = pelicula.genero?: "Genero no disponible"
        Picasso.get().load(pelicula.poster).into(binding.posterImagen)
    }
}
