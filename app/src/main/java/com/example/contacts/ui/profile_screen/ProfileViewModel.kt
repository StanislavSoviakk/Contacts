package com.example.contacts.ui.profile_screen

import com.example.contacts.base.BaseViewModel
import com.example.contacts.base.Router
import com.example.contacts.ui.Screen
import com.example.contacts.ui.profile_screen.use_cases.LoadUserNonEditableProfileUseCase

class ProfileViewModel(val router: Router, loadUserUseCase: LoadUserNonEditableProfileUseCase) :
    BaseViewModel<ProfileEvent, ProfileState>(
        reducer = ProfileReducer(), useCasesList = listOf(loadUserUseCase)
    ) {

    init {
        loadUser()
    }

    private fun loadUser() {
        handleEvent(ProfileEvent.LoadUser)
    }

    fun editProfile() {
        router.navigateTo(Screen.EditProfileScreen.route)
    }
}