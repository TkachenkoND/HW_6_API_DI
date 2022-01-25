package com.lectorium.hw_6.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lectorium.hw_6.databinding.FragmentMainBinding
import com.lectorium.hw_6.presentation.view_model.ListItemsActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMain : Fragment() {
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModel<ListItemsActivityViewModel>()
    private val listItemAdapter = ListItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadItemList()

        initAdapter()
        initObserver()
    }

    private fun initAdapter() {
        binding.recyclerViewContainerItem.apply {
            adapter = listItemAdapter
        }
    }

    private fun initObserver() {
        viewModel.itemList.observe(viewLifecycleOwner, {
            listItemAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}