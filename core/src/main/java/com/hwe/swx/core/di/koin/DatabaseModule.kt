package com.hwe.swx.core.di.koin

import androidx.room.Room
import com.hwe.swx.core.data.source.local.room.MovieDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<MovieDatabase>().movieDAO() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movies.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}