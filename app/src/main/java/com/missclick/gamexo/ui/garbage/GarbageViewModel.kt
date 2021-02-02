package com.missclick.gamexo.ui.garbage

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.missclick.gamexo.data.Finish
import com.missclick.gamexo.datasource.local.LocalDataSource
import com.missclick.gamexo.datasource.local.ResultsDatabase
import com.missclick.gamexo.repository.IRepository
import com.missclick.gamexo.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GarbageViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun btn1(context: Context){
        val database = Room.databaseBuilder(context, ResultsDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        val rep =  Repository(LocalDataSource(database))
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.getLessonById(1)
            }
        }
    }

    fun btn2(context: Context){
        val database = Room.databaseBuilder(context, ResultsDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        val rep =  Repository(LocalDataSource(database))
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.getResults()
            }
        }
    }

    fun btn3(context: Context){
        val database = Room.databaseBuilder(context, ResultsDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        val rep =  Repository(LocalDataSource(database))
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.deleteAll()
            }
        }
    }

    fun btn4(context: Context){
        val database = Room.databaseBuilder(context, ResultsDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        val rep =  Repository(LocalDataSource(database))
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                rep.deleteLesson(Finish(winner = 1,field = mutableListOf(1,1,1,1,1,1,1,1,1)))
            }
        }

    }


}