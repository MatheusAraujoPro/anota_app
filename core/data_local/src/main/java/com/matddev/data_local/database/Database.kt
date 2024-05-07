package com.matddev.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matddev.data_local.database.dao.RepoDao
import com.matddev.data_local.database.model.RepoModel

@Database(
    entities = [ RepoModel::class ],
    version = 1
)
abstract class Database: RoomDatabase() {
    abstract fun repoDao(): RepoDao
}