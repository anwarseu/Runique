package me.dotcode.run.presentation.di

import me.dotcode.run.domain.RunningTracker
import me.dotcode.run.presentation.active_run.ActiveRunViewModel
import me.dotcode.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}