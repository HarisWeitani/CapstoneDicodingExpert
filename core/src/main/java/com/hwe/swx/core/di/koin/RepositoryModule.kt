package com.hwe.swx.core.di.koin

import com.hwe.swx.core.data.MovieRepository
import com.hwe.swx.core.data.source.local.LocalDataSource
import com.hwe.swx.core.data.source.remote.RemoteDataSource
import com.hwe.swx.core.domain.repository.IMovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IMovieRepository> {
        MovieRepository(get(), get())
    }
}