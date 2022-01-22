package com.lectorium.hw_6.domain.repository

import com.lectorium.hw_6.domain.models.Item

interface ItemListRepository {
    suspend fun getItemList(): List<Item>
}