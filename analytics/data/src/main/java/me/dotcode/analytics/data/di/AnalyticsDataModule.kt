package me.dotcode.analytics.data.di

import me.dotcode.analytics.data.RoomAnalyticsRepository
import me.dotcode.analytics.domain.AnalyticsRepository
import me.dotcode.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}