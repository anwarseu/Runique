package me.dotcode.core.data.di

import me.dotcode.core.data.networking.HttpClientFactory
import me.dotcode.core.data.auth.EncryptedSessionStorage
import me.dotcode.core.data.run.OfflineFirstRunRepository
import me.dotcode.core.domain.SessionStorage
import me.dotcode.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}