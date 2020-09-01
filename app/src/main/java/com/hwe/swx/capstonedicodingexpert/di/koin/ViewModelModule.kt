package com.hwe.swx.capstonedicodingexpert.di.koin

import com.hwe.swx.capstonedicodingexpert.ui.detail.MovieDetailViewModel
import com.hwe.swx.capstonedicodingexpert.ui.favorite.FavoriteViewModel
import com.hwe.swx.capstonedicodingexpert.ui.movies.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesViewModel() }
    viewModel { FavoriteViewModel() }
    viewModel { MovieDetailViewModel() }
}