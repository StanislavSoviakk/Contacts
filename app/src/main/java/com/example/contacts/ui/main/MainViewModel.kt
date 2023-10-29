package com.example.contacts.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import com.example.contacts.ui.Screen
import com.example.contacts.common.Router
import com.example.domain.PreferencesManagerRepository

class MainViewModel(val router: Router, private val preferencesManager: PreferencesManagerRepository) :
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