package com.ak.moviecompose.presentation.movie_detail

import com.ak.moviecompose.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String =""
)