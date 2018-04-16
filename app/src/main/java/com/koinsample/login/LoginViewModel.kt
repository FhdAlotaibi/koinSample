package com.koinsample.login

import android.arch.lifecycle.MutableLiveData
import com.koinsample.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class LoginEvent(
        val isLoading: Boolean = true,
        val isSuccess: Boolean = false,
        val error: String? = null,
        val response: UserDetails? = null
)

class LoginViewModel(val loginRepository: LoginRepository, val uiScheduler: Scheduler, val io: Scheduler) : BaseViewModel() {

    private val loginEvent = MutableLiveData<LoginEvent>()

    fun login(username: String, password: String): MutableLiveData<LoginEvent> {

        loginRepository.login(username, password).observeOn(uiScheduler).subscribeOn(io).subscribe(object : SingleObserver<UserDetails> {

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }

            override fun onSuccess(t: UserDetails) {
                loginEvent.value = LoginEvent(isLoading = false, isSuccess = true, response = t)
            }

            override fun onError(e: Throwable) {
                loginEvent.value = LoginEvent(isLoading = false, isSuccess = false, error = e.message)
            }
        })

        return loginEvent
    }

}