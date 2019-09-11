package com.example.testesantanderapp.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context) {

    private val msharedPreferences: SharedPreferences = context.getSharedPreferences(
        "appBanco",
        Context.MODE_PRIVATE
    )

    fun storeString(key: String, value: String){
        msharedPreferences.edit().putString(key,value).apply()
    }

    fun getStoredString(key: String): String? {
        return msharedPreferences.getString(key,"")
    }

    fun removeStoredString (key: String){
        msharedPreferences.edit().remove(key).apply()
    }
}