package io.condorlabs.lgoyes.demomvp.login

class LoginInteractor(
        var repository : LoginRepository
)
    : LoginContract.Interactor {

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser( User(firstName, lastName) )
    }

    override fun getUser(): User? {
        return repository.getUser()
    }
}