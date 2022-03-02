package com.coolblue.domain.exceptions

/**
 * @author Juan Sebastian Niño
 */
data class ConnectionException(
    override val message: String = "Connectivity issue"
) : Exception()