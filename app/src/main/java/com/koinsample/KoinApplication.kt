package com.koinsample

import android.app.Application
import com.koinsample.di.appModule
import com.koinsample.di.koinModules
import com.koinsample.di.netowrkModule
import org.koin.android.ext.android.startKoin

class KoinApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules + netowrkModule)
    }


}