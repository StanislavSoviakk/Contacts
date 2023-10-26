package com.example.contacts.ui.create_user

import androidx.navigation.NavOptions
import com.example.contacts.ui.Screen
import com.example.contacts.ui.create_user.use_cases.LoadUserEditableProfileUseCase
import com.example.contacts.ui.create_user.use_cases.SaveUserUseCase
import com.example.core.base.BaseViewModel
import com.example.core.base.Router

class EditProfileViewModel(
    val router: Router,
    saveUserUseCase: SaveUserUseCase,
    loadUserUseCase: LoadUserEditableProfileUseCase
) : BaseViewModel<EditProfileEvent, EditProfileState>(
    reducer = EditProfileReducer(), useCasesList = listOf(saveUserUseCase, loadUserUseCase)
) {

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