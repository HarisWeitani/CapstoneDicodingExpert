package com.hwe.swx.capstonedicodingexpert.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hwe.swx.core.domain.model.Movie
import com.hwe.swx.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean) {
        viewModelScope.launch {
            movieUseCase.updateMoviesFavorite(movie, isFavorite)
        }
    }
}