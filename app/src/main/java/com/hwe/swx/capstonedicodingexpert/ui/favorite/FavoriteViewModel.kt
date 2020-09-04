package com.hwe.swx.capstonedicodingexpert.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hwe.swx.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val moviesFavorite = movieUseCase.getAllMoviesFavorite().asLiveData()

}