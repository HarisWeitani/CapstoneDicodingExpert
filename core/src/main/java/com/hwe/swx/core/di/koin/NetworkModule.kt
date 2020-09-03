package com.hwe.swx.core.di.koin

import com.hwe.swx.core.BuildConfig
import com.hwe.swx.core.data.source.remote.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val newUrl =
                    original.url.newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build()

                val requestBuilder = original.newBuilder().url(newUrl).build()
                return chain.proceed(requestBuilder)
            }
        }).build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}