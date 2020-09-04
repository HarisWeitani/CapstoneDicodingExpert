package com.hwe.swx.core.domain.usecase

import com.hwe.swx.core.data.Resource
import com.hwe.swx.core.domain.model.Movie
import com.hwe.swx.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getAllMoviesTopRated(): Flow<Resource<List<Movie>>> =
        movieRepository.getAllMoviesTopRated()

    override fun getAllMoviesFavorite(): Flow<List<Movie>> =
        movieRepository.getAllMoviesFavorite()

    override suspend fun updateMoviesFavorite(movie: Movie, isFavorite: Boolean) =
        movieRepository.updateMoviesFavorite(movie, isFavorite)


}