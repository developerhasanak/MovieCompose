@file:OptIn(ExperimentalMaterial3Api::class)

package com.ak.moviecompose.presentation.movies.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ak.moviecompose.presentation.Screen
import com.ak.moviecompose.presentation.movies.MoviesEvent
import com.ak.moviecompose.presentation.movies.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
       Column {
           MovieSearchBar(
               modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp),
               hint = "Batman"
           ) {
               viewModel.onEvent(MoviesEvent.Search(it))

           }

           LazyColumn(modifier = Modifier.fillMaxSize()){
               items(state.movies){ movie ->
                 MovieListRow(movie = movie, onItemClick = {
                     navController.navigate(Screen.MovieDetailScreen.route+"/${movie.imdbID}")
                 } )
               }
           }
       }
    }


}



@Preview
@Composable
fun MoviesScreenPreview(
) {


}

