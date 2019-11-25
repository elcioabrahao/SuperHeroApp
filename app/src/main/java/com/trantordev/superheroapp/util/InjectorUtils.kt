package com.trantordev.superheroapp.util

import android.content.Context
import com.trantordev.superheroapp.data.MainRepository
import com.trantordev.superheroapp.network.ApiServices
import com.trantordev.superheroapp.viewmodel.MainViewModelFactory

object InjectorUtils {



    private fun getMainRepository(context: Context): MainRepository {
        return MainRepository.getInstance(
            ApiServices.getInstance()
//            AppDatabase.getInstance(context.applicationContext).loginDao(),
//            AppDatabase.getInstance(context.applicationContext).clientAccountInfoDao())
        )
    }


    fun provideMainListViewModelFactory(context: Context): MainViewModelFactory {
        val repository = getMainRepository(context)
        return MainViewModelFactory(repository)
    }
}