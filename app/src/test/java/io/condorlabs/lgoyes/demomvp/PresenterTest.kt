package io.condorlabs.lgoyes.demomvp

import io.condorlabs.lgoyes.demomvp.login.LoginContract
import io.condorlabs.lgoyes.demomvp.login.LoginPresenter
import io.condorlabs.lgoyes.demomvp.login.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class PresenterTest {

    lateinit var mockLoginInteractor: LoginContract.Interactor
    lateinit var mockLoginView: LoginContract.View

    lateinit var presenter: LoginPresenter

    lateinit var user: User

    @Before
    fun setup() {
        // Initialization process
        mockLoginInteractor = mock(LoginContract.Interactor::class.java)

        user = User("Fox", "Mulder")
        user.id = 0

        //`when`(mockLoginInteractor.getUser()).thenReturn(user)

        mockLoginView = mock(LoginContract.View::class.java)

        presenter = LoginPresenter(mockLoginInteractor)
        presenter.setView(mockLoginView)

    }

    @Test
    fun noInteractionWithView() {
        presenter.getCurrentUser()

        verifyZeroInteractions(mockLoginView)

    }
}