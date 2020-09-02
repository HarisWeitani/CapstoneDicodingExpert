package com.hwe.swx.core.data.source.remote.network

import com.hwe.swx.core.data.source.remote.response.ResponseMoviesPopular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/genre/movie/popular")
    suspend fun getAllGenres(): ResponseMoviesPopular

    @GET("/3/search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page : Int
    ) : ResponseMoviesPopular
}
