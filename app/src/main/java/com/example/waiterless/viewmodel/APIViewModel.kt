package com.example.waiterless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waiterless.models.FoodModel
import com.example.waiterless.models.RestaurantModel
import com.example.waiterless.repository.Repository
import kotlinx.coroutines.launch

class APIViewModel(private val repository: Repository): ViewModel() {
    val restaurantModelResponse : MutableLiveData<Array<FoodModel>> = MutableLiveData()
    val stringResponse : MutableLiveData<String> = MutableLiveData()

    fun getMenu(r_id : Int){
        viewModelScope.launch {
            val response : RestaurantModel = repository.getMenu(r_id)
            restaurantModelResponse.value = response
        }
    }

    fun sendService(r_id: Int, table : Int){
        viewModelScope.launch {
            val response : String = repository.sendService(r_id, table)
            stringResponse.value = response
        }
    }

    fun sendOrder(r_id : Int, table: Int, f_id : Int){
        viewModelScope.launch {
            val response : String = repository.sendService(r_id, table)
            stringResponse.value = response
        }
    }
}