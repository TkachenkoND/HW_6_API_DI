package com.lectorium.hw_6.di

import com.lectorium.hw_6.presentation.view_model.ListItemsActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListItemsActivityViewModel(get()) }
}