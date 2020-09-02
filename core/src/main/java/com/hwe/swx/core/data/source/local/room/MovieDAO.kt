package com.hwe.swx.core.data.source.local.room

import androidx.room.*
import com.hwe.swx.core.data.source.local.entity.MoviePopularEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Query("SELECT * FROM MOVIEPOPULARENTITY ORDER BY popularity DESC")
    fun getAllMoviesPopular() : Flow<List<MoviePopularEntity>>

    @Query("SELECT * FROM MOVIEPOPULARENTITY WHERE is_favorite = 1 ORDER BY popularity DESC")
    fun getAllMoviesPopularFavorite() : Flow<List<MoviePopularEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMoviesPopular(movieList : List<MoviePopularEntity>)

    @Update
    suspend fun updateMoviesFavorite(movie : MoviePopularEntity)
}