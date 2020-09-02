package com.hwe.swx.core.domain.usecase

import com.hwe.swx.core.data.source.MovieRepository
import com.hwe.swx.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

}