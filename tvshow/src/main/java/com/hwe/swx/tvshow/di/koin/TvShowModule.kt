package com.hwe.swx.tvshow.di.koin

import com.hwe.swx.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tvshowModule = module {
    viewModel { TvShowViewModel(get()) }
}