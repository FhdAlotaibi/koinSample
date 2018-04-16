package com.koinsample.utils

import android.content.Context
import android.support.annotation.StringRes

class StringProvider(val context: Context) {


    fun provide(@StringRes id: Int): String {
        return context.getString(id)
    }
}