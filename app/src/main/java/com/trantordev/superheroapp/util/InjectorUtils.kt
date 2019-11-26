package com.trantordev.superheroapp.util

import com.trantordev.superheroapp.data.MainRepository
import com.trantordev.superheroapp.network.ApiServices
import com.trantordev.superheroapp.viewmodel.MainViewModelFactory

object InjectorUtils {

    private fun getMainRepository(): MainRepository {
        return MainRepository.getInstance(
            ApiServices.getInstance()
        )
    }

    fun provideMainListViewModelFactory(): MainViewModelFactory {
        val repository = getMainRepository()
        return MainViewModelFactory(repository)
    }
}