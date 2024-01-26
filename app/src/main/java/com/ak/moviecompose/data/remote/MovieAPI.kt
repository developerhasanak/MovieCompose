package com.ak.moviecompose.data.remote

import com.ak.moviecompose.data.remote.dto.MovieDetailDto
import com.ak.moviecompose.data.remote.dto.MoviesDto
import com.ak.moviecompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apikey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbID : String,
        @Query("apikey") apikey : String = API_KEY
    ) : MovieDetailDto

}