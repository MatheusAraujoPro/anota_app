package com.matddev.data_source

import com.matddev.model.Repo

interface RepoLocalDataSource {
    suspend fun getRepos(): List<Repo>
    suspend fun saveRepo(repo: Repo)
    suspend fun getStoredRepoIds(): List<Int>
    suspend fun deleteLocalRepo(repo: Repo)
}