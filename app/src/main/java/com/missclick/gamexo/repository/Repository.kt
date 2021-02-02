package com.missclick.gamexo.repository

import com.missclick.gamexo.data.Finish
import com.missclick.gamexo.datasource.local.LocalDataSource
import com.missclick.gamexo.map.mapLessonEntityToModel
import com.missclick.gamexo.map.mapLessonModelToEntity

class Repository(var local : LocalDataSource): IRepository {

    override suspend fun getResults() : List<Finish> {
        val lessonEntities =  local.getLessonsAsync().await()
        val lessonModels = mutableListOf<Finish>()
        for(lesson in lessonEntities)
            lessonModels.add(mapLessonEntityToModel(resultEntity = lesson))
        return lessonModels
    }

    override fun insertResult(result : Finish) {
        val lessonEntity = mapLessonModelToEntity(lessonModel = result)
        local.insertLessonAsync(finishEntity = lessonEntity)

    }

    override suspend fun getLessonById(id : Int) : Finish {
        val entity = local.getResultByIdAsync(lessonId = id).await()
        return mapLessonEntityToModel(resultEntity = entity)
    }

    override suspend fun deleteLesson(result: Finish) {
        val dayEntity = mapLessonModelToEntity(lessonModel = result)
        local.deleteResultAsync(dayEntity = dayEntity)
    }

    override suspend fun deleteAll(){
        local.deleteAllLessons()
    }

}