package io.condorlabs.lgoyes.demomvp.login

class LoginPresenter : LoginContract.Presenter {

    private var view : LoginContract.View? = null
    private lateinit var interactor : LoginContract.Interactor

    constructor(interactor: LoginContract.Interactor ){
        this.interactor = interactor
    }

    override fun setView(view: LoginContract.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        saveUser()
    }

    override fun getCurrentUser() {
        val user = interactor.getUser()

        view?.run {
            if ( user == null ){
                showUserNotAvailable()
            }else{
                setFirstName( user.firstName )
                setLastName( user.lastName )
            }
        }
    }

    fun   saveUser(){
        view?.run {
            if( (getFirstName().trim() == "") || (getLastName().trim() == "") ){
                showInputError()
            }else{
                interactor.createUser( getFirstName(), getLastName() )
                showUserSaveMessage()
            }
        }
    }

}