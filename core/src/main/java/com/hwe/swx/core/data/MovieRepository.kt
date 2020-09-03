package com.hwe.swx.core.data

import com.hwe.swx.core.data.source.local.LocalDataSource
import com.hwe.swx.core.data.source.remote.RemoteDataSource
import com.hwe.swx.core.data.source.remote.network.ApiResponse
import com.hwe.swx.core.data.source.remote.response.ResponseMoviesTopRated
import com.hwe.swx.core.domain.model.Movie
import com.hwe.swx.core.domain.repository.IMovieRepository
import com.hwe.swx.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMovieRepository {

    override fun getAllMoviesTopRated(): Flow<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, ResponseMoviesTopRated>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMoviesTopRated().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data?.isEmpty() ?: true
            }

            override suspend fun createCall(): Flow<ApiResponse<ResponseMoviesTopRated>> {
                return remoteDataSource.getAllMoviesTopRated()
            }

            override suspend fun saveCallResult(data: ResponseMoviesTopRated) {
                val movieList = DataMapper.mapResponsesToEntities(data.results)
                localDataSource.insertMovieTopRated(movieList)
            }

        }.asFlow()
    }

}