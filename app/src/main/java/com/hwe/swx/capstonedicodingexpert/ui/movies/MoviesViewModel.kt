package com.hwe.swx.capstonedicodingexpert.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hwe.swx.core.domain.usecase.MovieUseCase

class MoviesViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val moviesTopRated = movieUseCase.getAllMoviesTopRated().asLiveData()
}