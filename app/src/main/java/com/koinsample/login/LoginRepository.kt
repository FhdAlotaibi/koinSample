package com.koinsample.login

import io.reactivex.Single

interface LoginRepository {


    fun login(userName: String, password: String): Single<UserDetails>
}