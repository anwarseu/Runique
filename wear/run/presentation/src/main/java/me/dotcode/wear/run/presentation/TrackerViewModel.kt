package me.dotcode.wear.run.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.dotcode.wear.run.domain.ExerciseTracker
import me.dotcode.wear.run.domain.PhoneConnector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TrackerViewModel(
    private val exerciseTracker: ExerciseTracker,
    private val phoneConnector: PhoneConnector
): ViewModel() {

    var state by mutableStateOf(TrackerState())
        private set

    private val hasBodySensorPermission = MutableStateFlow(false)

    init {
        phoneConnector
            .connectedNode
            .filterNotNull()
            .onEach { connectedNodes ->
                state = state.copy(
                    isConnectedPhoneNearby = connectedNodes.isNearby
                )
            }
            .launchIn(viewModelScope)
    }

    fun onAction(action: TrackerAction) {
        when(action) {
            is TrackerAction.OnBodySensorPermissionResult -> {
                hasBodySensorPermission.value = action.isGranted
                if(action.isGranted) {
                    viewModelScope.launch {
                        val isHeartRateTrackingSupported = exerciseTracker.isHeartRateTrackingSupported()
                        state = state.copy(
                            canTrackHeartRate = isHeartRateTrackingSupported
                        )
                    }
                }
            }
            TrackerAction.OnFinishRunClick -> Unit
            TrackerAction.OnToggleRunClick -> Unit
        }
    }
}