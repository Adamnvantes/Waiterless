package com.example.waiterless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable declarations
        var userInputEmail = findViewById<TextView>(R.id.mainInputEmail)
        var userInputPassword = findViewById<TextView>(R.id.mainInputPassword)

        //Setting hints for user input
        userInputEmail.hint = "Please enter your email address"
        userInputPassword.hint = "Please enter your password"
    }
}