package com.lectorium.hw_6.data.repository_impl

import com.lectorium.hw_6.data.services.ItemListServices
import com.lectorium.hw_6.domain.models.Item
import com.lectorium.hw_6.domain.repository.ItemListRepository

class ItemListRepositoryImpl(private val itemListServices: ItemListServices) : ItemListRepository {
    override suspend fun getItemList() = itemListServices.getItems()
}