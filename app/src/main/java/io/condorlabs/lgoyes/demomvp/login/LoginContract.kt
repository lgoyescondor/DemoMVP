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

    }

    interface Interactor {

    }
}