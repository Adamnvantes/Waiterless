package com.example.waiterless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waiterless.models.Menus
import com.example.waiterless.models.RestaurantModel
import com.example.waiterless.repository.Repository
import kotlinx.coroutines.launch

class APIViewModel(private val repository: Repository): ViewModel() {
    val allResponse : MutableLiveData<Menus> = MutableLiveData()
    val marioResponse : MutableLiveData<RestaurantModel> = MutableLiveData()

    fun getMenu(){
        viewModelScope.launch {
            val response : Menus = repository.getAllMenus()
            allResponse.value = response
        }
    }

    fun getMarioMenu(){
        viewModelScope.launch {
            val response : RestaurantModel = repository.getMarioMenu()
            marioResponse.value = response
        }
    }
}