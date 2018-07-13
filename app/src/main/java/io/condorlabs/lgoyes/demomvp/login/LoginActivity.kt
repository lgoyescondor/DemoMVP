package io.condorlabs.lgoyes.demomvp.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.condorlabs.lgoyes.demomvp.R
import io.condorlabs.lgoyes.demomvp.root.DemoApp
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter : LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as DemoApp).getComponent().inject(this)

        btnLogin.setOnClickListener {
            presenter.loginButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView( this )
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String = etLoginFirstname?.text.toString()

    override fun getLastName(): String = etLoginLastname?.text.toString()

    override fun setFirstName(firstName: String) {
        etLoginFirstname?.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        etLoginLastname?.setText(lastName)
    }

    override fun showUserNotAvailable() {
        Toast.makeText( this,
                "Error the user is not available",
                Toast.LENGTH_LONG)
                .show()
    }

    override fun showInputError() {
        Toast.makeText( this,
                "First Name of Last Name cannot be empty",
                Toast.LENGTH_LONG)
                .show()
    }

    override fun showUserSaveMessage() {
        Toast.makeText( this,
                "User saved!",
                Toast.LENGTH_LONG)
                .show()
    }
}
