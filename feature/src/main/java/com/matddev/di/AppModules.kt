package com.matddev.di

import android.content.Context
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.matddev.Constants
import com.matddev.file_manager.navigation.definition.FileManagerNavigation
import com.matddev.file_manager.navigation.implementation.FileManagerNavigationImpl
import com.matddev.file_manager.screens.create_files.CreateFileViewModel
import com.matddev.repository.FileRepository
import com.matddev.repository.FileRepositoryImpl
import com.matddev.use_case.WriteFileUseCase
import com.matddev.utils.NavigationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single {
        PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            produceFile = { get<Context>().preferencesDataStoreFile(Constants.Constants.DATA_STORE_NAME) }
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
    viewModel { CreateFileViewModel() }
}

val useCaseModules = module {
    factory { WriteFileUseCase(get()) }
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
    single<FileManagerNavigation> { FileManagerNavigationImpl(get()) }
}