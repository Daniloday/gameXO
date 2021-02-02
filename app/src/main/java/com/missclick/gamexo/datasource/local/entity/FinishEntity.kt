package com.missclick.gamexo.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class FinishEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "dayId")
    var id : Int? = null,

    @ColumnInfo(name = "field")
    var field : String = "",

    @ColumnInfo(name = "winner")
    var winner: Int = 0,

)
