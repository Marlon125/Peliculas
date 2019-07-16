package com.marlon.peliculas.application.model

data class Movie(
    val id: Int = 0,
    val backdrop_path : String = "",
    val homepage : String = "",
    val original_title : String = "",
    val overview : String = "",
    val popularity : String = "",
    val poster_path : String = "",
    val vote_average : String = "",
    val status : String = ""
)