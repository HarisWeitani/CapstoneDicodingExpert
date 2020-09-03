package com.hwe.swx.core.data.source.remote.response

data class ResponseMoviesTopRated(
    val page: Int = 0,
    val results: List<MovieResult> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)

data class MovieResult(
    val id: Int = 0,
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)