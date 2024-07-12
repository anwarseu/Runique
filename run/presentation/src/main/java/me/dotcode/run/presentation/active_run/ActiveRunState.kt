package me.dotcode.run.presentation.active_run

import me.dotcode.core.domain.location.Location
import me.dotcode.run.domain.RunData
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class ActiveRunState(
    val elapsedTime: Duration = Duration.ZERO,
    val runData: RunData = RunData(),
    val shouldTrack: Boolean = false,
    val hasStartedRunning: Boolean = false,
    val currentLocation: Location? = null,
    val isRunFinished: Boolean = false,
    val isSavingRun: Boolean = false,
    val showLocationRationale: Boolean = false,
    val showNotificationRationale: Boolean = false
)
