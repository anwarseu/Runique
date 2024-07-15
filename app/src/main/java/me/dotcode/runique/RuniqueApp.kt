package me.dotcode.runique

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import me.dotcode.auth.data.di.authDataModule
import me.dotcode.auth.presentation.di.authViewModelModule
import me.dotcode.core.data.di.coreDataModule
import me.dotcode.core.database.di.databaseModule
import me.dotcode.run.data.di.runDataModule
import me.dotcode.run.location.di.locationModule
import me.dotcode.run.network.di.networkModule
import me.dotcode.run.presentation.di.runPresentationModule
import me.dotcode.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import me.dotcode.core.connectivity.data.coreConnectivityDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule,
                coreConnectivityDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}