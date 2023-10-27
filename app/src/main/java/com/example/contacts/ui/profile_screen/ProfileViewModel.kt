package com.example.contacts.ui.profile_screen

import com.example.contacts.common.BaseViewModel
import com.example.contacts.common.Router
import com.example.contacts.ui.Screen
import com.example.domain.profile.ProfileEvent
import com.example.domain.profile.ProfileReducer
import com.example.domain.profile.ProfileState
import com.example.domain.profile.use_cases.LoadUserNonEditableProfileUseCase

class ProfileViewModel(val router: Router, loadUserUseCase: LoadUserNonEditableProfileUseCase) :
    BaseViewModel<ProfileEvent, ProfileState, ProfileUIState>(
        reducer = ProfileReducer(), useCasesList = listOf(loadUserUseCase)
    ) {

    override val uiState: ProfileUIState
        get() = state.value.toUIState()

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