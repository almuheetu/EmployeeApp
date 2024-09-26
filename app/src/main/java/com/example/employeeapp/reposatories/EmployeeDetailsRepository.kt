package com.example.employeeapp.reposatories

import com.example.employeeapp.model.EmployeeResponseItem
import com.example.employeeapp.networks.ApiClient
import com.example.employeeapp.networks.ApiInterface

class EmployeeDetailsRepository {
    suspend fun getEmployeeDetails(id: Int): EmployeeResponseItem? {
        val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
        return employeeApi.getEmployeeDetails(id).body()
    }

}


