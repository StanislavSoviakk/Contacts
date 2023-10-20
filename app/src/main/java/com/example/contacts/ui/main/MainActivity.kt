package com.example.contacts.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contacts.base.Router
import com.example.contacts.ui.Screen
import com.example.contacts.ui.create_user.EditProfileScreen
import com.example.contacts.ui.profile_screen.ProfileScreen
import com.example.contacts.ui.theme.ContactsTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val router: Router by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            router.attach(navController = navController)
            DisposableEffect(key1 = "key", effect = {
                onDispose {
                    router.detach()
                }
            })
            ContactsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = viewModel.getStartDestination()
                    ) {
                        composable(route = Screen.EditProfileScreen.route) {
                            EditProfileScreen()
                        }
                        composable(route = Screen.ProfileScreen.route) {
                            ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}