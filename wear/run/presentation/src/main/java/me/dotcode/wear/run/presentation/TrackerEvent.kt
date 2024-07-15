package me.dotcode.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}