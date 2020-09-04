package `in`.nitin.supersub.repository

import `in`.nitin.supersub.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getDrill() = apiHelper.getDrill()
}