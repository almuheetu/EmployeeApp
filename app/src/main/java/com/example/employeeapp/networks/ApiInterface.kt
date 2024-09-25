package com.example.employeeapp.networks

import com.example.employeeapp.model.EmployeeResponse
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    suspend fun getEmployee(): Response<EmployeeResponse>

}