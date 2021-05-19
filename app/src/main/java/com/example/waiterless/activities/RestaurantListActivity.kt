package com.example.waiterless.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.waiterless.R

//
class RestaurantListActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)


        val papaMarioPizzaClickTextView = findViewById<TextView>(R.id.papaMarioPizzaHyperlink)
        papaMarioPizzaClickTextView.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            intent.putExtra("id", 0)
            startActivity(intent)
        }

        val buffetShackClickTextView = findViewById<TextView>(R.id.buffetShackHyperlink)
        buffetShackClickTextView.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            intent.putExtra("id", 1)
            startActivity(intent)
        }

    }
}