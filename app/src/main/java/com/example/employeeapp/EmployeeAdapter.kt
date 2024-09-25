package com.example.employeeapp

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import com.example.employeeapp.databinding.AdapterEmployeeBinding
import com.example.employeeapp.model.EmployeeResponseItem


class EmployeeAdapter(
    private val employeeList: List<EmployeeResponseItem>,
) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(var binding: AdapterEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterEmployeeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val employee = employeeList[position]
        viewHolder.binding.tvEmployeeName.text = employee.name
    }

    override fun getItemCount(): Int {
        return employeeList.size

    }


}