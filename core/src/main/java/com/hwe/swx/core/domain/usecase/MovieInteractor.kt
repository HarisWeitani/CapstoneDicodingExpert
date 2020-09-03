package com.hwe.swx.core.domain.usecase

import com.hwe.swx.core.data.Resource
import com.hwe.swx.core.domain.model.Movie
import com.hwe.swx.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getAllMoviesTopRated(): Flow<Resource<List<Movie>>> =
        movieRepository.getAllMoviesTopRated()

}