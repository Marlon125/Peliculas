package com.marlon.peliculas.application.coordinator

import com.marlon.peliculas.application.inteerface.MovieRepository
import com.marlon.peliculas.application.model.Movie

class MovieCoordinator (private val movieRepository: MovieRepository){

    fun addMovie(movie: HashMap<String, String>){
        val newMovie = Movie(
            id = movie["id"]!!.toInt(),
             backdrop_path = movie["backdrop_path"].toString(),
             homepage = movie["homepage"].toString(),
             original_title  = movie["original_title"].toString(),
             overview  = movie["overview"].toString(),
             popularity = movie["popularity"].toString(),
             poster_path = movie["poster_path"].toString(),
             vote_average = movie["vote_average"].toString(),
             status = movie["status"].toString()
        )

        movieRepository.add(newMovie)
    }
}