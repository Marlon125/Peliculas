package com.marlon.peliculas.application.model

data class Movie(
    val id: Int = 0,
    val vote_count : String = "",
    val vote_average : String = "",
    val title : String = "",
    val popularity : String = "",
    val poster_path : String = "",
    val original_language : String = "",
    val original_title : String = "",
    val overview : String = ""
)