package com.example.employeeapp.reposatories

import com.example.employeeapp.model.EmployeeResponse
import com.example.employeeapp.networks.ApiClient
import com.example.employeeapp.networks.ApiInterface

class EmployeeDetailsRepository {
    suspend fun getEmployeeDetails(id: Int): EmployeeResponse {
        val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
        val response = employeeApi.getEmployeeDetails(id)
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            throw Exception("Failed to fetch employee details")
        }






        //return employeeApi.getEmployeeDetails(id).body()!!
    }
}