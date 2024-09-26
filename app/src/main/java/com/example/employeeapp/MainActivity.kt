package com.example.employeeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.employeeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = EmployeeViewModel(EmployeeRepository())
//        viewModel.getEmployee()
//        viewModel.items.observe(this) {
//            it?.let {
//                Log.d("employee", "onCreate: $it")
//            }
//        }

//        if (savedInstanceState == null) {
//            val fragment =EmployeeDetailsFragment()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.employee_fragment_container_obj, fragment)
//                .commit()
//        }

//        viweModel = EmployeeDetailsViewModel(EmployeeDetailsRepository())
//        viweModel.getEmployeeDetails()
//        viweModel.items.observe(this) {
//            it?.let {
//                Log.d("employee", "onCreate: $it")
//            }
//
//        }
    }
}