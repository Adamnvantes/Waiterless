package com.example.waiterless.models

data class APIInfoModel(
    val restaurants: Array<RestaurantModel>,
    val employees: Array<EmployeeModel>,
    val customers: Array<CustomerModel>
)
