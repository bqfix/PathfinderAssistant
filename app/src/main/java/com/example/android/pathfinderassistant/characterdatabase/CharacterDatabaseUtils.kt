package com.example.android.pathfinderassistant.characterdatabase

import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.characters.Seoni
import com.example.android.pathfinderassistant.characters.SeoniConstants

object CharacterDatabaseUtils {
    fun characterEntryToCharacter(characterEntry: CharacterEntry): BaseCharacter? {
        return when (characterEntry.characterId) {
            SeoniConstants.SEONI_KEY -> Seoni(
                databaseId = characterEntry.databaseId,
                characterName = characterEntry.characterName,
                currentSubclassId = characterEntry.currentSubclassId,
                currentStrengthBonus = characterEntry.currentStrengthBonus,
                currentDexterityBonus = characterEntry.currentDexterityBonus,
                currentConstitutionBonus = characterEntry.currentConstitutionBonus,
                currentIntelligenceBonus = characterEntry.currentIntelligenceBonus,
                currentWisdomBonus = characterEntry.currentWisdomBonus,
                currentCharismaBonus = characterEntry.currentCharismaBonus,
                currentHandSize = characterEntry.currentHandSize,
                currentWeapons = characterEntry.currentWeapons,
                currentSpells = characterEntry.currentSpells,
                currentArmors = characterEntry.currentArmors,
                currentItems = characterEntry.currentItems,
                currentAllies = characterEntry.currentAllies,
                currentBlessings = characterEntry.currentBlessings,
                currentPowers = characterEntry.currentPowers)
            else -> null
        }
    }
}