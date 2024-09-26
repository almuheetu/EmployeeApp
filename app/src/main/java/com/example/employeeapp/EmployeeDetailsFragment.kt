package com.example.employeeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.employeeapp.databinding.FragmentEmployeeDetailsBinding
import com.example.employeeapp.reposatories.EmployeeDetailsRepository
import com.example.employeeapp.viewModel.EmployeeDetailsViewModel

class EmployeeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentEmployeeDetailsBinding
    private lateinit var viewModel: EmployeeDetailsViewModel
    private val args: EmployeeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.data

        Log.d("TAG", "onViewCreated: $id")
        viewModel = EmployeeDetailsViewModel(EmployeeDetailsRepository())
        viewModel.getEmployeeDetails(id)
        viewModel.items.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvEmployeeName.text = it.name
                binding.tvEmployeeUserName.text = it.username
                binding.tvEmployeeEmail.text = it.email
                binding.tvEmployeeStreet.text = it.address.street
                binding.tvEmployeeCity.text = it.address.city
                binding.tvEmployeePhone.text = it.phone
                binding.tvEmployeeWebsite.text = it.website
                binding.tvEmployeeCompanyName.text = it.company.name
                binding.tvEmployeeCompanyBs.text = it.company.bs
            }
        }
    }
}