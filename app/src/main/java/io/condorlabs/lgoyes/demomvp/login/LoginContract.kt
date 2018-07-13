package io.condorlabs.lgoyes.demomvp.login

interface LoginContract {
    interface View {
        fun getFirstName() : String
        fun getLastName() : String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSaveMessage()

        fun setFirstName( firstName : String )
        fun setLastName( lastName : String )
    }

    interface Presenter {
        fun setView( view : LoginContract.View )
        /* When we have buttons inside our view we instruct
           the presenter to handle the clic events for out buttons
        */

        fun loginButtonClicked()

        fun getCurrentUser()
    }

    interface Interactor {
        fun createUser( firstName: String, lastName: String )

        fun getUser() : User?
    }
}