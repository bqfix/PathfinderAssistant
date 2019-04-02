package com.example.android.pathfinderassistant.characterdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(CharacterEntry::class), version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao

    companion object {
        private var sInstance : CharacterDatabase? = null
        private val DATABASE_NAME = "character_database"

        fun getInstance(context : Context) : CharacterDatabase? {
            if (sInstance == null) {
                synchronized(CharacterDatabase::class) {
                    sInstance = Room.databaseBuilder(context.applicationContext, CharacterDatabase::class.java, DATABASE_NAME).build()
                }
            }
            return sInstance
        }
    }
}