package com.example.waiterless.repository

import com.example.waiterless.api.RetrofitInstance
import com.example.waiterless.models.CustomerModel
import com.example.waiterless.models.EmployeeModel
import com.example.waiterless.models.FoodModel
import com.example.waiterless.models.RestaurantModel

class Repository {

    suspend fun getMenu(r_id : Int) : Array<FoodModel>{
        return RetrofitInstance.api.getMenu(r_id)
    }

    suspend fun sendService(r_id : Int, table : Int) : String{
        return RetrofitInstance.api.sendService(r_id, table)
    }

    suspend fun sendOrder(r_id : Int, table : Int, f_id : Int) : String{
        return RetrofitInstance.api.sendOrder(r_id, table, f_id)
    }

    suspend fun checkUser(utype : String, email: String) : String{
        return RetrofitInstance.api.checkUser(utype, email)
    }

    suspend fun addUser(utype : String, name : String, birthday : String, email : String, password : String) : String{
        return RetrofitInstance.api.addUser(utype, name, birthday, email, password)
    }

    suspend fun editUser(utype: String, email: String, part : String, value : String) : String{
        return RetrofitInstance.api.editUser(utype, email, part, value)
    }

    suspend fun deleteUser(utype: String, email: String) : String{
        return RetrofitInstance.api.deleteUser(utype, email)
    }

    suspend fun checkCustomerPass(email: String, password: String) : CustomerModel{
        return RetrofitInstance.api.checkCustomerPass(email, password)
    }

    suspend fun checkEmployeePass(email: String, password: String) : EmployeeModel{
        return RetrofitInstance.api.checkEmployeePass(email, password)
    }

    suspend fun getCustomer(email: String) : CustomerModel{
        return RetrofitInstance.api.getCustomer(email)
    }

    suspend fun getEmployee(email: String) : EmployeeModel{
        return RetrofitInstance.api.getEmployee(email)
    }

    suspend fun getTables(r_id : Int) : String{
        return RetrofitInstance.api.getTables(r_id)
    }

    suspend fun getChannel(r_id : Int) : String{
        return RetrofitInstance.api.getChannel(r_id)
    }

    suspend fun getRestaurants() : Array<String>{
        return RetrofitInstance.api.getRestaurants()
    }

    //for the TBD menu


}