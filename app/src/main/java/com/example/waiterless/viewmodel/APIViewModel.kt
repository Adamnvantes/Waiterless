package com.example.waiterless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waiterless.models.FoodModel
import com.example.waiterless.repository.Repository
import kotlinx.coroutines.launch

class APIViewModel(private val repository: Repository): ViewModel() {
    val menuResponse : MutableLiveData<Array<FoodModel>> = MutableLiveData()
    val stringResponse : MutableLiveData<String> = MutableLiveData()

    fun getMenu(r_id : Int){
        viewModelScope.launch {
            val response : Array<FoodModel> = repository.getMenu(r_id)
            menuResponse.value = response
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

    fun checkUser(utype : String, email : String){
        viewModelScope.launch {
            val response : String = repository.checkUser(utype, email)
            stringResponse.value = response
        }
    }

    fun addUser(utype: String, name : String, birthday : String, email : String, password : String){
        viewModelScope.launch {
            val response : String = repository.addUser(utype, name, birthday, email, password)
            stringResponse.value = response
        }
    }

    fun editUser(utype : String, email : String, part : String, value : String){
        viewModelScope.launch {
            val response : String = repository.editUser(utype, email, part, value)
            stringResponse.value = response
        }
    }

    fun deleteUser(utype : String, email : String){
        viewModelScope.launch {
            val response : String = repository.deleteUser(utype, email)
            stringResponse.value = response
        }
    }

    fun checkPass(utype: String, email: String, password: String){
        viewModelScope.launch {
            val response : String = repository.checkPass(utype, email, password)
            stringResponse.value = response
        }
    }
}