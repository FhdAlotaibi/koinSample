package com.koinsample

import android.app.Application
import com.koinsample.di.DatasourceProperties.SERVER_URL
import com.koinsample.di.components_modules
import com.koinsample.di.koinModules
import com.koinsample.di.netowrkModule
import org.koin.android.ext.android.startKoin

class KoinApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules + netowrkModule + components_modules,
                properties = hashMapOf(SERVER_URL to "https://demo8768859.mockable.io/"))
    }

}