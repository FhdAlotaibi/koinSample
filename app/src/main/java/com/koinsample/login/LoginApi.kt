package com.koinsample.login

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST


class LoginBody(val username: String, val password: String)
interface LoginApi {

    @POST("login")
    fun login(@Body body: LoginBody): Single<UserDetails>
}