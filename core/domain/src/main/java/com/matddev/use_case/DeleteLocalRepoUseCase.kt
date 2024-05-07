package com.matddev.use_case

import com.matddev.model.Repo
import com.matddev.repository.RepoRepository

class DeleteLocalRepoUseCase(
    private val repository: RepoRepository
) {
    suspend operator fun invoke(repo: Repo) {
        repository.deleteLocalRepo(repo = repo)
    }
}