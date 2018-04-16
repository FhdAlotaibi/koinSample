package com.koinsample.utils

import android.content.SharedPreferences

class PreferenceUtil(private val sharedPreferences: SharedPreferences) {

    companion object {

    }

    fun getStringValue(key: String): String? = sharedPreferences.getString(key, null)
    fun putStringValue(key: String, value: String) = sharedPreferences.edit().putString(key, value).commit()


}