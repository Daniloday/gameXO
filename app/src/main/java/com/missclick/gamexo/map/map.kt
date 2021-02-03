package com.missclick.gamexo.map

import com.missclick.gamexo.data.Finish
import com.missclick.gamexo.datasource.local.entity.FinishEntity

fun mapLessonEntityToModel(resultEntity: FinishEntity) : Finish {
    val linksStr = resultEntity.field
    val links = strToMap(linksStr)
    return Finish(

            winner = resultEntity.winner,
            field = links
    )
}

fun mapLessonModelToEntity(lessonModel: Finish) : FinishEntity{
    val links = mapToStr(lessonModel.field)
    return FinishEntity(
            id = 1,
            winner = lessonModel.winner,
            field = links
    )
}

//map() -> "zoom"::"link","tg"::"link" ...
fun mapToStr(map : List<Int>) : String{
    var links = ""
    for(key in map){
        links += "$key,"
    }
    links = links.dropLast(1)
    return links
}

// "zoom"::"link","tg"::"link" ... -> map()
fun strToMap(strLinks : String) : MutableList<Int> {
    val links = mutableListOf<Int>()
    val couples = strLinks.split(",")
    for(couple in couples){
        links.add(couple.toInt())
    }
    return links
}