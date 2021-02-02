package com.missclick.gamexo.repository

import com.missclick.gamexo.data.Finish

interface IRepository {

    fun insertResult(result : Finish)
    suspend fun getResults() : List<Finish>
    suspend fun getLessonById(id : Int) : Finish
    suspend fun deleteLesson(result: Finish)
    suspend fun deleteAll()
}