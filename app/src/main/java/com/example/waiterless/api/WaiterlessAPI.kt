package com.example.waiterless.api

import com.example.waiterless.models.Menus
import com.example.waiterless.models.RestaurantModel
import retrofit2.http.GET
import retrofit2.http.Path

interface WaiterlessAPI {

    @GET("v1/{r_id}/menu")
    suspend fun getMenu(@Path("r_id") r_id : Int) : RestaurantModel

    @GET("v1/{r_id}/service/{table}")
    suspend fun sendService(@Path("r_id") r_id : Int, @Path("table") table : Int) : String

    @GET("v1/{r_id}/order/{table}/{f_id}")
    suspend fun sendOrder(@Path("r_id") r_id : Int, @Path("table") table : Int, @Path("f_id") f_id : Int) : String
}