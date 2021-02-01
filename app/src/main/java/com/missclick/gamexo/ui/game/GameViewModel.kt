package com.missclick.gamexo.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _text = MutableLiveData<Int>().apply {
        value = 0
    }
    var player: LiveData<Int> = _text

    fun changePlayer(){
        player =  MutableLiveData((player.value!! + 1) % 2)
    }
}