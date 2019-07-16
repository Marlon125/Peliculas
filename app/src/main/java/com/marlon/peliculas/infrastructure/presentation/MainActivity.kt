package com.marlon.peliculas.infrastructure.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.failure
import com.github.kittinunf.result.success
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.marlon.peliculas.R
import com.marlon.peliculas.application.coordinator.MovieCoordinator
import com.marlon.peliculas.application.model.Movie
import com.marlon.peliculas.infrastructure.core.MovieApplication
import com.marlon.peliculas.infrastructure.utils.debug
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieCoordinator: MovieCoordinator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MovieApplication).movieComponent.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        setConnection()
    }

    private fun setConnection(){
        val movie = hashMapOf("id" to "2")
        movieCoordinator.addMovie(movie)
        Fuel.get("https://api.themoviedb.org/3/movie/upcoming?api_key=e842010883423b76bbe04698fb7eb89e")
            .responseString { _, _, result ->

                result.success {
                    val data = result.get()
                    debug(data)

                    val gson = Gson()
                    val map = HashMap<String, Any>()
                    val list = gson.fromJson(data, map::class.java)



                    val parser = JsonParser().parse(list["results"].toString())

                    if(parser.isJsonObject){
                        val movies = parser.asJsonObject
                        debug("JSON OBJECT ===>>>" + movies)
                    }



//                    val gson = GsonBuilder().setPrettyPrinting().create()
//                    val moviesList: Map<String, Any> = gson.fromJson(data, object : TypeToken<Map<String, Any>>() {}.type)
//                    moviesList.forEach{
//                        debug("INGRESO ===> 1 "+it)
////                        debug("INGRESO ===> 2 "+it.value.toString())
////                        val movie = hashMapOf(it.key to it.value.toString())
////                        movieCoordinator.addMovie(hashMapOf(it.key to it.value.toString()))
////                        movieCoordinator.addMovie(movie)
////                        debug("INGRESO ===> 2")
//                    }



                }

                result.failure { Toast.makeText(this,"error", Toast.LENGTH_LONG).show() }
            }
    }
}
