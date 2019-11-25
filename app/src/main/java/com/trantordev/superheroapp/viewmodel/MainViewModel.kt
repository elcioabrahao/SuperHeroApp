package com.trantordev.superheroapp.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.trantordev.superheroapp.data.MainRepository
import com.trantordev.superheroapp.ui.MainListener
import kotlinx.coroutines.Dispatchers

class MainViewModel internal constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    var mainListener: MainListener? = null
    var resource: String = "2006.json"


    val heroes = liveData(Dispatchers.IO) {
        val retrivedHeroes = mainRepository.getHeroes(resource)
        emit(retrivedHeroes)
    }

    fun onLogoutIconClick(view: View){
        mainListener!!.onClose()
    }


}