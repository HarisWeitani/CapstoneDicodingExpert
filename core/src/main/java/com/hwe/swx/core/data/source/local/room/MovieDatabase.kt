package com.hwe.swx.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hwe.swx.core.data.source.local.entity.MovieTopRatedEntity

@Database(entities = [MovieTopRatedEntity::class], version = 2, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){

    abstract fun movieDAO() : MovieDAO

}