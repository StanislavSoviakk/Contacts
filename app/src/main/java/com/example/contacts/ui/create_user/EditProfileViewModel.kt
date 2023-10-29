package com.example.contacts.ui.create_user

import androidx.navigation.NavOptions
import com.example.contacts.ui.Screen
import com.example.domain.create_user.use_cases.LoadUserEditableProfileUseCase
import com.example.domain.create_user.use_cases.SaveUserUseCase
import com.example.contacts.common.BaseViewModel
import com.example.contacts.common.Router
import com.example.domain.create_user.EditProfileEvent
import com.example.domain.create_user.EditProfileReducer
import com.example.domain.create_user.EditProfileState

class EditProfileViewModel(
    val router: Router,
    saveUserUseCase: SaveUserUseCase,
    loadUserUseCase: LoadUserEditableProfileUseCase
) : BaseViewModel<EditProfileEvent, EditProfileState, EditProfileUIState>(
    reducer = EditProfileReducer(), useCasesList = listOf(saveUserUseCase, loadUserUseCase)
) {
    override val uiState: EditProfileUIState
        get() = state.value.toUIState()

    init {
        loadUser()
    }

    private fun loadUser() {
        handleEvent(EditProfileEvent.LoadUser)
    }

    fun saveUser() {
        handleEvent(EditProfileEvent.SaveUser)
        val navOptions = NavOptions.Builder()
            .setPopUpTo(Screen.ProfileScreen.route, true)
            .build()
        router.navigateTo(Screen.ProfileScreen.route, navOptions)
    }

    fun changeFirstName(firstName: String) {
        handleEvent(EditProfileEvent.FirstNameChanged(firstName))
    }

    fun changeLastName(lastName: String) {
        handleEvent(EditProfileEvent.LastNameChanged(lastName))
    }

    fun changeNumber(phoneNumber: String) {
        handleEvent(EditProfileEvent.PhoneNumberChanged(phoneNumber))
    }

    fun changeEmail(email: String) {
        handleEvent(EditProfileEvent.EmailChanged(email))
    }

    fun changeBirthday(birthDate: String) {
        handleEvent(EditProfileEvent.BirthDateChanged(birthDate))
    }

    fun setPicture(pictureUri: String) {
        handleEvent(EditProfileEvent.PictureSelected(pictureUri))
    }
}