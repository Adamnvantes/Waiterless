package com.example.waiterless.api

import com.example.waiterless.models.Menus
import com.example.waiterless.models.RestaurantModel
import retrofit2.http.GET

interface WaiterlessAPI {
    @GET("v1/all")
    suspend fun getAllMenus() : Menus

    @GET("v1/mario")
    suspend fun getMarioMenu() : RestaurantModel

    @GET("v1/buffet")
    suspend fun getBuffetMenu() : RestaurantModel
}