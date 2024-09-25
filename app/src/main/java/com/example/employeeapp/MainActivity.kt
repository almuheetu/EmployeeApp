package com.example.employeeapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeapp.databinding.ActivityMainBinding
import com.example.employeeapp.reposatories.EmployeeRepository
import com.example.employeeapp.viewModel.EmployeeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EmployeeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = EmployeeViewModel(EmployeeRepository())
        viewModel.getEmployee()
        viewModel.items.observe(this) {
            it?.let {
                Log.d("employee", "onCreate: $it")
            }
        }
    }
}