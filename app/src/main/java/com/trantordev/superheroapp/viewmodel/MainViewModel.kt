package com.trantordev.superheroapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.trantordev.superheroapp.data.MainRepository
import com.trantordev.superheroapp.data.model.Hero
import com.trantordev.superheroapp.data.model.SuperHeroDataResponse
import com.trantordev.superheroapp.ui.MainListener
import kotlinx.coroutines.Dispatchers

class MainViewModel internal constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    var mainListener: MainListener? = null
    var year: Int? = null

    fun loadNext(): LiveData<SuperHeroDataResponse>{
        year = year!! + 3
        if(year!!>2018) year = 2006
        return liveData(Dispatchers.IO) {
            val retrivedHeroes = mainRepository.getHeroes("$year.json")
            val list: List<Hero> = retrivedHeroes.heroes.sortedWith(compareBy({it.score}))
                .sortedByDescending { it.score }.dropLast(1)
            retrivedHeroes.heroes = list
            emit(retrivedHeroes)
        }
    }

    fun refreshList(){
        mainListener!!.onRefresh()
    }

}