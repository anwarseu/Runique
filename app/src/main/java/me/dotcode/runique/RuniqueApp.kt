package me.dotcode.runique

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import me.dotcode.auth.data.di.authDataModule
import me.dotcode.auth.presentation.di.authViewModelModule
import me.dotcode.core.data.di.coreDataModule
import me.dotcode.run.location.di.locationModule
import me.dotcode.run.presentation.di.runPresentationModule
import me.dotcode.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                runPresentationModule,
                appModule,
                coreDataModule,
                locationModule
            )
        }
    }
}