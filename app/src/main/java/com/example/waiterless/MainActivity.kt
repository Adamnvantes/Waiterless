package com.example.waiterless

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable declarations
        val userInputEmail = findViewById<EditText>(R.id.mainInputEmail)
        val userInputPassword = findViewById<EditText>(R.id.mainInputPassword)
        val btnLogin = findViewById<Button>(R.id.mainBtnLogin)
        val btnRegister = findViewById<Button>(R.id.mainBtnRegister)
        val btnGuest = findViewById<Button>(R.id.mainBtnGuest)
        val btnEmployee = findViewById<Button>(R.id.mainBtnEmployee)

        //Setting hints for user input
        userInputEmail.hint = "Please enter your email address"
        userInputPassword.hint = "Please enter your password"

        //Grabbing information
        btnLogin.setOnClickListener{
            val username = userInputEmail.text
            val password = userInputPassword.text
            //TODO: Check username / password
            if(true) {
                var intent = Intent(this, CustomerHomeActivity::class.java)
                intent.putExtra("email", username).putExtra("password", password)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener{
            val username = userInputEmail.text
            val password = userInputPassword.text
            //TODO: Check for conflicting usernames

            if(true){
                //TODO: Add username / password to database
                val intent = Intent(this, CustomerHomeActivity::class.java)
                intent.putExtra("email", username).putExtra("password", password)
                startActivity(intent)
            }
        }

        btnGuest.setOnClickListener {
            //val intent = Intent
        }

    }
}