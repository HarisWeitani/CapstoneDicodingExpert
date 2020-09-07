package com.hwe.swx.capstonedicodingexpert.di.koin

import com.hwe.swx.capstonedicodingexpert.ui.MainViewModel
import com.hwe.swx.capstonedicodingexpert.ui.detail.MovieDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}