package io.condorlabs.lgoyes.demomvp.login

interface LoginRepository {
    fun getUser() : User
    fun saveUser( firstName : String,
                  secondName : String )
}