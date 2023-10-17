package com.example.contacts.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<EVENT : BaseEvent, STATE : BaseState>(
    private val reducer: Reducer<STATE, EVENT>,
    private val useCasesList: List<UseCase<EVENT, STATE>>,
) : ViewModel() {

    private val _state = MutableStateFlow(reducer.initState)
    val state: StateFlow<STATE> get() = _state

    private val eventHandlers = mutableListOf<EventHandler<EVENT>>()

    protected fun handleEvent(event: EVENT) {
        _state.value = reducer.reduce(event, state.value)

        eventHandlers.filter { it.canHandle(event) }.forEach { it.onEvent(event) }

        useCasesList.filter { it.canHandle(event) }.forEach {
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    val result = it.invoke(event, state.value)
                    handleEvent(result)
                }
            } catch (e: IllegalArgumentException) {
                Log.e("Event exception", e.message.toString())
            }
        }
    }

    fun doOnEvent(onEvent: (EVENT) -> Unit, canHandle: (EVENT) -> Boolean) {
        eventHandlers.add(EventHandler(onEvent = onEvent, canHandle = canHandle))
    }
}