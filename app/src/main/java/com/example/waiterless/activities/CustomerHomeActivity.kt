package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.objects.APPInfo
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
        val spinnerEdit = findViewById<Spinner>(R.id.customerSpinner)
        ArrayAdapter.createFromResource(this, R.array.Profile_changes, R.layout.support_simple_spinner_dropdown_item).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinnerEdit.adapter = adapter
        }

        //Populating Recent Restaurant spinner
        val spinnerRestaurantRecent = findViewById<Spinner>(R.id.customerRestaurantSpinnerRecent)
        if(UserInfo.customer.visited.isEmpty()){
            spinnerRestaurantRecent.visibility = View.INVISIBLE
        } else{
            spinnerRestaurantRecent.visibility = View.VISIBLE
            val mut = mutableListOf<String>()

            for (r in UserInfo.customer.visited){
                mut.add(r)
            }

            val arr = arrayOf(mut)
            val aa = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr)
            spinnerRestaurantRecent.adapter = aa
        }

        //Populating All Restaurants Spinner
        val spinnerRestaurantAll = findViewById<Spinner>(R.id.customerRestaurantSpinnerAll)
        if(APPInfo.restaurants.isEmpty()){
            spinnerRestaurantAll.visibility = View.INVISIBLE
        }
        else{
            spinnerRestaurantAll.visibility = View.VISIBLE
            val aa = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, APPInfo.restaurants)
            spinnerRestaurantAll.adapter = aa
        }

        val editNumber = findViewById<EditText>(R.id.editTableNumber)

        //Button for all restaurants choice
        val btnAll = findViewById<Button>(R.id.btnRestaurantAll)
        btnAll.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            val table : Int
            if(editNumber.text.isEmpty()){

            }
            intent.putExtra("rID",spinnerPos)
            intent.putExtra("table", Integer.parseInt(editNumber.text.toString()))
            startActivity(intent)
        }

        //Button for all restaurants choice
        val btnRecent = findViewById<Button>(R.id.btnRestaurantRecent)
        btnAll.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            intent.putExtra("rID",spinnerPos)
            intent.putExtra("table", Integer.parseInt(editNumber.text.toString()))
            startActivity(intent)
        }

        spinnerEdit.prompt = "Value"
        spinnerEdit.onItemSelectedListener = this
        spinnerEdit.gravity = Gravity.CENTER

        val editInfo = findViewById<EditText>(R.id.customerChangeValue)
        editInfo.hint = "New Value Here"
        val btnSubmit = findViewById<Button>(R.id.btnCustomerValueSubmit)

        //Button sets new value
        btnSubmit.setOnClickListener {
            if(editInfo.text.isEmpty()){
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

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long){
        spinnerPos = pos
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}