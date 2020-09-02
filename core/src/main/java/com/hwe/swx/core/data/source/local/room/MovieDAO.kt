package com.hwe.swx.core.data.source.local.room

import androidx.room.*
import com.hwe.swx.core.data.source.local.entity.MoviePopularTopRated
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Query("SELECT * FROM MoviePopularTopRated ORDER BY popularity DESC")
    fun getAllMoviesTopRated() : Flow<List<MoviePopularTopRated>>

    @Query("SELECT * FROM MoviePopularTopRated WHERE is_favorite = 1 ORDER BY popularity DESC")
    fun getAllMoviesPopularFavorite() : Flow<List<MoviePopularTopRated>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMoviesPopular(movieList : List<MoviePopularTopRated>)

    @Update
    suspend fun updateMoviesFavorite(movie : MoviePopularTopRated)
}