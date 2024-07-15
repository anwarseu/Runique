package me.dotcode.wear.run.data.di

import me.dotcode.wear.run.data.HealthServicesExerciseTracker
import me.dotcode.wear.run.data.WatchToPhoneConnector
import me.dotcode.wear.run.domain.ExerciseTracker
import me.dotcode.wear.run.domain.PhoneConnector
import me.dotcode.wear.run.domain.RunningTracker
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
    singleOf(::WatchToPhoneConnector).bind<PhoneConnector>()
    singleOf(::RunningTracker)
    single {
        get<RunningTracker>().elapsedTime
    }
}