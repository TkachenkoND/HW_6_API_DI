package com.lectorium.hw_6.domain.usecase

import com.lectorium.hw_6.domain.repository.ItemListRepository

class LoadListItemUseCase(private val moviesListRepository: ItemListRepository) {

    suspend fun loadItemList() = moviesListRepository.getItemList()
}
