package com.coolblue.domain.exceptions

data class ConnectionException(
    override val message: String = "Connectivity issue"
) : Exception()