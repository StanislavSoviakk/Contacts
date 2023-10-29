package com.example.contacts.common

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseEvent
import com.example.core.base.BaseState
import com.example.core.base.EventHandler
import com.example.core.base.Reducer
import com.example.core.base.UseCase
import kotlinx.coroutines.launch


abstract class BaseViewModel<EVENT : BaseEvent, STATE : BaseState, UISTATE>(
    private val reducer: Reducer<STATE, EVENT>,
    private val useCasesList: List<UseCase<EVENT, STATE>>,
) : ViewModel() {

    protected val state = mutableStateOf(reducer.initState)
    abstract val uiState: UISTATE

    private val eventHandlers = mutableListOf<EventHandler<EVENT>>()

    protected fun handleEvent(event: EVENT) {
        state.value = reducer.reduce(event, state.value)

        eventHandlers.filter { it.canHandle(event) }.forEach { it.onEvent(event) }

        useCasesList.filter { it.canHandle(event) }.forEach {
            try {
                viewModelScope.launch {
                    val result = it.invoke(event, state.value)
                    handleEvent(result)
                }
            } catch (e: IllegalArgumentException) {
                Log.e("Event exception", e.message.toString())
            }
        }
    }

    fun doOnEvent(onEvent: (EVENT) -> Unit, canHandle: (EVENT) -> Boolean) {
        eventHandlers.add(
            EventHandler(
                onEvent = onEvent,
                canHandle = canHandle
            )
        )
    }
}