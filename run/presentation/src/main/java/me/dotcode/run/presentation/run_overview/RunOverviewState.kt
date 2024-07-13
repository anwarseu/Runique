package me.dotcode.run.presentation.run_overview

import me.dotcode.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
