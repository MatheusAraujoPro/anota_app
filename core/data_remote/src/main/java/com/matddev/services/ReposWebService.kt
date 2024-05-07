package com.matddev.services

import com.matddev.RepoConstants
import com.matddev.response.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposWebService {
    @GET(RepoConstants.WebConstants.GITHUB_URL_USER_REPO)
    suspend fun getRepos(): List<RepoResponse>

    @GET(RepoConstants.WebConstants.GITHUB_URL_USER_REPO)
    suspend fun getPagingRepos(
        @Query("per_page") pageSize: Int,
        @Query("page") page: Int,
    ): List<RepoResponse>
}