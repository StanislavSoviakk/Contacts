package com.example.contacts.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contacts.R
import com.example.contacts.ui.Screen
import com.example.contacts.ui.add_contact.AddContact
import com.example.contacts.ui.contact_details.ContactDetailsScreen
import com.example.contacts.ui.contacts.Contacts
import com.example.contacts.ui.create_user.EditProfileScreen
import com.example.contacts.ui.profile_screen.ProfileScreen
import com.example.contacts.ui.theme.ContactsTheme
import com.example.core.base.Router
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val router: Router by inject()

    @OptIn(ExperimentalMaterial3Api::class)
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
                Scaffold(content = { padding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding), color = MaterialTheme.colorScheme.background
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
                            composable(route = Screen.ContactsScreen.route) {
                                Contacts()
                            }
                            composable(route = Screen.AddContactScreen.route) {
                                AddContact()
                            }
                            composable(route = Screen.ContactDetails.route + "/{uuid}") { backStackEntry ->
                                val uuid: String? = backStackEntry.arguments?.getString("uuid")
                                ContactDetailsScreen(uuid = uuid)
                            }
                        }
                    }
                }, bottomBar = {
                    BottomNavigation {
                        BottomNavigationItem(
                            selected = navController.currentDestination?.route == Screen.ContactsScreen.route,
                            onClick = viewModel::openContactsTab,
                            icon = { Icon(Icons.Filled.List, contentDescription = null) },
                            label = { Text(stringResource(id = R.string.contacts)) }
                        )
                        BottomNavigationItem(
                            selected = navController.currentDestination?.route == Screen.ProfileScreen.route,
                            onClick = viewModel::openProfileTab,
                            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
                            label = { Text(stringResource(id = R.string.profile)) }
                        )
                    }
                })
            }
        }
    }
}