package com.hwe.swx.core.data.source.local.room

import androidx.room.*
import com.hwe.swx.core.data.source.local.entity.MovieTopRatedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Query("SELECT * FROM MovieTopRatedEntity ORDER BY popularity DESC")
    fun getAllMoviesTopRated() : Flow<List<MovieTopRatedEntity>>

    @Query("SELECT * FROM MovieTopRatedEntity WHERE is_favorite = 1 ORDER BY popularity DESC")
    fun getAllMoviesPopularFavorite() : Flow<List<MovieTopRatedEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMoviesPopular(movieList : List<MovieTopRatedEntity>)

    @Update
    suspend fun updateMoviesFavorite(movie : MovieTopRatedEntity)
}