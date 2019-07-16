package com.marlon.peliculas.application.inteerface

import com.marlon.peliculas.application.model.Movie

interface MovieRepository{
    fun add(movie: Movie)
    fun search(): ArrayList<Movie>
}