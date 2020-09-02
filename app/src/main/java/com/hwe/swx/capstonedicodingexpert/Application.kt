package com.hwe.swx.capstonedicodingexpert

import android.app.Application
import com.hwe.swx.capstonedicodingexpert.di.koin.useCaseModule
import com.hwe.swx.capstonedicodingexpert.di.koin.viewModelModule
import com.hwe.swx.core.di.koin.databaseModule
import com.hwe.swx.core.di.koin.networkModule
import com.hwe.swx.core.di.koin.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    useCaseModule
                )
            )
        }
    }
}