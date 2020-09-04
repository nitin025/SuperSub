package `in`.nitin.supersub.api

import `in`.nitin.supersub.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("drill")
    suspend fun getData(): ApiResponse
}