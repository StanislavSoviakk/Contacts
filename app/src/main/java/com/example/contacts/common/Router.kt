package com.example.contacts.common

import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface Router {
    fun attach(navController: NavController)
    fun navigateTo(route: String, navOptions: NavOptions? = null)
    fun pop()
    fun detach()
}