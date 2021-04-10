package com.example.peliculasapi

import com.google.gson.annotations.SerializedName

data class Pelicula (@SerializedName("id") val id: String,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("director") val director: String,
    @SerializedName("genero") val genero: String,
    @SerializedName("poster") val poster : String,)
