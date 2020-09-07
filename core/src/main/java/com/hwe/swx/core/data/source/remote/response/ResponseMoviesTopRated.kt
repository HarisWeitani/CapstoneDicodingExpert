package com.hwe.swx.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseMoviesTopRated(
    @field:SerializedName("page")
    val page: Int = 0,

    @field:SerializedName("results")
    val results: List<MovieResult> = listOf(),

    @field:SerializedName("total_pages")
    val total_pages: Int = 0,

    @field:SerializedName("total_results")
    val total_results: Int = 0
)

data class MovieResult(
    @field:SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("overview")
    val overview: String = "",

    @field:SerializedName("popularity")
    val popularity: Double = 0.0,

    @field:SerializedName("poster_path")
    val poster_path: String = "",

    @field:SerializedName("release_date")
    val release_date: String = "",

    @field:SerializedName("title")
    val title: String = "",

    @field:SerializedName("vote_average")
    val vote_average: Double = 0.0,

    @field:SerializedName("vote_count")
    val vote_count: Int = 0
)