package com.example.waiterless.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.models.FoodModel
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory
import com.squareup.picasso.Picasso

//food orders
class RestaurantActivity : AppCompatActivity() {
    private lateinit var viewModel : APIViewModel
    private var restaurantID : Int = -1
    private var tableID : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        //Grabbing restaurant ID
        restaurantID = intent.getIntExtra("rID", -1)
        tableID = intent.getIntExtra("table", 0)

        //API Variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Calling restaurant's menu
        viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
        viewModel.getMenu(restaurantID)
        viewModel.menuResponse.observe(this, Observer { response ->
            val menu = response

            runOnUiThread(Runnable {
                fun run(menu: Array<FoodModel>){
                    //TODO: Update menu here
                    //item 1
                    val menuItem1Pic = findViewById<ImageView>(R.id.menuItem1Pic)
                    Picasso.get().load(menu[0].link).into(menuItem1Pic)
                    val food1Txt = findViewById<TextView>(R.id.foodText1)
                    food1Txt.text = menu[0].name
                    val price1Txt = findViewById<TextView>(R.id.priceText1)
                    price1Txt.text = menu[0].price.toString()

                    //item 2
                    val menuItem2Pic = findViewById<ImageView>(R.id.menuItem2Pic)
                    Picasso.get().load(menu[0].link).into(menuItem2Pic)
                    val food2Txt = findViewById<TextView>(R.id.foodText2)
                    food2Txt.text = menu[0].name
                    val price2Txt = findViewById<TextView>(R.id.priceText2)
                    price2Txt.text = menu[0].price.toString()

                    //item 3
                    val menuItem3Pic = findViewById<ImageView>(R.id.menuItem3Pic)
                    Picasso.get().load(menu[0].link).into(menuItem3Pic)
                    val food3Txt = findViewById<TextView>(R.id.foodText3)
                    food3Txt.text = menu[0].name
                    val price3Txt = findViewById<TextView>(R.id.priceText3)
                    price3Txt.text = menu[0].price.toString()

                    //item 4
                    val menuItem4Pic = findViewById<ImageView>(R.id.menuItem4Pic)
                    Picasso.get().load(menu[0].link).into(menuItem4Pic)
                    val food4Txt = findViewById<TextView>(R.id.foodText4)
                    food4Txt.text = menu[0].name
                    val price4Txt = findViewById<TextView>(R.id.priceText4)
                    price4Txt.text = menu[0].price.toString()

                    //item 5
                    val menuItem5Pic = findViewById<ImageView>(R.id.menuItem5Pic)
                    Picasso.get().load(menu[0].link).into(menuItem5Pic)
                    val food5Txt = findViewById<TextView>(R.id.foodText5)
                    food5Txt.text = menu[0].name
                    val price5Txt = findViewById<TextView>(R.id.priceText5)
                    price5Txt.text = menu[0].price.toString()

                    //item 6
                    val menuItem6Pic = findViewById<ImageView>(R.id.menuItem6Pic)
                    Picasso.get().load(menu[0].link).into(menuItem6Pic)
                    val food6Txt = findViewById<TextView>(R.id.foodText6)
                    food6Txt.text = menu[0].name
                    val price6Txt = findViewById<TextView>(R.id.priceText6)
                    price6Txt.text = menu[0].price.toString()

                    //item 7
                    val menuItem7Pic = findViewById<ImageView>(R.id.menuItem7Pic)
                    Picasso.get().load(menu[0].link).into(menuItem7Pic)
                    val food7Txt = findViewById<TextView>(R.id.foodText7)
                    food7Txt.text = menu[0].name
                    val price7Txt = findViewById<TextView>(R.id.priceText7)
                    price7Txt.text = menu[0].price.toString()

                }

                run(menu)
            })
        })
    }

    fun sendOrder(food : Int){
        //API Variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Paging restaurant for food request
        viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
        viewModel.sendOrder(restaurantID, tableID, food)
        viewModel.stringResponse.observe(this, Observer { response ->
            if(response == "200"){
                Toast.makeText(this, "Order sent!", Toast.LENGTH_SHORT)
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
            }
        })
    }
}