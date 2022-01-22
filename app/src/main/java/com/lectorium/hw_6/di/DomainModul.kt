package com.lectorium.hw_6.di

import com.lectorium.hw_6.domain.usecase.LoadListItemUseCase
import org.koin.dsl.module

val domainModule = module {
    factory{ LoadListItemUseCase(get()) }
}