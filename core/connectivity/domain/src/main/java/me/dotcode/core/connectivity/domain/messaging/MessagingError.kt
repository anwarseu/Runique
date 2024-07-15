package me.dotcode.core.connectivity.domain.messaging

import me.dotcode.core.domain.util.Error
enum class MessagingError: Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}