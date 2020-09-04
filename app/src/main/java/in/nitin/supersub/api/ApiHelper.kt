package `in`.nitin.supersub.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getDrill() = apiService.getData()
}