package me.dotcode.wear.app.presentation

import android.app.Application
import me.dotcode.wear.run.data.di.wearRunDataModule
import me.dotcode.wear.run.presentation.di.runPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                runPresentationModule,
                wearRunDataModule
            )
        }
    }
}