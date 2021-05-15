package com.example.waiterless.objects

private var employeeID = -1

class Employee(name : String, birthday : String, email : String, restaurant: Restaurant, manager: Boolean =false, password : String)
    : Person(name, birthday, email, password) {
    private val restaurant = restaurant
    private val manager = manager
    private val employeeId = ++employeeID

    override fun getID() : Int{
        return employeeId
    }
}