package com.example.waiterless.models

data class EmployeeModel(
    val employeeID : Int,
    val name : String,
    val birthday : String,
    val email : String,
    val password : String,
    val restaurant : String,
    val manager : Boolean
)
