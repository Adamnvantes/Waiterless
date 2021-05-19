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
                    if(rID == 0)
                    {
                        val food1Txt = findViewById<TextView>(R.id.whatever)
                        food1Txt.text = menu[0].name
                    }

                    //Armando's example code:
                    /*
                     val jsonObject=JSONObject(event.data)
                    val table=jsonObject.get("table")
                    if (table==1)
                    {
                        var table1Msg: TextView =findViewById(R.id.table1Text)
                        table1Msg.setText("Table 1:attention needed")
                    }
                    else if(table==2)
                    {
                        var table1Msg: TextView =findViewById(R.id.table1Text)
                        table1Msg.setText("Table 2:attention needed")
                    }
                     */

                }
            })
        })

//pull id num
        //ex: id num = 0, now spit out entire menu for a particular restaurant
    }
}