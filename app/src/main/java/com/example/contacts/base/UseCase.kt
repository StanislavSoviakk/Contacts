package com.example.contacts.base


interface UseCase<EVENT, STATE> {
    fun canHandle(event: EVENT):Boolean
    suspend fun invoke(event: EVENT, state: STATE): EVENT
}