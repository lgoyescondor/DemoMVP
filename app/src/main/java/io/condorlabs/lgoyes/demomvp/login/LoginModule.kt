package io.condorlabs.lgoyes.demomvp.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter( interactor: LoginContract.Interactor ) : LoginContract.Presenter = LoginPresenter( interactor )

    @Provides
    fun provideLoginInteractor( repository: LoginRepository ) : LoginContract.Interactor = LoginInteractor(repository)

    @Provides
    fun provideLoginRepository() : LoginRepository = MemoryRepository()
}