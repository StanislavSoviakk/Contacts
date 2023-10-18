package com.example.contacts.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contacts.preferences.PreferencesManager
import com.example.contacts.ui.Screen

class MainViewModel(private val preferencesManager: PreferencesManager) : ViewModel() {

    fun getStartDestination(): String {
        return if (preferencesManager.checkIfUserEnteredData()) {
            //Open ContactsScreen
            Log.d("Navigation", "Open Contacts Screen")
            Screen.CreateUserScreen.route
        } else {
            Screen.CreateUserScreen.route
        }
    }
}