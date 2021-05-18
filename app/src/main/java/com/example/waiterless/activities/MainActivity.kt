package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : APIViewModel

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

        //API variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Setting hints for user input
        userInputEmail.hint = "Please enter your email address"
        userInputPassword.hint = "Please enter your password"

        //Grabbing information
        btnLogin.setOnClickListener{
            Log.d("TAG", "Hi")
            val username = userInputEmail.text.toString()
            val password = userInputPassword.text.toString()

            viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
            viewModel.checkPass("customers",username, password)
            viewModel.stringResponse.observe(this, Observer { response ->
                if(response == "200"){
                    var intent = Intent(this, CustomerHomeActivity::class.java)
                    intent.putExtra("email", username)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Please Try Again!", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnRegister.setOnClickListener{
            val username = userInputEmail.text.toString()
            val password = userInputPassword.text.toString()
            var makeaccount = false

            viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
            viewModel.checkUser(username, password)
            viewModel.stringResponse.observe(this, Observer { response ->
                if(response == "200"){
                    Toast.makeText(this, "Username already used", Toast.LENGTH_SHORT).show()
                }
                else{
                    makeaccount = true
                }
            })

            if(makeaccount){
                viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
                viewModel.addUser("customers", "", "", username, password)
                viewModel.stringResponse.observe(this, Observer { response ->
                    if(response == "200"){
                        Toast.makeText(this, "Success! Log in", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        btnGuest.setOnClickListener {
            //val intent = Intent
        }

    }
}