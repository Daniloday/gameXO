package com.missclick.gamexo.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.missclick.gamexo.datasource.local.dao.ResultsDao
import com.missclick.gamexo.datasource.local.entity.FinishEntity


@Database(entities = [FinishEntity::class], version = 3)
abstract class ResultsDatabase : RoomDatabase(){
    abstract fun resultsDao() : ResultsDao

}