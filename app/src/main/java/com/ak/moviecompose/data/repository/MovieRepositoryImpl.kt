package com.ak.moviecompose.data.repository

import com.ak.moviecompose.data.remote.MovieAPI
import com.ak.moviecompose.data.remote.dto.MovieDetailDto
import com.ak.moviecompose.data.remote.dto.MoviesDto
import com.ak.moviecompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api : MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
       return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
       return api.getMovieDetail(imdbID = imdbId)
    }
}