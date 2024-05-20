package com.matddev.anotaapp

import android.app.Application
import com.matddev.di.appModules
import com.matddev.di.dataSourceModules
import com.matddev.di.navigationModel
import com.matddev.di.networkModel
import com.matddev.di.repositoriesModules
import com.matddev.di.useCaseModules
import com.matddev.di.viewModelModules
import com.matddev.anotaapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                appModules,
                dataSourceModules,
                repositoriesModules,
                networkModel,
                viewModelModules,
                useCaseModules,
                navigationModel,
                mainModule,
            )
        }.androidContext(applicationContext)
    }
}