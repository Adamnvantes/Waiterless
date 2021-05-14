package com.example.waiterless.Objects

class Employee(name : String, birthday : String, email : String, restaurant: Restaurant, manager: Boolean =false)
    : Person(name, birthday, email) {
    private val restaurant = restaurant
    private val manager = manager
}