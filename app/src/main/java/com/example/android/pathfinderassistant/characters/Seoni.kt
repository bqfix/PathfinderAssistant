package com.example.android.pathfinderassistant.characters

val SUBCLASS_SORCEROR_ID = 0
val SUBCLASS_ELEMENTAL_MASTER_ID = 1
val SUBCLASS_CORRUPTOR_ID = 2
val SUBCLASS_SORCEROR_NAME = "Sorceror"
val SUBCLASS_ELEMENTAL_MASTER_NAME = "Elemental Master"
val SUBCLASS_CORRUPTOR_NAME = "Corruptor"

class Seoni() : BaseCharacter(
    characterName = "Seoni",
    subclassNames = listOf(SUBCLASS_SORCEROR_NAME, SUBCLASS_ELEMENTAL_MASTER_NAME, SUBCLASS_CORRUPTOR_NAME),
    currentSubclassId = SUBCLASS_SORCEROR_ID,
    maxStrengthBonus = 1,
    currentStrengthBonus = 0,
    maxDexterityBonus = 2,
    currentDexterityBonus = 0,
    maxConstitutionBonus = 2,
    currentConstitutionBonus = 0,
    maxIntelligenceBonus = 4,
    currentIntelligenceBonus = 0,
    maxWisdomBonus = 2,
    currentWisdomBonus = 0,
    maxCharismaBonus = 4,
    currentCharismaBonus = 0,
    maxHandSize = 7,
    currentHandSize = 6,
    maxWeapons = 1,
    minWeapons = 0,
    currentWeapons = 0,
    maxSpells = 7,
    minSpells = 5,
    currentSpells = 5,
    maxArmors = 2,
    minArmors = 1,
    currentArmors = 1,
    maxItems = 4,
    minItems = 2,
    currentItems = 2,
    maxAllies = 5,
    minAllies = 3,
    currentAllies = 3,
    maxBlessings = 6,
    minBlessings = 4,
    currentBlessings = 4,
    proficiencies = listOf()
) {
    override fun changeSubclass(subclassNumber: Int) {
        when (subclassNumber) {
            SUBCLASS_SORCEROR_ID -> {
                maxHandSize = 7
                proficiencies = listOf()
            }
            SUBCLASS_ELEMENTAL_MASTER_ID -> {
                maxHandSize = 8
                proficiencies = listOf()
            }
            SUBCLASS_CORRUPTOR_ID -> {
                maxHandSize = 7
                proficiencies = listOf("None", "Light Armors")
            }
            else -> return
        }
    }
}