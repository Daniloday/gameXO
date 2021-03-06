package com.missclick.gamexo.datasource.local.dao

import androidx.room.*
import com.missclick.gamexo.datasource.local.entity.FinishEntity

@Dao
interface ResultsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(resultEntity: FinishEntity)

    @Query("SELECT * FROM result1")
    fun getResults() : List<FinishEntity>

    @Query("SELECT * FROM result1 WHERE id = :id")
    fun getResultById(id : Int) : FinishEntity

    @Delete
    fun removeResult(dayEntity: FinishEntity)

    @Query("DELETE FROM result1")
    fun deleteAllResults()


}