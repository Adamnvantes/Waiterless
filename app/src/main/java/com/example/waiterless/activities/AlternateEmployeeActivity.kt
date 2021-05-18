package com.example.waiterless.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.api.Keys
import com.example.waiterless.models.EmployeeModel
import com.example.waiterless.models.FoodModel
import com.example.waiterless.models.OrderModel
import com.example.waiterless.objects.Constants
import com.example.waiterless.repository.Repository
import com.example.waiterless.viewmodel.APIViewModel
import com.example.waiterless.viewmodel.APIViewModelFactory
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import com.pusher.client.channel.PusherEvent
import com.pusher.client.connection.ConnectionEventListener
import com.pusher.client.connection.ConnectionState
import com.pusher.client.connection.ConnectionStateChange
import org.json.JSONObject
import java.lang.Exception

class AlternateEmployeeActivity : AppCompatActivity() {
    private lateinit var viewModel: APIViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alternate_employee)

        //API variables
        val repository = Repository()
        val viewModelFactory = APIViewModelFactory(repository)

        //Pusher variables
        val options = PusherOptions()
        options.setCluster(Keys.CLUSTER)
        val pusher = Pusher(Keys.KEY, options)

        pusher.connect(object : ConnectionEventListener{
            override fun onConnectionStateChange(change : ConnectionStateChange){
                Log.i("Pusher", "State changed from ${change.previousState} to ${change.currentState}")
            }

            override fun onError(message: String?, code: String?, e: Exception?) {
                Log.i("Pusher", "$code, $message, $e")
            }


        }, ConnectionState.ALL)

        //Previous Info
        val username : String = intent.getStringExtra(Constants.INTENTEXTRATAG).toString()

        //Grabbing employee info
        var e : EmployeeModel

        val lv = findViewById<ListView>(R.id.emplListView)
        val temp: MutableList<String> = ArrayList()

        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.employee_list, temp)


        viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)
        viewModel.getEmployee(username)
        viewModel.employeeResponse.observe(this, Observer { response ->
            e = response
            for(i in e.tablesstart..e.tablesend){
                temp.add("Table $i status: Ok")
            }
        })

        val channel = pusher.subscribe(e.channel)
        channel.bind(Constants.ORDEREVENT){ event ->
            Log.d("Order", event.data)

            //Editing the List
            val jsonObjectOrder = JSONObject(event.data)
            val jsonObjectFood = jsonObjectOrder.getJSONObject("order")
            val order : OrderModel = OrderModel(jsonObjectOrder.getInt("table"), FoodModel(jsonObjectFood.getInt("f_id"), jsonObjectFood.getString("name"), jsonObjectFood.getDouble("price").toFloat(), jsonObjectFood.getString("link")))
            temp[order.table] = "Table ${order.table} has just ordered: ${order.food.name}"
            adapter = ArrayAdapter<String>(this, R.layout.employee_list, temp)
            lv.adapter = adapter
        }
    }

    fun getData(){

    }

}