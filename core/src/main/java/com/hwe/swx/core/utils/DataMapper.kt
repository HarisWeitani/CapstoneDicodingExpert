package com.hwe.swx.core.utils

import com.hwe.swx.core.data.source.local.entity.MovieTopRatedEntity
import com.hwe.swx.core.data.source.remote.response.MovieResult
import com.hwe.swx.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResult>): List<MovieTopRatedEntity> {
        val movieList = ArrayList<MovieTopRatedEntity>()
        input.map {
            val movie = MovieTopRatedEntity(
                id = it.id,
                overview = it.overview,
                popularity = it.popularity,
                poster_path = it.poster_path,
                release_date = it.release_date,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                is_favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieTopRatedEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                overview = it.overview,
                popularity = it.popularity,
                poster_path = it.poster_path,
                release_date = it.release_date,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                is_favorite = it.is_favorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieTopRatedEntity(
        id = input.id,
        overview = input.overview,
        popularity = input.popularity,
        poster_path = input.poster_path,
        release_date = input.release_date,
        title = input.title,
        vote_average = input.vote_average,
        vote_count = input.vote_count,
        is_favorite = input.is_favorite
    )
}