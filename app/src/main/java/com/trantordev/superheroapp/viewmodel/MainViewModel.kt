package com.trantordev.superheroapp.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.trantordev.superheroapp.data.MainRepository
import com.trantordev.superheroapp.data.model.Hero
import com.trantordev.superheroapp.ui.MainListener
import kotlinx.coroutines.Dispatchers

class MainViewModel internal constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    var mainListener: MainListener? = null
    var year: Int = 2006
    var resource: String = "$year.json"


    val heroes = liveData(Dispatchers.IO) {
        val retrivedHeroes = mainRepository.getHeroes(resource)
        val list: List<Hero> = retrivedHeroes.heroes.sortedWith(compareBy({it.score})).sortedByDescending { it.score }.dropLast(1)
        retrivedHeroes.heroes = list
        emit(retrivedHeroes)
    }

    fun onLogoutIconClick(view: View){
        mainListener!!.onClose()
    }

    fun loadNext(){
        year += 3

    }

    fun isLoading(){

    }


}