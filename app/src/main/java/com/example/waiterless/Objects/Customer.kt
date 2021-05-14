package com.example.waiterless.Objects

class Customer(name : String, birthday : String, email : String) : Person(name, birthday, email) {
    private var visited = emptyArray<Restaurant>()
    private var favorite = emptyArray<Restaurant>()
}