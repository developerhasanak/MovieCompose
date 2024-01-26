package com.ak.moviecompose.presentation.movies

import com.ak.moviecompose.domain.model.Movie

data class MoviesState(
    val isLoding : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String ="batman"
)
