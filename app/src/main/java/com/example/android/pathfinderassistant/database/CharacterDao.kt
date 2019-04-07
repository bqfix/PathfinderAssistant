package com.example.android.pathfinderassistant.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_entries ORDER BY databaseId")
    fun loadAllCharacters() : LiveData<List<CharacterEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(characterEntry: CharacterEntry)

    @Delete
    fun deleteCharacter(characterEntry: CharacterEntry)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCharacter(characterEntry: CharacterEntry)
}