package ru.vlasoff.simplefinance.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.vlasoff.simplefinance.R
import ru.vlasoff.simplefinance.databinding.ExposeItemBinding
import ru.vlasoff.simplefinance.databinding.IncomeItemBinding
import ru.vlasoff.simplefinance.databinding.InfoItemBinding
import ru.vlasoff.simplefinance.domain.entities.recycler_items.Item


class MainScreenRecyclerViewAdapter : ListAdapter<Item, BaseViewHolder>(DiffCallBack()) {
    class InfoViewHolder(private val binding: InfoItemBinding) : BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            InfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.tvBalanceValue.text = (item as Item.Info).balance.toString()
            binding.tvPlannedExposesValue.text = item.plannedExposes.toString()
            binding.tvAvailableValue.text = item.currency
        }
    }

    inner class ExposesViewHolder(private val binding: ExposeItemBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ExposeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.fabAddExpose.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainScreenFragment_to_addExposeFragment)
            }
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_mainScreenFragment_to_showExposeFragment)
            }

        }
    }

    inner class IncomesViewHolder(private val binding: IncomeItemBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            IncomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            binding.fabAddIncome.setOnClickListener {
                it.findNavController().navigate(R.id.action_mainScreenFragment_to_addIncomeFragment)
            }
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_mainScreenFragment_to_showIncomeFragment)
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            INFO_ITEM_TYPE -> InfoViewHolder(parent)
            EXPOSE_ITEM_TYPE -> InfoViewHolder(parent)
            else -> ExposesViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Item.Info -> (holder as InfoViewHolder).bind(item)
            is Item.Exposes -> (holder as ExposesViewHolder).bind(item)
            is Item.Incomes -> (holder as IncomesViewHolder).bind(item)
        }
    }

    companion object {
        const val INFO_ITEM_TYPE = 1
        const val EXPOSE_ITEM_TYPE = 2
        const val INCOME_ITEM_TYPE = 3
    }
}