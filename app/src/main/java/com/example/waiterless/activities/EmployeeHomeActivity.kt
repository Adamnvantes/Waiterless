package com.example.waiterless.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.R
import com.example.waiterless.api.Keys
import com.example.waiterless.objects.Constants
import com.example.waiterless.objects.UserInfo
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
import java.util.*

class EmployeeHomeActivity : AppCompatActivity() {
    //private lateinit var viewModel : APIViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_home)

        val repository=Repository()
        val viewModelFactory=APIViewModelFactory(repository)

        //viewModel = ViewModelProvider(this, viewModelFactory).get(APIViewModel::class.java)

        //Pusher Variables
        val options = PusherOptions()
        options.setCluster(Keys.CLUSTER)
        val pusher = Pusher(Keys.KEY, options)

        pusher.connect(object : ConnectionEventListener {
            override fun onConnectionStateChange(change: ConnectionStateChange) {
                Log.i("Pusher", "State changed from ${change.previousState} to ${change.currentState}")
            }

            override fun onError(
                message: String,
                code: String,
                e: Exception
            ) {
                Log.i("Pusher", "There was a problem connecting! code ($code), message ($message), exception($e)")
            }
        }, ConnectionState.ALL)

        val channel = pusher.subscribe(UserInfo.employee.channel)


        // This is the function for the button that clears all table requests
        val buttonClearTableRequests=findViewById<Button>(R.id.tableButton)
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table1Text)
            table1Msg.setText("Table 1: No attention needed")

            var table2Msg: TextView =findViewById(R.id.table2Text)
            table1Msg.setText("Table 2: No attention needed")

            var table3Msg: TextView =findViewById(R.id.table3Text)
            table1Msg.setText("Table 3: No attention needed")

            var table4Msg: TextView =findViewById(R.id.table4Text)
            table4Msg.setText("Table 4: No attention needed")

            var table5Msg: TextView =findViewById(R.id.table5Text)
            table5Msg.setText("Table 5: No attention needed")
        }

        //clears table 1 request
        val buttonClearTable1=findViewById<Button>(R.id.table1Button)
        buttonClearTable1.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table1Text)
            table1Msg.setText("Table 1: No attention needed")

        }

        //clears table 2 request
        val buttonClearTable2=findViewById<Button>(R.id.table2Button)
        buttonClearTable2.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table2Text)
            table1Msg.setText("Table 2: No attention needed")
        }

        //clears table 3 request
        val buttonClearTable3=findViewById<Button>(R.id.table3Button)
        buttonClearTable3.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table3Text)
            table1Msg.setText("Table 3: No attention needed")

        }

        //clears table 4 request
        val buttonClearTable4=findViewById<Button>(R.id.table4Button)
        buttonClearTable4.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table1Text)
            table1Msg.setText("Table 4: No attention needed")

        }

        //clears table 5 request
        val buttonClearTable5=findViewById<Button>(R.id.table5Button)
        buttonClearTable5.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table5Text)
            table1Msg.setText("Table 5: No attention needed")

        }

        //Queue is initialized
        val orders: Queue<String> = LinkedList<String>()

        //show order in queue if any, otherwise let the user know there's no orders pending
        if (orders.size==0)
        {
            var orderMsg: TextView = findViewById(R.id.orderText)
            orderMsg.setText("No Orders Pending")
        }
        else
        {
            var orderMsg: TextView = findViewById(R.id.orderText)
            orderMsg.setText(orders.peek())
        }
        //show order in queue if any, otherwise let the user know there's no orders pending when button is pressed
        val buttonClearOrder=findViewById<Button>(R.id.kitchenButton)
        buttonClearOrder.setOnClickListener{
            if (orders.size==0)
            {
                var orderMsg: TextView = findViewById(R.id.orderText)
                orderMsg.setText("No Orders Pending")
            }
            else
            {
                orders.remove()
                if (orders.size==0)
                {
                    var orderMsg: TextView = findViewById(R.id.orderText)
                    orderMsg.setText("No Orders Pending")
                }
                else {
                    var orderMsg: TextView = findViewById(R.id.orderText)
                    orderMsg.setText(orders.peek())
                }
            }
        }

        channel.bind(Constants.ORDEREVENT){ event ->
            Log.i("Tag", event.data)


            //this thread calls the api and obtains the data required to put the orders on the queue
            runOnUiThread(Runnable() {
                fun run(x : String){
                    //val test = findViewById<TextView>(R.id.table1Text)
                    //test.text = x
                    val jsonObject=JSONObject(event.data)
                    val table=jsonObject.get("table")
                    val order=jsonObject.getJSONObject("order")
                    val item=order.get("name")
                    val price=(order.getDouble("price")).toFloat()
                    orders.add("Table $table ordered $item, price=$price")
                    //show order in queue if any
                    if (orders.size==0)
                    {
                        var orderMsg: TextView = findViewById(R.id.orderText)
                        orderMsg.setText("No Orders Pending")
                    }
                    else
                    {
                        var orderMsg: TextView = findViewById(R.id.orderText)
                        orderMsg.setText(orders.peek())
                    }
                    if (table==1)
                    {
                        var table1Msg: TextView =findViewById(R.id.table1Text)
                        table1Msg.setText("Table 1: Attention needed")


                    }
                    else if(table==2)
                    {
                        var table1Msg: TextView =findViewById(R.id.table1Text)
                        table1Msg.setText("Table 2: Attention needed")
                    }
                    else if(table==2)
                    {
                        var table2Msg: TextView =findViewById(R.id.table2Text)
                        table2Msg.setText("Table 2: Attention needed")
                    }
                    else if(table==3)
                    {
                        var table3Msg: TextView =findViewById(R.id.table3Text)
                        table3Msg.setText("Table 3: Attention needed")
                    }
                    else if(table==4)
                    {
                        var table4Msg: TextView =findViewById(R.id.table4Text)
                        table4Msg.setText("Table 4: Attention needed")
                    }
                    else if(table==5)
                    {
                        var table5Msg: TextView =findViewById(R.id.table5Text)
                        table5Msg.setText("Table 5: Attention needed")
                    }
                }

                run(event.data)
            })

        }

    }

}
