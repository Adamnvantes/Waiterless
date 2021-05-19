package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.objects.Constants
import com.example.waiterless.objects.UserInfo
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory

//for Justin
class CustomerHomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener
{
    private var spinnerPos : Int = -1
    private lateinit var viewModel : APIViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)

        //Welcome header
        val welcomeBar = findViewById<TextView>(R.id.customerHomeWelcome)
        welcomeBar.text = "Welcome ${UserInfo.customer.name}!"

        //API Variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Populating edit value options
        val spinner = findViewById<Spinner>(R.id.customerSpinner)
        ArrayAdapter.createFromResource(this, R.array.Profile_changes, R.layout.support_simple_spinner_dropdown_item).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.prompt = "Value"
        spinner.onItemSelectedListener = this
        spinner.gravity = Gravity.CENTER

        val editInfo = findViewById<EditText>(R.id.customerChangeValue)
        editInfo.hint = "New Value Here"
        val btnSubmit = findViewById<Button>(R.id.btnCustomerValueSubmit)

        //Button sets new value
        btnSubmit.setOnClickListener {
            if(editInfo.text.equals("")){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            } else{
                var part = "name"
                val value = editInfo.text.toString()

                when(spinnerPos){
                    -1 -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    0 ->{
                        part = "name"
                        welcomeBar.text = "Welcome ${value}!"
                    }
                    1 ->{
                        part = "birthday"
                    }
                    2 -> {
                        part = "email"
                    }
                    3 -> {
                        part = "password"
                    }
                }

                viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
                viewModel.editUser(Constants.CUSTOMERTAG, UserInfo.customer.email, part, value)
                viewModel.stringResponse.observe(this, Observer { response ->
                })


            }
        }


        //Variable holding restaurant ID
        var rID = 0

        //option to select restaurants
        //1. Find from a list (Papa Mario's Pizza, and other made-up restaurants)
        val restaurantListBTN = findViewById<Button>(R.id.restaurantListButton)
        restaurantListBTN.setOnClickListener {
            val intent = Intent( this, RestaurantListActivity::class.java)
            intent.getIntExtra("rID", rID)
            startActivity(intent)
        }

        //2. Scan a QR code
        val qrCodeBTN = findViewById<Button>(R.id.qrCodeButton)
        qrCodeBTN.setOnClickListener {
            val intent = Intent( this, QRcodeActivity::class.java)
            intent.getIntExtra("rID", rID)
            startActivity(intent)
        }

        //3. Select a previously selected restaurant (from recent history)
        val recentHistoryBTN = findViewById<Button>(R.id.recentHistoryButton)
        recentHistoryBTN.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)  // for now
            intent.getIntExtra("rID", rID)
             startActivity(intent)
        }

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long){
        spinnerPos = pos
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}