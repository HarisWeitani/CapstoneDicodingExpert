package com.hwe.swx.capstonedicodingexpert.di.koin

import com.hwe.swx.core.domain.usecase.MovieInteractor
import com.hwe.swx.core.domain.usecase.MovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}