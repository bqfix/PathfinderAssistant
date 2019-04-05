package com.example.android.pathfinderassistant.characterdatabase

import android.arch.persistence.room.TypeConverter
import android.util.Log

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromIntListToString(intList: List<Int>) : String{
            var convertedString = ""
            for (int in intList) {
                convertedString = convertedString.plus("$int,")
            }
            return convertedString
        }

        @TypeConverter
        @JvmStatic
        fun fromStringToIntList(convertedString : String) : List<Int>{
            val stringList = convertedString.split(",").toList()
            val intList : MutableList<Int> = mutableListOf()
            for (string in stringList) {
                if (!(string.isEmpty())) { //Only add if not empty string
                    intList.add(string.toInt())
                }
            }
            return intList
        }
    }
}