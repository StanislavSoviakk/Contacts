package com.example.contacts.ui.create_user.use_cases

import com.example.contacts.ui.create_user.EditProfileEvent
import com.example.contacts.ui.create_user.EditProfileState
import com.example.core.base.UseCase
import com.example.domain.repository.CurrentUserRepository

class LoadUserEditableProfileUseCase(private val currentUserRepository: CurrentUserRepository) :
    UseCase<EditProfileEvent, EditProfileState> {
    override fun canHandle(event: EditProfileEvent): Boolean = event is EditProfileEvent.LoadUser

    override suspend fun invoke(event: EditProfileEvent, state: EditProfileState): EditProfileEvent {
        if (event is EditProfileEvent.LoadUser) {
            return EditProfileEvent.UserLoaded(currentUserRepository.getCurrentUser())
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}