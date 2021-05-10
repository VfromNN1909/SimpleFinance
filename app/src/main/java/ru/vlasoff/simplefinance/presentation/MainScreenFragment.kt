package ru.vlasoff.simplefinance.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vlasoff.simplefinance.R
import ru.vlasoff.simplefinance.databinding.FragmentMainScreenBinding
import ru.vlasoff.simplefinance.presentation.adapter.MainScreenRecyclerViewAdapter

class MainScreenFragment : Fragment() {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddIncome.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_addIncomeFragment)
        }

        binding.incomeItem.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_showIncomeFragment)
        }

        binding.fabAddExpose.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_addExposeFragment)
        }

        binding.exposeItem.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_showExposeFragment)
        }
    }
}