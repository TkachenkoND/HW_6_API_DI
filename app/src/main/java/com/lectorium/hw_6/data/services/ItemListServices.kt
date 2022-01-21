package com.lectorium.hw_6.data.services

import com.lectorium.hw_6.domain.models.Item
import retrofit2.http.GET

interface ItemListServices {
    @GET("/photos")
    suspend fun getItems(): List<Item>
}