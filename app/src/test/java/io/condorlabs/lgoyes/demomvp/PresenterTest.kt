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

    /*@Test
    fun noInteractionWithView() {
        presenter.getCurrentUser()

        verifyZeroInteractions(mockLoginView)
    }*/

    // Behavior driven test naming convention
    @Test
    fun loadTheUserFromTheRepositoryWhenValidUserIsPresent(){
        `when`(mockLoginInteractor.getUser()).thenReturn(user)

        presenter.getCurrentUser()

        // Verify interactor interactions
        verify( mockLoginInteractor, times(1) ).getUser()

        // verify view interactions
        verify( mockLoginView, times(1)).setFirstName("Fox")
        verify( mockLoginView, times(1)).setLastName("Mulder")
        verify( mockLoginView, never() ).showUserNotAvailable()
    }

    @Test
    fun shouldShowErrorMessageWhenUserIsNull(){
        `when`(mockLoginInteractor.getUser()).thenReturn(null)

        presenter.getCurrentUser()

        // Verify interactor interactions
        verify( mockLoginInteractor, times(1) ).getUser()

        // verify view interactions
        verify( mockLoginView, never() ).setFirstName("Fox")
        verify( mockLoginView, never() ).setLastName("Mulder")
        verify( mockLoginView, times(1) ).showUserNotAvailable()
    }

    @Test
    fun shouldCreateErrorMessageIfFieldsAreEmpty(){
        `when`( mockLoginView.getFirstName() ).thenReturn("")

        presenter.saveUser()

        verify( mockLoginView, times(1) ).getFirstName()
        verify( mockLoginView, never() ).getLastName()
        verify( mockLoginView, times(1) ).showInputError()

        // Now thell mockView to return a value for first name and an empty last name
        `when`( mockLoginView.getFirstName() ).thenReturn("Dana")
        `when`( mockLoginView.getLastName() ).thenReturn("")

        presenter.saveUser()

        verify( mockLoginView, times(2) ).getFirstName()
        verify( mockLoginView, times(1) ).getLastName()
        verify( mockLoginView, times(2) ).showInputError()

    }

    @Test
    fun showBeAbleToSaveAValidUser(){
        `when`( mockLoginView.getFirstName() ).thenReturn("Dana")
        `when`( mockLoginView.getLastName() ).thenReturn("Scully")

        presenter.saveUser()

        verify( mockLoginView, times(2) ).getFirstName()
        verify( mockLoginView, times(2) ).getLastName()

        verify( mockLoginInteractor, times(1) ).createUser("Dana", "Scully");

        verify( mockLoginView, times(1) ).showUserSaveMessage()
    }


}