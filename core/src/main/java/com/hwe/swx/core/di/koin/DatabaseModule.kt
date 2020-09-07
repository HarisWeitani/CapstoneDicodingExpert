package com.hwe.swx.core.di.koin

import androidx.room.Room
import com.hwe.swx.core.data.source.local.room.MovieDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<MovieDatabase>().movieDAO() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("capstone".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movies"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}