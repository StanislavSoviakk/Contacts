package com.example.core.base

class EventHandler<EVENT>(val onEvent: (EVENT) -> Unit, val canHandle: (EVENT) -> Boolean)