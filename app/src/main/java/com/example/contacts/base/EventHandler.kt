package com.example.contacts.base

class EventHandler<EVENT>(val onEvent: (EVENT) -> Unit, val canHandle: (EVENT) -> Boolean)