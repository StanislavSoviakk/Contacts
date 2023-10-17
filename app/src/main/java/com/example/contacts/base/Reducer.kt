package com.example.contacts.base

interface Reducer<STATE, EVENT> {

    val initState: STATE
    fun reduce(event: EVENT, state: STATE): STATE
}