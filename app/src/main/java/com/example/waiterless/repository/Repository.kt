package com.example.waiterless.repository

import com.example.waiterless.api.RetrofitInstance
import com.example.waiterless.models.Menus
import com.example.waiterless.models.RestaurantModel

class Repository {

    suspend fun getMenu(r_id : Int) : RestaurantModel{
        return RetrofitInstance.api.getMenu(r_id)
    }

    suspend fun sendService(r_id : Int, table : Int) : String{
        return RetrofitInstance.api.sendService(r_id, table)
    }

    suspend fun sendOrder(r_id : Int, table : Int, f_id : Int) : String{
        return RetrofitInstance.api.sendOrder(r_id, table, f_id)
    }

    //for the TBD menu


}