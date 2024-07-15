package me.dotcode.run.domain

import me.dotcode.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

interface WatchConnector {
    val connectedDevice: StateFlow<DeviceNode?>

    fun setIsTrackable(isTrackable: Boolean)
}