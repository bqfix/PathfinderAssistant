package com.example.android.pathfinderassistant.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.android.pathfinderassistant.deck.Card

@Database(entities = [CharacterEntry::class, Card::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao
    abstract fun cardDao() : CardDao

    companion object {
        private var sInstance : AppDatabase? = null
        private val DATABASE_NAME = "character_database"

        fun getInstance(context : Context) : AppDatabase? {
            if (sInstance == null) {
                synchronized(AppDatabase::class) {
                    sInstance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
                }
            }
            return sInstance
        }
    }


}