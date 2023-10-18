package com.example.contacts.ui.create_user.use_cases

import com.example.contacts.base.UseCase
import com.example.contacts.domain.repository.CurrentUserRepository
import com.example.contacts.preferences.PreferencesManager
import com.example.contacts.ui.create_user.CreateUserEvent
import com.example.contacts.ui.create_user.CreateUserState

class SaveUserUseCase(
    private val currentUserRepository: CurrentUserRepository,
    private val preferencesManager: PreferencesManager
) : UseCase<CreateUserEvent, CreateUserState> {
    override fun canHandle(event: CreateUserEvent): Boolean = event is CreateUserEvent.SaveUser

    override suspend fun invoke(event: CreateUserEvent, state: CreateUserState): CreateUserEvent {
        if (event is CreateUserEvent.SaveUser) {
            currentUserRepository.saveCurrentUser(event.user)
            preferencesManager.saveUserEnteredData()
            return CreateUserEvent.UserSaved
        }
        throw IllegalArgumentException("Unexpected event: $event")
    }
}