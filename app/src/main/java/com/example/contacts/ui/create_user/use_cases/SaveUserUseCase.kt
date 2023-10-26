package com.example.contacts.ui.create_user.use_cases

import com.example.contacts.preferences.PreferencesManager
import com.example.contacts.ui.create_user.EditProfileEvent
import com.example.contacts.ui.create_user.EditProfileState
import com.example.core.base.UseCase
import com.example.domain.model.User
import com.example.domain.repository.CurrentUserRepository

class SaveUserUseCase(
    private val currentUserRepository: CurrentUserRepository,
    private val preferencesManager: PreferencesManager
) : UseCase<EditProfileEvent, EditProfileState> {
    override fun canHandle(event: EditProfileEvent): Boolean = event is EditProfileEvent.SaveUser

    override suspend fun invoke(
        event: EditProfileEvent,
        state: EditProfileState
    ): EditProfileEvent {
        if (event is EditProfileEvent.SaveUser) {
            currentUserRepository.saveCurrentUser(
                User(
                    firstName = state.firstName,
                    lastName = state.lastName,
                    phoneNumber = state.phoneNumber,
                    email = state.email,
                    birthDate = state.birthDate,
                    picture = state.picture
                )
            )
            preferencesManager.saveUserWasCreated()
            return EditProfileEvent.UserSaved
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}