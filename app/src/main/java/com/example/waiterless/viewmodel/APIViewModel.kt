package com.example.waiterless.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.waiterless.models.CustomerModel
import com.example.waiterless.models.EmployeeModel
import com.example.waiterless.models.FoodModel
import com.example.waiterless.repository.Repository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.suspendCoroutine

class APIViewModel(private val repository: Repository): ViewModel() {
    val menuResponse : MutableLiveData<Array<FoodModel>> = MutableLiveData()
    val stringResponse : MutableLiveData<String> = MutableLiveData()
    val customerResponse : MutableLiveData<CustomerModel> = MutableLiveData()
    val employeeResponse : MutableLiveData<EmployeeModel> = MutableLiveData()
    val stringArrayResponse : MutableLiveData<Array<String>> = MutableLiveData()

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

    fun checkCustomerPass(email: String, password: String){
        viewModelScope.launch {
            val response : CustomerModel = repository.checkCustomerPass(email, password)
            customerResponse.value = response
        }
    }

    fun checkEmployeePass(email: String, password: String){
        viewModelScope.launch {
            val response : EmployeeModel = repository.checkEmployeePass(email, password)
            employeeResponse.value = response
        }
    }

    fun getCustomer(email : String){
        viewModelScope.launch {
            val response : CustomerModel = repository.getCustomer(email)
            customerResponse.value = response
        }
    }

    fun getEmployee(email : String){
        viewModelScope.launch {
            val response : EmployeeModel = repository.getEmployee(email)
            employeeResponse.value = response
        }
    }

    fun getTables(r_id : Int){
        viewModelScope.launch {
            val response : String = repository.getTables(r_id)
            stringResponse.value = response
        }
    }


    fun getChannel(r_id : Int){
        viewModelScope.launch {
            val response : String = repository.getChannel(r_id)
            stringResponse.value = response
        }
    }

    fun getRestaurants(){
        viewModelScope.launch {
            val response : Array<String> = repository.getRestaurants()
            stringArrayResponse.value = response
        }
    }
}