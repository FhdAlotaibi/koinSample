package com.koinsample.di

import com.koinsample.app.login.*
import com.koinsample.network.api.LoginApi
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val components_modules = applicationContext {


    context(LoginActivity.LOGIN_CONTEXT) {

        viewModel { LoginViewModel(get(), get("uiScheduler"), get("ioScheduler")) }


        bean {
            LoginRepositoryImpl(get()) as LoginRepository
        }

        bean {
            createApi<LoginApi>(get())
        }
    }

}