package com.example.contacts.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val SHARED_PREFERENCES_NAME = "Prefs"
const val USER_PREFS_KEY = "user_prefs_key"

class PreferencesManager(
    context: Context
) {
    private val appContext = context.applicationContext

    private val preferences: SharedPreferences by lazy {
        appContext.getSharedPreferences(
            SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE
        )
    }

    fun saveUserWasCreated() {
        preferences.edit {
            putBoolean(USER_PREFS_KEY, true)
        }
    }

    fun checkIfUserWasCreated(): Boolean {
        return preferences.getBoolean(USER_PREFS_KEY, false)
    }
}