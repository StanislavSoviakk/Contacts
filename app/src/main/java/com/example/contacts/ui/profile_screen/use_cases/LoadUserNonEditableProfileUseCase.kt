package com.example.contacts.ui.profile_screen.use_cases

import com.example.contacts.ui.profile_screen.ProfileEvent
import com.example.contacts.ui.profile_screen.ProfileState
import com.example.core.base.UseCase
import com.example.domain.repository.CurrentUserRepository

class LoadUserNonEditableProfileUseCase(private val currentUserRepository: CurrentUserRepository) :
    UseCase<ProfileEvent, ProfileState> {
    override fun canHandle(event: ProfileEvent): Boolean = event is ProfileEvent.LoadUser

    override suspend fun invoke(event: ProfileEvent, state: ProfileState): ProfileEvent {
        if (event is ProfileEvent.LoadUser) {
            return ProfileEvent.UserLoaded(currentUserRepository.getCurrentUser())
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}