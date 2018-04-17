package com.koinsample.app.login

import com.koinsample.entities.UserDetails
import com.koinsample.network.api.LoginApi
import com.koinsample.network.api.LoginBody
import io.reactivex.Single


class LoginRepositoryImpl(val loginApi: LoginApi) : LoginRepository {

    override fun login(userName: String, password: String): Single<UserDetails> {
        return loginApi.login(LoginBody(userName, password))
    }

}