package io.condorlabs.lgoyes.demomvp.login

class MemoryRepository : LoginRepository{

    private var user: User? = null

    override fun getUser(): User {
        if ( user == null ){
            val user = User("Fox", "Mulder")
            user.id = 0
            return user
        }else{
            return user!!
        }
    }

    override fun saveUser(user: User?) {
        user?.let {
            this.user = it
        }
    }

}