package me.dotcode.run.presentation.active_run

import me.dotcode.core.presentation.ui.UiText

interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}