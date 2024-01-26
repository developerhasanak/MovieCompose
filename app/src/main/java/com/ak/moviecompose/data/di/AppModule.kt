package com.ak.moviecompose.data.di

import com.ak.moviecompose.data.remote.MovieAPI
import com.ak.moviecompose.data.repository.MovieRepositoryImpl
import com.ak.moviecompose.domain.repository.MovieRepository
import com.ak.moviecompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieAPI::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: MovieAPI): MovieRepository = MovieRepositoryImpl(api)

}