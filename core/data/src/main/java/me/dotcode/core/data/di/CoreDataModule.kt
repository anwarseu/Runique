package me.dotcode.core.data.di

import me.dotcode.core.data.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}