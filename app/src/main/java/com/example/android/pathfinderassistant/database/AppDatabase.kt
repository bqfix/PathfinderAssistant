package com.example.android.pathfinderassistant.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = [CharacterEntry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao

    companion object {
        private var sInstance : AppDatabase? = null
        private val DATABASE_NAME = "character_database"

        fun getInstance(context : Context) : AppDatabase? {
            if (sInstance == null) {
                synchronized(AppDatabase::class) {
                    sInstance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
                }
            }
            return sInstance
        }
    }
}