package com.lectorium.hw_6.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lectorium.hw_6.domain.models.Item
import com.lectorium.hw_6.domain.usecase.LoadListItemUseCase
import kotlinx.coroutines.launch

class ListItemsActivityViewModel(private val loadListItemUseCase: LoadListItemUseCase) :
    ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadItemList() {
        viewModelScope.launch {
            _itemList.value = loadListItemUseCase.loadItemList()
        }
    }
}