package me.dotcode.run.domain

import me.dotcode.core.connectivity.domain.DeviceNode
import me.dotcode.core.connectivity.domain.messaging.MessagingAction
import me.dotcode.core.connectivity.domain.messaging.MessagingError
import me.dotcode.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface WatchConnector {
    val connectedDevice: StateFlow<DeviceNode?>
    val messagingActions: Flow<MessagingAction>

    suspend fun sendActionToWatch(action: MessagingAction): EmptyResult<MessagingError>
    fun setIsTrackable(isTrackable: Boolean)
}