package com.hwe.swx.core.domain.model

data class Movie(
    val id: Int = 0,
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    val is_favorite: Boolean = false
)