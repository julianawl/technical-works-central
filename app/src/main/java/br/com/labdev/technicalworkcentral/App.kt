package br.com.labdev.technicalworkcentral

import android.app.Application
import br.com.labdev.technicalworkcentral.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(
                listOf(
                    detailsModule,
                    documentRegisterModule,
                    homeModule,
                    loginModule,
                    profileModule,
                    registerModule
                )
            )
        }
    }
}