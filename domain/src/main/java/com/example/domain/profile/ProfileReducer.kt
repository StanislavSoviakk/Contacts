package com.example.domain.profile

import com.example.core.base.Reducer

class ProfileReducer() : Reducer<ProfileState, ProfileEvent> {
    override val initState: ProfileState = ProfileState()
    override fun reduce(event: ProfileEvent, state: ProfileState): ProfileState {
        return when (event) {
            is ProfileEvent.LoadUser -> state
            is ProfileEvent.UserLoaded -> state.copy(
                firstName = event.user.firstName,
                lastName = event.user.lastName,
                phoneNumber = event.user.phoneNumber,
                email = event.user.email,
                birthDate = event.user.birthDate,
                picture = event.user.picture
            )
        }
    }
}