package com.example.chatapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.chatapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

    Handler(Looper.getMainLooper()).postDelayed({
        Intent(this, AuthentificationActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }, 3000)


    }
}