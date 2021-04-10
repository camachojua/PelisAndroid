package com.example.peliculasapi

import com.google.gson.annotations.SerializedName

data class PeliculasResponse(
    @SerializedName("peliculas") var peliculas: List<Pelicula>
)