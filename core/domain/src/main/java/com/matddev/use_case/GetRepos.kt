package com.matddev.use_case

import com.matddev.model.Repo
import com.matddev.repository.RepoRepository

class GetRepos(private val repository: RepoRepository) {
    suspend operator fun invoke(): List<Repo>{
        return repository.getRepos()
    }
}