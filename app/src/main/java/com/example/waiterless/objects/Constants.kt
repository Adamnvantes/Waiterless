package com.example.waiterless.objects

import com.example.waiterless.models.CustomerModel

object Constants {
    var APIIP = "http://10.0.2.2:5000/api/"
    var INTENTEXTRATAG = "email"
    var GUEST = "guest@example.com"
    var CUSTOMERTAG = "customers"
    var EMPLOYEETAG = "employees"
    var OKCODE = "200"
    var CONFLICTCODE = "400"
    var SERVICEEVENT = "service"
    var ORDEREVENT = "order"
    var DEFAULTNAME = "User"
    var DEFAULTBIRTHDAY = "05-17-2021"
    var REGISTERSUCCESS = "Success! Log In"
    var REGISTERCONFLICT = "Username Already Exists"
    var ERROR = "Error"
    var TRYAGAIN = "Please Try Again"
    var ENTEREMAIL = "Please enter your email"
    var ENTERPASS = "Please enter your password"
    var DEFAULTCUSTOMER = CustomerModel(-10, "Guest", "03-03-1762", "guest@example.com", "password", emptyArray())
}