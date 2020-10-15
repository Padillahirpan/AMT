package com.irpn.alodok.core.helper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.irpn.alodok.core.models.User


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class PrefHelper(private val context: Context) {
    companion object {
        const val PREF_USER_LOGIN = "pref_user_login"
    }

    private fun pref(): SharedPreferences {
        return context.getSharedPreferences("app-pref", Context.MODE_PRIVATE)
    }

    fun saveUser(data: User?) {
        pref().edit().putString(PREF_USER_LOGIN, Gson().toJson(data)).apply()
    }

    fun getUser(): User? {
        val user = pref().getString(PREF_USER_LOGIN, null)
        return Gson().fromJson(user, User::class.java)
    }
}