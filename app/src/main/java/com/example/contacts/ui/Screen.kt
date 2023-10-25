package com.example.contacts.ui

sealed class Screen(val route: String) {
    object EditProfileScreen : Screen("edit_profile_screen")
    object ProfileScreen : Screen("profile")
    object ContactsScreen: Screen("contacts")
    object AddContactScreen: Screen("add_contact")
    object ContactDetails: Screen("contact_details")
}