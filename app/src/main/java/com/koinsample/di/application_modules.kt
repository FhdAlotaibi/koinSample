package com.koinsample.di

import android.preference.PreferenceManager
import com.koinsample.login.LoginViewModel
import com.koinsample.utils.PreferenceUtil
import com.koinsample.utils.StringProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {


    bean { StringProvider(androidApplication()) }

    bean { PreferenceUtil(PreferenceManager.getDefaultSharedPreferences(androidApplication())) }


}

val rxModule = applicationContext {
    bean("ioScheduler") { Schedulers.io() }
    bean("uiScheduler") { AndroidSchedulers.mainThread() }
}


val koinModules = listOf(appModule, rxModule)