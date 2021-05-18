package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.models.CustomerModel
import com.example.waiterless.models.EmployeeModel
import com.example.waiterless.objects.Constants
import com.example.waiterless.objects.UserInfo
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: APIViewModel

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
        userInputEmail.hint = Constants.ENTEREMAIL
        userInputPassword.hint = Constants.ENTERPASS

        //Grabbing information
        btnLogin.setOnClickListener {
            val username = userInputEmail.text.toString()
            val password = userInputPassword.text.toString()

            viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
            viewModel.checkCustomerPass(username, password)
            viewModel.customerResponse.observe(this, Observer { response ->
                var c : CustomerModel = response

                if(c.customerID == -1){
                    //Default customer. Customer does not exist
                    Toast.makeText(this, Constants.TRYAGAIN, Toast.LENGTH_SHORT).show()
                }else{
                    UserInfo.customer = c
                    val intent = Intent(this, CustomerHomeActivity::class.java)
                    intent.putExtra(Constants.INTENTEXTRATAG, username)
                    startActivity(intent)
                }
            })
        }

        btnRegister.setOnClickListener {
            val username = userInputEmail.text.toString()
            val password = userInputPassword.text.toString()

            viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
            viewModel.addUser(Constants.CUSTOMERTAG, Constants.DEFAULTNAME, Constants.DEFAULTBIRTHDAY, username, password)
            viewModel.stringResponse.observe(this, Observer { response ->
                when (response) {
                    Constants.OKCODE -> {
                        Toast.makeText(this, Constants.REGISTERSUCCESS, Toast.LENGTH_SHORT).show()
                    }
                    Constants.CONFLICTCODE -> {
                        Toast.makeText(this, Constants.REGISTERCONFLICT, Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this, Constants.ERROR, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        btnGuest.setOnClickListener {
            val intent = Intent(this, CustomerHomeActivity::class.java)
            intent.putExtra(Constants.INTENTEXTRATAG, Constants.GUEST)
            startActivity(intent)
        }

        btnEmployee.setOnClickListener {
            val username = userInputEmail.text.toString()
            val password = userInputPassword.text.toString()

            viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
            viewModel.checkEmployeePass(username, password)
            viewModel.employeeResponse.observe(this, Observer { response ->
                var e : EmployeeModel = response

                if(e.employeeID == -1){
                    //Default employee. Employee does not exist
                    Toast.makeText(this, Constants.TRYAGAIN, Toast.LENGTH_SHORT).show()
                } else{
                    UserInfo.employee = e
                    val intent = Intent(this, EmployeeHomeActivity::class.java)
                    intent.putExtra(Constants.INTENTEXTRATAG, username)
                    startActivity(intent)
                }
            })

        }
    }
}