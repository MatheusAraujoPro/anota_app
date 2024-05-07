package com.matddev.data_source

import com.matddev.model.Repo
import com.matddev.response.getRepo
import com.matddev.services.ReposWebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RepoRemoteDataSourceImpl(
    private val reposWebService: ReposWebService
) : RepoRemoteDataSource {
    override suspend fun getRepos(): List<Repo> {
        return withContext(Dispatchers.IO) {
            reposWebService.getRepos().map { repo -> repo.getRepo() }
        }
    }

    override suspend fun getPagingRepos(pageSize: Int, page: Int): List<Repo> {
        return withContext(Dispatchers.IO) {
            reposWebService.getPagingRepos(pageSize = pageSize, page = page)
                .map { repo -> repo.getRepo() }
        }
    }
}
