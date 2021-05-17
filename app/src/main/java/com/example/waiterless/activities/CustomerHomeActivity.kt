package com.example.waiterless.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.waiterless.R

//for Justin
class CustomerHomeActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_home)
        //option to select restaurants
        //1. Find from a list (Papa Mario's Pizza, and other made-up restaurants)
        val restaurantListBTN = findViewById<Button>(R.id.restaurantListButton)
        restaurantListBTN.setOnClickListener {
            val intent = Intent( this, RestaurantListActivity::class.java)
            startActivity(intent)
        }

        //2. Scan a QR code
        val qrCodeBTN = findViewById<Button>(R.id.qrCodeButton)
        qrCodeBTN.setOnClickListener {
            val intent = Intent( this, QRcodeActivity::class.java)
            startActivity(intent)
        }

        //3. Scan NFC
        val nfcBTN = findViewById<Button>(R.id.nfcButton)
        nfcBTN.setOnClickListener {
            val intent = Intent( this, NFCActivity::class.java)
            startActivity(intent)
        }

        //4. Select a previously selected restaurant (from recent history)
        val recentHistoryBTN = findViewById<Button>(R.id.recentHistoryButton)
        recentHistoryBTN.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)  // for now
             startActivity(intent)
        }

    }
}