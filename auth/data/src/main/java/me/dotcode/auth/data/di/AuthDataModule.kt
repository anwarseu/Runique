package me.dotcode.auth.data.di

import me.dotcode.auth.data.AuthRepositoryImpl
import me.dotcode.auth.data.EmailPatternValidator
import me.dotcode.auth.domain.AuthRepository
import me.dotcode.auth.domain.PatternValidator
import me.dotcode.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}