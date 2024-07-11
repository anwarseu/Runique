package me.dotcode.auth.data.di

import me.dotcode.auth.data.EmailPatternValidator
import me.dotcode.auth.domain.PatternValidator
import me.dotcode.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}