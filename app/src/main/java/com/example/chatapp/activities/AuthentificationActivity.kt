package com.example.chatapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.TextView
import com.example.chatapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class AuthentificationActivity : AppCompatActivity() {

    lateinit var tvRegister: TextView
    lateinit var textInputLayoutEmail : TextInputLayout
    lateinit var textInputLayoutPassword :TextInputLayout
    lateinit var btnConnect :MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

        tvRegister= findViewById(R.id.tvRegister)
        textInputLayoutEmail = findViewById(R.id.layoutTextInputEmail)
        textInputLayoutPassword = findViewById(R.id.layoutTextInputPassword)
        btnConnect = findViewById(R.id.btnConnect)

        tvRegister.setOnClickListener{
            Intent(this, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        btnConnect.setOnClickListener{

            textInputLayoutEmail.isErrorEnabled = false
            textInputLayoutPassword.isErrorEnabled = false

            val email = textInputLayoutEmail.editText?.text.toString()
            val password = textInputLayoutPassword.editText?.text.toString()

            if(password.isEmpty() || email.isEmpty()){
                if(password.isEmpty()){
                    textInputLayoutPassword.error = "password is required"
                    textInputLayoutPassword.isErrorEnabled = true
                }
                if(password.isEmpty()){
                    textInputLayoutEmail.error = "email is required"
                    textInputLayoutEmail.isErrorEnabled = true

                }
            } else{
                signIn(email, password)
            }
        }
    }
    private fun signIn(email: String, password: String){
        Log.d("signIn", "signIn user....")
        if(email =="duclair@gmail.com" && password =="duclair237") {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
            finish()
        } else{
            textInputLayoutPassword.error = "authentification failed!"
            textInputLayoutEmail.isErrorEnabled = true
            textInputLayoutPassword.isErrorEnabled = true
        }
    }
}