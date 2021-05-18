package com.example.waiterless.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.waiterless.R

//
class RestaurantListActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        val papaMarioPizzaBTN = findViewById<Button>(R.id.papaMarioPizzaButton)
        papaMarioPizzaBTN.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)  // for now
            intent.putExtra("id", 0)
            startActivity(intent)
        }

        val buffetShackBTN = findViewById<Button>(R.id.buffetShackButton)
        buffetShackBTN.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)  // for now
            intent.putExtra("id", 0)
            startActivity(intent)
        }

    }
}