package com.matddev.di

import android.content.Context
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.matddev.RepoConstants
import com.matddev.file_manager.navigation.definition.GithubNavigation
import com.matddev.file_manager.navigation.implementation.GithubNavigationImpl
import com.matddev.repository.FileRepository
import com.matddev.repository.FileRepositoryImpl
import com.matddev.use_case.GetRepos
import com.matddev.utils.NavigationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
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

val dataSourceModules = module {
//    factory<RepoRemoteDataSource> { RepoRemoteDataSourceImpl(get()) }

}

val repositoriesModules = module {
    factory<FileRepository> { FileRepositoryImpl() }
}

val viewModelModules = module {
}

val useCaseModules = module {
    factory { GetRepos(get()) }
}

val networkModel = module {
    single { }
    factory { }
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