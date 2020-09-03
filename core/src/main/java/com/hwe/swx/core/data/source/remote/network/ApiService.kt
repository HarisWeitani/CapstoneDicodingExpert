package com.hwe.swx.core.data.source.remote.network

import com.hwe.swx.core.data.source.remote.response.ResponseMoviesTopRated
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/movie/top_rated")
    suspend fun getAllGenres(): ResponseMoviesTopRated

    @GET("/3/search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page : Int
    ) : ResponseMoviesTopRated
}
