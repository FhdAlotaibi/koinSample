package com.koinsample.login

import com.koinsample.di.createApi
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val login_module = applicationContext {

    bean {
        viewModel { LoginViewModel(get(), get("uiScheduler"), get("ioScheduler")) }
    }

    bean {
        LoginRepositoryImpl(get()) as LoginRepository
    }

    bean {
        createApi<LoginApi>(get())
    }
}