package com.example.employeeapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeeapp.model.EmployeeResponse
import com.example.employeeapp.reposatories.EmployeeRepository
import kotlinx.coroutines.launch
import java.io.IOException

class EmployeeViewModel(val employeeRepository: EmployeeRepository) : ViewModel() {
    private val _items: MutableLiveData<EmployeeResponse?> by lazy {
        MutableLiveData<EmployeeResponse?>()
    }
    val items: LiveData<EmployeeResponse?> get() = _items

    fun getEmployee() = viewModelScope.launch {
        try {
            _items.value = employeeRepository.getEmployee()

        } catch (e: IOException) {
            Log.d("catch", "getDivision: $e")
            _items.value = null

        }
    }
}
