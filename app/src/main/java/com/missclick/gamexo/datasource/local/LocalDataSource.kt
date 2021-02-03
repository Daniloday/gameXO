package com.missclick.gamexo.datasource.local

import android.graphics.text.LineBreaker
import android.util.Log
import com.missclick.gamexo.datasource.local.entity.FinishEntity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class LocalDataSource(val database : ResultsDatabase) {

    fun getLessonsAsync() : Deferred<List<FinishEntity>> {
        return GlobalScope.async {
            database.resultsDao().getResults()
        }
    }

    fun insertLessonAsync(finishEntity: FinishEntity){
        GlobalScope.async {
            Log.e("repo",finishEntity.toString())
            database.resultsDao().insertResult(resultEntity = finishEntity)
        }
    }

    fun getResultByIdAsync(lessonId: Int) : Deferred<FinishEntity>{
        return GlobalScope.async {
            database.resultsDao().getResultById(id = lessonId)
        }
    }

    fun deleteResultAsync(dayEntity: FinishEntity){
        GlobalScope.async {
            database.resultsDao().removeResult(dayEntity = dayEntity)
        }
    }

    fun deleteAllLessons(){
        GlobalScope.async {
            database.resultsDao().deleteAllResults()
        }
    }
}