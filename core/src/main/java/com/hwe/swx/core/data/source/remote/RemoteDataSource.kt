package com.hwe.swx.core.data.source.remote

import com.hwe.swx.core.data.source.remote.network.ApiResponse
import com.hwe.swx.core.data.source.remote.network.ApiService
import com.hwe.swx.core.data.source.remote.response.ResponseMoviesTopRated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMoviesTopRated(): Flow<ApiResponse<ResponseMoviesTopRated>> {
        return flow {
            try {
                val response = apiService.getAllGenres()
                if(response.results.isEmpty()) {
                    emit(ApiResponse.Empty)
                }else{
                    emit(ApiResponse.Success(response))
                }
            } catch (e: IOException) {
                emit(ApiResponse.Error(e.localizedMessage))
            } catch (e: HttpException) {
                emit(ApiResponse.Error(e.localizedMessage))
            } catch (e: NullPointerException) {
                emit(ApiResponse.Error(e.localizedMessage))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.localizedMessage))
            }
        }.flowOn(Dispatchers.IO)
    }

}