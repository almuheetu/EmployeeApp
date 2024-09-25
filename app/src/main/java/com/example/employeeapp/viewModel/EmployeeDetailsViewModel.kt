package com.example.employeeapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeeapp.model.EmployeeResponse
import com.example.employeeapp.reposatories.EmployeeDetailsRepository
import kotlinx.coroutines.launch
import java.io.IOException


class EmployeeDetailsViewModel(val employeeDetailsRepository: EmployeeDetailsRepository) : ViewModel() {
    private val _items: MutableLiveData<EmployeeResponse?> by lazy {
        MutableLiveData<EmployeeResponse?>()
    }
    val items: LiveData<EmployeeResponse?> get() = _items

    fun getEmployeeDetails() = viewModelScope.launch {
        try {
            _items.value = employeeDetailsRepository.getEmployeeDetails(id = 1)
            if (_items.value == null) {
                _items.value = EmployeeResponse()
            }else{
                _items.value = null
            }
        } catch (e: IOException) {
            Log.d("catch", "getDivision: $e")
            _items.value = null
        }catch (e: Exception) {
            Log.d("catch", "getDivision: $e")
            _items.value = null
        }
    }
}


