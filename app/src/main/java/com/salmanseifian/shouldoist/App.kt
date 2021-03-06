package com.salmanseifian.shouldoist

import android.app.Application
import com.salmanseifian.shouldoist.di.dbModule
import com.salmanseifian.shouldoist.di.repositoryModule
import com.salmanseifian.shouldoist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }


    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                dbModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}
