package me.dotcode.run.data.di

import me.dotcode.core.domain.run.SyncRunScheduler
import me.dotcode.run.data.CreateRunWorker
import me.dotcode.run.data.DeleteRunWorker
import me.dotcode.run.data.FetchRunsWorker
import me.dotcode.run.data.SyncRunWorkerScheduler
import me.dotcode.run.data.connectivity.PhoneToWatchConnector
import me.dotcode.run.domain.WatchConnector
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
    singleOf(PhoneRun)
    singleOf(::PhoneToWatchConnector).bind<WatchConnector>()
}