package io.condorlabs.lgoyes.demomvp.root

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: Application){
    @Provides
    @Singleton
    fun provideContext() = application
}