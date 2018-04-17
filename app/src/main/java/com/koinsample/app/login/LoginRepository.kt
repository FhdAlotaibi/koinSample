package com.koinsample.app.login

import com.koinsample.entities.UserDetails
import io.reactivex.Single

interface LoginRepository {


    fun login(userName: String, password: String): Single<UserDetails>
}