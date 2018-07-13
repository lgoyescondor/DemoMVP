package io.condorlabs.lgoyes.demomvp.root

import android.app.Application

class DemoApp : Application() {
    private lateinit var component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()


        component = DaggerApplicationComponent.builder()
                .applicationModule( ApplicationModule(this) )
                .build()
    }

    fun getComponent() : ApplicationComponent = component
}