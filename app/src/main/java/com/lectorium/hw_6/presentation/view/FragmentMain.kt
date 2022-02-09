package com.lectorium.hw_6.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
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
        initObserverLoading()
        initObserverItemList()

    }

    private fun initAdapter() {
        binding.recyclerViewContainerItem.apply {
            adapter = listItemAdapter
        }
    }

    private fun initObserverLoading(){
        binding.shimmer.startShimmer()

        viewModel.isLoading.observe(viewLifecycleOwner){
            if (it){
                binding.shimmer.stopShimmer()
                binding.shimmer.visibility = ProgressBar.GONE
                binding.recyclerViewContainerItem.visibility = ProgressBar.VISIBLE
            }
            else
                Toast.makeText(activity, "Sorry, an error occurred (", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initObserverItemList() {
        viewModel.itemList.observe(viewLifecycleOwner) {
            listItemAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}