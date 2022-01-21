package com.lectorium.hw_6.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.lectorium.hw_6.databinding.ListItemsActivityBinding
import com.lectorium.hw_6.presentation.view_model.ListItemsActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListItemsActivity : AppCompatActivity() {

    lateinit var binding: ListItemsActivityBinding
    private val viewModel by viewModel<ListItemsActivityViewModel>()
    private val listItemAdapter = ListItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListItemsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadItemList()

        initAdapter()
        initObserver()
    }

    fun initAdapter(){
        binding.recyclerViewContainerItem.apply {
            adapter = listItemAdapter
        }
    }

    fun initObserver(){
        viewModel.itemList.observe(this, {
            listItemAdapter.submitList(it)
        })
    }
}