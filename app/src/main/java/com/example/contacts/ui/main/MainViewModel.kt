package com.example.contacts.ui.main

import androidx.lifecycle.ViewModel
import com.example.contacts.preferences.PreferencesManager
import com.example.contacts.ui.Screen

class MainViewModel(private val preferencesManager: PreferencesManager) : ViewModel() {

    fun getStartDestination(): String {
        return if (preferencesManager.checkIfUserWasCreated()) {
            Screen.ProfileScreen.route
        } else {
            Screen.EditProfileScreen.route
        }
    }
}