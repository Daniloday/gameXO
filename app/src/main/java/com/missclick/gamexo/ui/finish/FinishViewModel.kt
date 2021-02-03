package com.missclick.gamexo.ui.finish

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gamexo.App
import com.missclick.gamexo.data.Finish
import com.missclick.gamexo.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FinishViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var rep: IRepository

    init {
        App.appComponent.inject(this)
    }

    fun saveResult(result: Finish){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.insertResult(
                        result = result
                )
            }
        }
    }

}