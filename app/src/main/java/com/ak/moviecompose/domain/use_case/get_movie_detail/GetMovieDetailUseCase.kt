package com.ak.moviecompose.domain.use_case.get_movie_detail

import com.ak.moviecompose.data.remote.dto.toMovieDetail
import com.ak.moviecompose.data.remote.dto.toMovieList
import com.ak.moviecompose.domain.model.Movie
import com.ak.moviecompose.domain.model.MovieDetail
import com.ak.moviecompose.domain.repository.MovieRepository
import com.ak.moviecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetails = repository.getMovieDetail(imdbId = imdbId)
             emit(Resource.Success(movieDetails.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error(message = "No internet conncetion"))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }


}