package com.example.waiterless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Queue
import java.util.LinkedList

class EmployeeHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_home)
        var table1: String? = "Table 1 needs attention"
        var table2: String? = "Table 2 needs attention"
        var table3: String? = "Table 3 needs attention"
        var table4: String? = "Table 4 needs attention"
        var table5: String? = "Table 5 needs attention"
        /*
        // clears all table requests
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
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table1Text)
            table1Msg.setText("Table 1: No attention needed")

        }

        //clears table 2 request
        val buttonClearTable2=findViewById<Button>(R.id.table2Button)
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table2Text)
            table1Msg.setText("Table 2: No attention needed")
        }

        //clears table 3 request
        val buttonClearTable3=findViewById<Button>(R.id.table3Button)
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table3Text)
            table1Msg.setText("Table 3: No attention needed")

        }

        //clears table 4 request
        val buttonClearTable4=findViewById<Button>(R.id.table4Button)
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table1Text)
            table1Msg.setText("Table 4: No attention needed")

        }

        //clears table 5 request
        val buttonClearTable5=findViewById<Button>(R.id.table5Button)
        buttonClearTableRequests.setOnClickListener{
            var table1Msg: TextView =findViewById(R.id.table5Text)
            table1Msg.setText("Table 5: No attention needed")

        }
        val orders: Queue<String> = LinkedList<String>()
        orders.add("Table 1: peperoni pizza")
        orders.add("Table 2: salad")
        orders.add("Table 3: pasta")
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
        }*/

    }
}
