package com.android.flowpractice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") query: String
    ): Response<GithubData>

//    abstract fun getRepositories(queryString: String): Any*/
}