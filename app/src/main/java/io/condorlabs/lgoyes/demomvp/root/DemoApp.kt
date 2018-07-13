package io.condorlabs.lgoyes.demomvp.root

import android.app.Application
import io.condorlabs.lgoyes.demomvp.login.LoginModule

class DemoApp : Application() {
    private lateinit var component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()


        component = DaggerApplicationComponent.builder()
                .applicationModule( ApplicationModule(this) )
                .loginModule( LoginModule() )
                .build()
    }

    fun getComponent() : ApplicationComponent = component
}