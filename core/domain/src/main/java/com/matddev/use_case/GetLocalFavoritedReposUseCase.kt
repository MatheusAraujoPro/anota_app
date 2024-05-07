package com.matddev.use_case

import com.matddev.repository.RepoRepository

class GetLocalFavoritedReposUseCase(
    private val repository: RepoRepository
) {
    suspend operator fun invoke(): List<Int> {
        return repository.getStoredRepoIds()
    }
}