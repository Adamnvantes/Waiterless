package com.example.waiterless.models

data class CustomerModel(
    val customerID : Int,
    val name : String,
    val birthday : String,
    val email : String,
    val password : String,
    val visited : Array<String>
)
