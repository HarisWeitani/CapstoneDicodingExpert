package com.hwe.swx.core.data.source

import com.hwe.swx.core.data.source.local.LocalDataSource
import com.hwe.swx.core.data.source.remote.RemoteDataSource
import com.hwe.swx.core.domain.repository.IMovieRepository

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMovieRepository{

}