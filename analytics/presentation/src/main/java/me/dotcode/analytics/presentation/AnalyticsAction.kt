package me.dotcode.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}