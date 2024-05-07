package com.matddev.data_local.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.matddev.model.Repo

@Entity(tableName = "repo")
data class RepoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val repositoryId: Int,
    val name: String,
    val description: String?,
    val language: String?
)

fun RepoModel.toDomainRepo(): Repo {
    return Repo(
        id = repositoryId,
        name = name,
        description = description,
        language = language,
        localID = id
    )
}