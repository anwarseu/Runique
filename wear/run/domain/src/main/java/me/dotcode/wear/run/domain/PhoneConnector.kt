package me.dotcode.wear.run.domain

import me.dotcode.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
}