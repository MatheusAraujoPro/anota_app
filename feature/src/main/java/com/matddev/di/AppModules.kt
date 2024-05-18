package com.matddev.di

import android.content.Context
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.matddev.RepoConstants
import com.matddev.data_local.data_source.RepoLocalDataSourceImpl
import com.matddev.data_local.database.Database
import com.matddev.data_source.RepoLocalDataSource
import com.matddev.data_source.RepoRemoteDataSource
import com.matddev.data_source.RepoRemoteDataSourceImpl
import com.matddev.file_manager.navigation.definition.GithubNavigation
import com.matddev.file_manager.navigation.implementation.GithubNavigationImpl
import com.matddev.provideGitHubWebService
import com.matddev.provideRetrofit
import com.matddev.repository.RepoRepository
import com.matddev.repository.RepoRepositoryImpl
import com.matddev.use_case.GetRepos
import com.matddev.utils.NavigationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModules = module {
    single {
        PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            produceFile = { get<Context>().preferencesDataStoreFile(RepoConstants.Constants.DATA_STORE_NAME) }
        )
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "repository-database"
        ).build()
    }

    single { get<Database>().repoDao() }
}

val dataSourceModules = module {
    factory<RepoRemoteDataSource> { RepoRemoteDataSourceImpl(get()) }
    factory<RepoLocalDataSource> { RepoLocalDataSourceImpl(get()) }
}

val repositoriesModules = module {
    factory<RepoRepository> { RepoRepositoryImpl(get(), get()) }
}

val viewModelModules = module {
}

val useCaseModules = module {
    factory { GetRepos(get()) }
}

val networkModel = module {
    single { provideRetrofit() }
    factory { provideGitHubWebService(get()) }
}

val navigationModel = module {
    single {
        NavigationManager(
            CoroutineScope(
                SupervisorJob() + Dispatchers.Main
            )
        )
    }
    single<GithubNavigation> { GithubNavigationImpl(get()) }
}