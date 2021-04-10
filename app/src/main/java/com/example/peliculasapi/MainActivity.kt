package com.example.peliculasapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculasapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val servidor: String = "https://demo0540478.mockable.io/"
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PeliculaAdapter
    private val peliculas = mutableListOf<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRetroFit()
        obtenPeliculas()
        initRecyclerView()
    }

   private fun getRetroFit(): Retrofit {
        return Builder().baseUrl(servidor)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun initRecyclerView(){
        adapter = PeliculaAdapter(peliculas)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }


    private fun obtenPeliculas() {
        val endpoint: String = "peliculas"

        CoroutineScope(Dispatchers.IO).launch {
            // El código se ejecuta en un hilo secundario.

            val respuesta: Response<PeliculasResponse> = getRetroFit()
                    .create(APIService::class.java).getPeliculas(endpoint)
            val pelis: PeliculasResponse? = respuesta.body()

            runOnUiThread{
                if (respuesta.isSuccessful){
                    val cartelera: List<Pelicula> = pelis?.peliculas?: emptyList()

                    peliculas.clear()
                    peliculas.addAll(cartelera)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show()
    }

}