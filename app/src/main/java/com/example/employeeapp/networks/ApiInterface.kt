package com.example.employeeapp.networks

import com.example.employeeapp.model.EmployeeDetailsResponse
import com.example.employeeapp.model.EmployeeResponse
import com.example.employeeapp.model.EmployeeResponseItem
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users")
    suspend fun getEmployee(): Response<EmployeeResponse>
    @GET("users/{id}")
    suspend fun getEmployeeDetails(@Path("id") id: Int): Response<EmployeeResponseItem>
}