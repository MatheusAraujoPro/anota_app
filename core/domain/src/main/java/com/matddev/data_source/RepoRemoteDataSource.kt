package com.matddev.data_source

import com.matddev.model.Repo

interface RepoRemoteDataSource {
    suspend fun getRepos(): List<Repo>
    suspend fun getPagingRepos(pageSize: Int, page: Int): List<Repo>
}