package com.marlon.peliculas.application.coordinator

import com.marlon.peliculas.application.inteerface.MovieRepository
import com.marlon.peliculas.application.model.Movie
import com.marlon.peliculas.infrastructure.utils.debug

class MovieCoordinator (private val movieRepository: MovieRepository){

    fun addMovie(movie: HashMap<String, String>){
        val newMovie = Movie(
            id = movie["id"]!!.toInt(),
             original_title  = movie["original_title"].toString(),
             overview  = movie["overview"].toString(),
             popularity = movie["popularity"].toString(),
             poster_path = movie["poster_path"].toString(),
             vote_average = movie["vote_average"].toString()
        )

        debug("Coordinator =====> $newMovie")

//        movieRepository.add(newMovie)
    }
}