package com.hwe.swx.core.data.source.remote.response

data class ResponseMoviesPopular(
    val page: Int = 0,
    val results: List<Result> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class Result(
    val id: Int = 0,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val vote_average: Int = 0,
    val vote_count: Int = 0
)