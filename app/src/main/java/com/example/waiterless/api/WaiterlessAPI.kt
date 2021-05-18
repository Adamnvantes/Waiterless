package com.example.waiterless.api

import com.example.waiterless.models.CustomerModel
import com.example.waiterless.models.EmployeeModel
import com.example.waiterless.models.FoodModel
import com.example.waiterless.models.RestaurantModel
import retrofit2.http.GET
import retrofit2.http.Path

interface WaiterlessAPI {

    @GET("v1/menu/{r_id}")
    suspend fun getMenu(@Path("r_id") r_id : Int) : Array<FoodModel>

    @GET("v1/service/{r_id}/{table}")
    suspend fun sendService(@Path("r_id") r_id : Int, @Path("table") table : Int) : String

    @GET("v1/order/{r_id}/{table}/{f_id}")
    suspend fun sendOrder(@Path("r_id") r_id : Int, @Path("table") table : Int, @Path("f_id") f_id : Int) : String

    @GET("v1/check/{utype}/{email}")
    suspend fun checkUser(@Path("utype") utype : String, @Path("email") email : String) : String

    @GET("v1/add/{utype}/{name}/{birthday}/{email}/{password}")
    suspend fun addUser(@Path("utype") utype: String, @Path("name") name : String, @Path("birthday") birthday : String, @Path("email") email : String, @Path("password") password : String) : String

    @GET("v1/edit/{utype}/{email}/{part}/{value}")
    suspend fun editUser(@Path("utype") utype : String, @Path("email") email : String, @Path("part") part : String, @Path("value") value : String) : String

    @GET("v1/delete/{utype}/{email}")
    suspend fun deleteUser(@Path("utype") utype : String, @Path("email") email : String) : String

    @GET("v1/checkpass/{utype}/{email}/{password}")
    suspend fun checkPass(@Path("utype") utype : String, @Path("email") email : String, @Path("password") password : String) : String

    @GET("v1/getuser/customers/{email}")
    suspend fun getCustomer(@Path("email") email : String) : CustomerModel

    @GET("v1/getuser/employees/{email}")
    suspend fun getEmployee(@Path("email") email : String) : EmployeeModel

    @GET("v1/tables/{r_id}")
    suspend fun getTables(@Path("r_id") r_id : Int) : String

    @GET("v1/channel/{r_id}")
    suspend fun getChannel(@Path("r_id") r_id: Int) : String
}