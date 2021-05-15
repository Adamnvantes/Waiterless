package com.example.waiterless.objects

private var customerID = -1

class Customer(name : String, birthday : String, email : String, password : String) : Person(name, birthday, email, password) {
    private var visited = emptyArray<Restaurant>()
    private var favorite = emptyArray<Restaurant>()
    private var customerId = ++customerID

    override fun getID() : Int {
        return customerId
    }
}