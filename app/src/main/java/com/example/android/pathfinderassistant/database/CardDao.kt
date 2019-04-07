package com.example.android.pathfinderassistant.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.android.pathfinderassistant.deck.Card

@Dao
interface CardDao {

    @Query("SELECT * FROM cards WHERE characterId = :characterId ORDER BY databaseId")
    fun loadCardsByCharacterId(characterId : Int) : LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Query("DELETE FROM cards WHERE characterId = :characterId")
    fun deleteCardsByCharacterId(characterId: Int)

    @Delete
    fun deleteCard(card: Card)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCard(card: Card)
}