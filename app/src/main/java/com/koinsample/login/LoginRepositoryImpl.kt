package com.koinsample.login

import io.reactivex.Single


class LoginRepositoryImpl(val loginApi: LoginApi) : LoginRepository {

    override fun login(userName: String, password: String): Single<UserDetails> {
        return loginApi.login(LoginBody(userName, password))
    }

}