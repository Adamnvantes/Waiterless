package com.example.waiterless.objects

class Customer(name : String, birthday : String, email : String, password : String) : Person(name, birthday, email, password) {
    private var visited = emptyArray<Restaurant>()
    private var favorite = emptyArray<Restaurant>()
}