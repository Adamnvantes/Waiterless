package com.example.waiterless.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.models.FoodModel
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory

//food orders
class RestaurantActivity : AppCompatActivity() {
    private lateinit var viewModel : APIViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        //Grabbing restaurant ID
        val rID = intent.getIntExtra("rID", -1)

        //API Variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Calling restaurant's menu
        viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
        viewModel.getMenu(rID)
        viewModel.menuResponse.observe(this, Observer { response ->
            val menu = response

            runOnUiThread(Runnable {
                fun run(menu: Array<FoodModel>){
                    //TODO: Update menu here
                }
            })
        })

//pull id num
        //ex: id num = 0, now spit out entire menu for a particular restaurant
    }
}