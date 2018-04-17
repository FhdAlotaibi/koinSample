package com.koinsample.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {


    private var releaseContext: Boolean = true

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        releaseContext = false
    }

    override fun onDestroy() {
        super.onDestroy()
        if (releaseContext) onReleaseContext()
    }

    abstract fun onReleaseContext()

}