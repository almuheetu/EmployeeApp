package com.example.employeeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.employeeapp.databinding.FragmentEmployeeListBinding
import com.example.employeeapp.placeholder.PlaceholderContent
import com.example.employeeapp.reposatories.EmployeeDetailsRepository
import com.example.employeeapp.reposatories.EmployeeRepository
import com.example.employeeapp.viewModel.EmployeeDetailsViewModel
import com.example.employeeapp.viewModel.EmployeeViewModel


class EmployeeFragment : Fragment() {
    private lateinit var binding: FragmentEmployeeListBinding
    private lateinit var viewModel: EmployeeViewModel
//    private lateinit var viewModel: EmployeeDetailsViewModel
    private lateinit var employeeAdapter: EmployeeAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.employeeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = EmployeeViewModel(EmployeeRepository())
        viewModel.getEmployee()
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {
                employeeAdapter = EmployeeAdapter(it)
                recyclerView.adapter = employeeAdapter

            }

        }
    }

}