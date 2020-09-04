package com.hwe.swx.core.domain.repository

import com.hwe.swx.core.data.Resource
import com.hwe.swx.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMoviesTopRated(): Flow<Resource<List<Movie>>>
    fun getAllMoviesFavorite(): Flow<List<Movie>>
    suspend fun updateMoviesFavorite(movie: Movie, isFavorite: Boolean)
}