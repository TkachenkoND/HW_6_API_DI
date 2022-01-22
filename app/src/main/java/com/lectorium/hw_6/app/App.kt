package com.lectorium.hw_6.app

import android.app.Application
import com.lectorium.hw_6.di.appModule
import com.lectorium.hw_6.di.dataModule
import com.lectorium.hw_6.di.domainModule
import com.lectorium.hw_6.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                dataModule,
                appModule,
                domainModule,
            ))
        }
    }
}