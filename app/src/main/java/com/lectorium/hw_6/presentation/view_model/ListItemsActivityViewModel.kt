package com.lectorium.hw_6.presentation.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lectorium.hw_6.domain.models.Item
import com.lectorium.hw_6.domain.usecase.LoadListItemUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class ListItemsActivityViewModel(private val loadListItemUseCase: LoadListItemUseCase) :
    ViewModel() {

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadItemList() {
        viewModelScope.launch {
            try {
                _itemList.postValue(loadListItemUseCase.loadItemList())
                _isLoading.postValue(true)
            } catch (e: Exception) {
                Log.d("Load Exception", e.toString())
                _isLoading.postValue(false)
            }
        }
    }


}