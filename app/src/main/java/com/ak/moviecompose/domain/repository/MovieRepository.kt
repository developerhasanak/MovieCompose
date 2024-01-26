package com.ak.moviecompose.domain.repository

import com.ak.moviecompose.data.remote.dto.MovieDetailDto
import com.ak.moviecompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}