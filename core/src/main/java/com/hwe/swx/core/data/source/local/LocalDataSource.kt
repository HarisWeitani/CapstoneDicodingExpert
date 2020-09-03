package com.hwe.swx.core.data.source.local

import com.hwe.swx.core.data.source.local.entity.MovieTopRatedEntity
import com.hwe.swx.core.data.source.local.room.MovieDAO
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDAO: MovieDAO) {

    fun getAllMoviesTopRated(): Flow<List<MovieTopRatedEntity>> = movieDAO.getAllMoviesTopRated()

    fun getAllMoviesTopRatedFav(): Flow<List<MovieTopRatedEntity>> =
        movieDAO.getAllMoviesPopularFavorite()

    suspend fun insertMovieTopRated(movieList: List<MovieTopRatedEntity>) =
        movieDAO.insertAllMoviesPopular(movieList)


}