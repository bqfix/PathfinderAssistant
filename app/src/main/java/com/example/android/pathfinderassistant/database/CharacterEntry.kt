package com.example.android.pathfinderassistant.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.android.pathfinderassistant.characters.BaseCharacter

@Entity(tableName = "character_entries")
class CharacterEntry(baseCharacter: BaseCharacter?) {

    @PrimaryKey(autoGenerate = true)
    var databaseId: Int? = baseCharacter!!.databaseId
    var characterId = baseCharacter!!.characterId
    var characterName = baseCharacter!!.characterName
    var currentSubclassId = baseCharacter!!.currentSubclassId
    var currentStrengthBonus = baseCharacter!!.currentStrengthBonus
    var currentDexterityBonus = baseCharacter!!.currentDexterityBonus
    var currentConstitutionBonus = baseCharacter!!.currentConstitutionBonus
    var currentIntelligenceBonus = baseCharacter!!.currentIntelligenceBonus
    var currentWisdomBonus = baseCharacter!!.currentWisdomBonus
    var currentCharismaBonus = baseCharacter!!.currentCharismaBonus
    var currentHandSize = baseCharacter!!.currentHandSize
    var currentWeapons = baseCharacter!!.currentWeapons
    var currentSpells = baseCharacter!!.currentSpells
    var currentArmors = baseCharacter!!.currentArmors
    var currentItems = baseCharacter!!.currentItems
    var currentAllies = baseCharacter!!.currentAllies
    var currentBlessings = baseCharacter!!.currentBlessings
    var currentPowers = baseCharacter!!.currentPowers

    constructor() : this(baseCharacter = BaseCharacter())
}