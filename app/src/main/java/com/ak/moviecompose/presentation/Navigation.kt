package com.ak.moviecompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ak.moviecompose.presentation.movie_detail.views.MovieDetailScreen
import com.ak.moviecompose.presentation.movies.views.MovieScreen
import com.ak.moviecompose.util.Constants.IMDB_ID


@Composable
fun Navigation() {
    val navController  = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MovieScreen.route ) {
        composable(Screen.MovieScreen.route){
            MovieScreen(navController = navController)
        }

        composable(Screen.MovieDetailScreen.route+"/{${IMDB_ID }}",

        ){
            MovieDetailScreen()
        }
    }
}