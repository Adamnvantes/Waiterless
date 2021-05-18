package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.waiterless.R
import com.example.waiterless.objects.UserInfo

//for Justin
class CustomerHomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)

        //Welcome header
        val welcomeBar = findViewById<TextView>(R.id.customerHomeWelcome)
        welcomeBar.text = "Welcome ${UserInfo.customer.name}!"

        //Populating edit value options
        val spinner = findViewById<Spinner>(R.id.customerSpinner)
        ArrayAdapter.createFromResource(this, R.array.Profile_changes, R.layout.support_simple_spinner_dropdown_item).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
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
}