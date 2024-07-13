package me.dotcode.run.data.di

import me.dotcode.run.data.CreateRunWorker
import me.dotcode.run.data.DeleteRunWorker
import me.dotcode.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}