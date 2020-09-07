package com.hwe.swx.capstonedicodingexpert.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hwe.swx.core.domain.usecase.MovieUseCase

class MainViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val moviesTopRated = movieUseCase.getAllMoviesTopRated().asLiveData()
}