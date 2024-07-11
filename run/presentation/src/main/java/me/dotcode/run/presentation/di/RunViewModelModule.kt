package me.dotcode.run.presentation.di

import me.dotcode.run.presentation.active_run.ActiveRunViewModel
import me.dotcode.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}