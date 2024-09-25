package com.example.employeeapp.reposatories

import com.example.employeeapp.model.EmployeeResponse
import com.example.employeeapp.networks.ApiClient
import com.example.employeeapp.networks.ApiInterface
import retrofit2.Response

class EmployeeRepository() {
    suspend fun getEmployee(): EmployeeResponse {
       val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
       return employeeApi.getEmployee().body()!!

    }
}