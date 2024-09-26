package com.example.employeeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.employeeapp.databinding.FragmentEmployeeListBinding
import com.example.employeeapp.reposatories.EmployeeRepository
import com.example.employeeapp.viewModel.EmployeeViewModel


class EmployeeFragment : Fragment(), EmployeeAdapter.OnItemClickListener {
    private lateinit var binding: FragmentEmployeeListBinding
    private lateinit var viewModel: EmployeeViewModel
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
        EmployeeAdapter.listener = this
        viewModel = EmployeeViewModel(EmployeeRepository())
        viewModel.getEmployee()
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {
                employeeAdapter = EmployeeAdapter(it)
                recyclerView.adapter = employeeAdapter

            }

        }
    }

    override fun onItemClick(id: Int) {
        val action = EmployeeFragmentDirections.actionEmployeeFragmentToEmployeeDetailsFragment(id)
        findNavController().navigate(action)
    }

}