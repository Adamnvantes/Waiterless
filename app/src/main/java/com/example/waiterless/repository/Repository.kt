package com.example.waiterless.repository

import com.example.waiterless.api.RetrofitInstance
import com.example.waiterless.models.Menus
import com.example.waiterless.models.RestaurantModel

class Repository {
    suspend fun getAllMenus() : Menus{
        return RetrofitInstance.api.getAllMenus()
    }

    suspend fun getMarioMenu() : RestaurantModel{
        return RetrofitInstance.api.getMarioMenu()
    }
}