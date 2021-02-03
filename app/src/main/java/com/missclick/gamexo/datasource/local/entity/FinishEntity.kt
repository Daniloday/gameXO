package com.missclick.gamexo.datasource.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result1")
data class FinishEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "field")
    var field : String,

    @ColumnInfo(name = "winner")
    var winner: Int,

)
