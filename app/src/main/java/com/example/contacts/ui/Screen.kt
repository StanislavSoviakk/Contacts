package com.example.contacts.ui

sealed class Screen(val route: String) {
    object CreateUserScreen: Screen("create_user_screen")
}