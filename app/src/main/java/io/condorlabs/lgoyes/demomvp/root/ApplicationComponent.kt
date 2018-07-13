package io.condorlabs.lgoyes.demomvp.root

import dagger.Component
import io.condorlabs.lgoyes.demomvp.login.LoginActivity
import io.condorlabs.lgoyes.demomvp.login.LoginModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class])
interface ApplicationComponent {
    fun inject( target : LoginActivity )
}