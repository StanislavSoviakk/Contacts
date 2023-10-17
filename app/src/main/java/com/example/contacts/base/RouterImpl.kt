package com.example.contacts.base

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class RouterImpl: Router {

    private var navController: NavController? = null

    override fun attach(navController: NavController) {
        this.navController = navController
    }

    override fun navigateTo(route: String, navOptions: NavOptions?) {
        navController?.navigate(route, navOptions)
    }

    override fun pop() {
        navController?.popBackStack()
    }

    override fun detach() {
        navController = null
    }
}