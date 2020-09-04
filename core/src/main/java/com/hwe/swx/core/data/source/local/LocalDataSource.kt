package com.hwe.swx.core.data.source.local

import com.hwe.swx.core.data.source.local.entity.MovieTopRatedEntity
import com.hwe.swx.core.data.source.local.room.MovieDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalDataSource(private val movieDAO: MovieDAO) {

    fun getAllMoviesTopRated(): Flow<List<MovieTopRatedEntity>> = movieDAO.getAllMoviesTopRated()

    fun getAllMoviesTopRatedFav(): Flow<List<MovieTopRatedEntity>> =
        movieDAO.getAllMoviesPopularFavorite()

    suspend fun insertMovieTopRated(movieList: List<MovieTopRatedEntity>) =
        movieDAO.insertAllMoviesPopular(movieList)

    suspend fun setMovieFavorite(movie: MovieTopRatedEntity, isFavorite: Boolean) {
        withContext(Dispatchers.IO) {
            movie.is_favorite = isFavorite
            movieDAO.updateMoviesFavorite(movie)
        }
    }

}