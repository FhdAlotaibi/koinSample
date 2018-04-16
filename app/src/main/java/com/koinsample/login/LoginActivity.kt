package com.koinsample.login

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.koinsample.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel
import org.koin.standalone.StandAloneContext.loadKoinModules

class LoginActivity : AppCompatActivity() {


    val loginViewModel by viewModel<LoginViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginBtn.setOnClickListener {
            loginViewModel.login(userNameTIL.editText?.text.toString(), passwordTIL.editText?.text.toString())
                    .observe(this, Observer<LoginEvent> {
                        it?.let {
                            onLoadingStateChanged(it.isLoading)
                            onErrorStateChanged(it.error)
                            if (it.isSuccess) {
                                Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    )
        }
    }

    private fun onLoadingStateChanged(show: Boolean) {
        progressBar.visibility = View.VISIBLE.takeIf { show } ?: View.GONE
        loginBtn.visibility = View.VISIBLE.takeIf { !show } ?: View.VISIBLE
    }

    private fun onErrorStateChanged(error: String?) {
        if (error == null) {
            userNameTIL.error = null
            passwordTIL.error = null
        } else {
            userNameTIL.error = error
            passwordTIL.error = error
        }
    }
}
