package com.example.waiterless.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.waiterless.repository.Repository

class APIViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        return APIViewModel(repository) as T
    }
}