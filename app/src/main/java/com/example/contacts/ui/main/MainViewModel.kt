package com.example.contacts.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import com.example.contacts.preferences.PreferencesManager
import com.example.contacts.ui.Screen
import com.example.contacts.common.Router

class MainViewModel(val router: Router, private val preferencesManager: PreferencesManager) :
    ViewModel() {

    fun getStartDestination(): String {
        return if (preferencesManager.checkIfUserWasCreated()) {
            Screen.ProfileScreen.route
        } else {
            Screen.EditProfileScreen.route
        }
    }

    fun openProfileTab() {
        val navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
        router.navigateTo(Screen.ProfileScreen.route, navOptions)
    }

    fun openContactsTab() {
        val navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
        router.navigateTo(Screen.ContactsScreen.route, navOptions)
    }
}