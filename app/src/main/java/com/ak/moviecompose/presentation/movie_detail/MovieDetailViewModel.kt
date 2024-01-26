package com.ak.moviecompose.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.moviecompose.domain.model.MovieDetail
import com.ak.moviecompose.domain.use_case.get_movie_detail.GetMovieDetailUseCase
import com.ak.moviecompose.util.Constants.IMDB_ID
import com.ak.moviecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor (
    private val useCase: GetMovieDetailUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail (imdbid : String) {

        useCase.executeGetMovieDetails(imdbid).onEach {
           when(it){
             is Resource.Success -> {
                 _state.value = _state.value.copy(movie = it.data )
                 _state.value = _state.value.copy(isLoading = false )

             }

             is Resource.Error -> {
                 _state.value = _state.value.copy(error = it.message ?: "Error!")

             }

             is Resource.Loading -> {
                _state.value = _state.value.copy(isLoading = true)
             }

           }


        }.launchIn(viewModelScope)


    }
}