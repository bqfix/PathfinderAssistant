package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_ARCANIST_ID
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_ARCANIST_NAME
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_ELDRITCH_SAVANT_ID
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_ELDRITCH_SAVANT_NAME
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_KEY
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_OCCULARIUM_SCHOLAR_ID
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_OCCULARIUM_SCHOLAR_NAME
import com.example.android.pathfinderassistant.characters.EnoraConstants.ENORA_POWER_LIST
import com.example.android.pathfinderassistant.deck.Card

class Enora(
    databaseId: Int? = null,
    characterName: String = "Enora",
    currentSubclassId: Int = ENORA_ARCANIST_ID,
    currentStrengthBonus: Int = 0,
    currentDexterityBonus: Int = 0,
    currentConstitutionBonus: Int = 0,
    currentIntelligenceBonus: Int = 0,
    currentWisdomBonus: Int = 0,
    currentCharismaBonus: Int = 0,
    currentHandSize: Int = 6,
    currentWeapons: Int = 0,
    currentSpells: Int = 6,
    currentArmors: Int = 0,
    currentItems: Int = 3,
    currentAllies: Int = 2,
    currentBlessings: Int = 4,
    proficiencies: List<String> = listOf(),
    deck: ArrayList<Card> = arrayListOf(),
    currentPowers: List<Int> = List(ENORA_POWER_LIST[currentSubclassId].size) { 0 }
) : BaseCharacter(
    databaseId = databaseId,
    characterId = ENORA_KEY,
    characterName = characterName,
    subclassNames = listOf(ENORA_ARCANIST_NAME, ENORA_ELDRITCH_SAVANT_NAME, ENORA_OCCULARIUM_SCHOLAR_NAME),
    currentSubclassId = currentSubclassId,
    maxStrengthBonus = 1,
    currentStrengthBonus = currentStrengthBonus,
    maxDexterityBonus = 2,
    currentDexterityBonus = currentDexterityBonus,
    maxConstitutionBonus = 1,
    currentConstitutionBonus = currentConstitutionBonus,
    maxIntelligenceBonus = 4,
    currentIntelligenceBonus = currentIntelligenceBonus,
    maxWisdomBonus = 3,
    currentWisdomBonus = currentWisdomBonus,
    maxCharismaBonus = 4,
    currentCharismaBonus = currentCharismaBonus,
    maxHandSize = when (currentSubclassId) {
        ENORA_OCCULARIUM_SCHOLAR_ID -> 8
        ENORA_ELDRITCH_SAVANT_ID -> 9
        else -> 7
    },
    minHandSize = 6,
    currentHandSize = currentHandSize,
    maxWeapons = 0,
    minWeapons = 0,
    currentWeapons = currentWeapons,
    maxSpells = 9,
    minSpells = 6,
    currentSpells = currentSpells,
    maxArmors = 0,
    minArmors = 0,
    currentArmors = currentArmors,
    maxItems = 6,
    minItems = 3,
    currentItems = currentItems,
    maxAllies = 4,
    minAllies = 2,
    currentAllies = currentAllies,
    maxBlessings = 6,
    minBlessings = 4,
    currentBlessings = currentBlessings,
    proficiencies = proficiencies,
    deck = deck,
    characterPowers = ENORA_POWER_LIST[currentSubclassId],
    currentPowers = currentPowers,
    characterSkills = listOf("Arcane: Intelligence +1", "Craft: Intelligence +1", "Knowledge: Intelligence +3"),
    characterDice = listOf("d6", "d6", "d4", "d12", "d6", "d8")
)

object EnoraConstants {
    const val ENORA_KEY = "enora_key"
    const val ENORA_ARCANIST_ID = 0
    const val ENORA_ELDRITCH_SAVANT_ID = 1
    const val ENORA_OCCULARIUM_SCHOLAR_ID = 2
    const val ENORA_ARCANIST_NAME = "Arcanist"
    const val ENORA_ELDRITCH_SAVANT_NAME = "Eldritch Savant"
    const val ENORA_OCCULARIUM_SCHOLAR_NAME = "Occularium Scholar"
    val ENORA_ARCANIST_POWERS = listOf(
        listOf(
            "When you attempt a check to acquire a spell, you may use your Knowledge skill in place of any listed skill.",
            "When you attempt a check to acquire a spell or an item, you may use your Knowledge skill in place of any listed skill."
        ),
        listOf("After you play a spell, you may recharge a random spell from your discard pile."),
        listOf(
            "Discard a spell to reduce Cold or Fire damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire damage dealt to you or any character at your location to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you or any character at your location to 0."
        )
    )
    val ENORA_ELDRITCH_SAVANT_POWERS = listOf(
        listOf(
            "When you attempt a check to acquire a spell, you may use your Knowledge skill in place of any listed skill.",
            "When you attempt a check to acquire a spell or an item, you may use your Knowledge skill in place of any listed skill."
        ),
        listOf(
            "After you play a spell, you may recharge a random spell from your discard pile.",
            "After you play a spell, you may recharge a random spell from your discard pile or shuffle it into your deck."
        ),
        listOf(
            "Discard a spell to reduce Cold or Fire damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire damage dealt to you or any character at your location to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you or any character at your location to 0.",
            "Discard or recharge a spell to reduce Cold or Fire damage dealt to you to 0.",
            "Discard or recharge a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you to 0.",
            "Discard or recharge a spell to reduce Cold or Fire damage dealt to you or any character at your location to 0.",
            "Discard or recharge a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you or any character at your location to 0."
        ),
        listOf(
            "-",
            "You may discard a card to examine the top card of your deck; if it is a spell, you may add it to your hand.",
            "You may discard a card to examine the top card of your deck and you may recharge the examined card; if it is a spell, you may add it to your hand."
        ),
        listOf(
            "-",
            "When you play a spell that has the Cold or Fire traits, you may replace any one of those traits with another of those traits.",
            "When you play a spell that has the Cold or Fire or Acid, Electricity, or Force traits, you may replace any one of those traits with another of those traits."
        )
    )
    val ENORA_OCCULARIUM_SCHOLAR_POWERS = listOf(
        listOf(
            "When you attempt a check to acquire a spell, you may use your Knowledge skill in place of any listed skill.",
            "When you attempt a check to acquire a spell or an item, you may use your Knowledge skill in place of any listed skill.",
            "When you attempt a check to acquire a spell, or you attempt to defeat a barrier you may use your Knowledge skill in place of any listed skill.",
            "When you attempt a check to acquire a spell or an item, or you attempt to defeat a barrier you may use your Knowledge skill in place of any listed skill."
        ),
        listOf("After you play a spell, you may recharge a random spell from your discard pile."),
        listOf(
            "Discard a spell to reduce Cold or Fire damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you to 0.",
            "Discard a spell to reduce Cold or Fire damage dealt to you or any character at your location to 0.",
            "Discard a spell to reduce Cold or Fire or Acid, Electricity, or Force damage dealt to you or any character at your location to 0."
        ),
        listOf("-",
            "You may reveal a boon that has the Book trait to add 1d4 to your check.",
            "You may reveal a boon that has the Book trait to add 1d4 +1 to your check.",
            "You may reveal a boon that has the Book trait to add 1d4 +2 to your check."),
        listOf("-",
            "At the start of your turn, you may recharge a boon that has the Book trait to examine the top 3 cards of your location deck, or recharge a spell to examine the top 3 cards of your deck.",
            "At the start of your turn, you may recharge a boon that has the Book trait to examine the top 3 cards of your location deck, or recharge a spell to examine the top 3 cards of your deck. Put them back in any order.")
    )
    val ENORA_POWER_LIST = listOf(ENORA_ARCANIST_POWERS, ENORA_ELDRITCH_SAVANT_POWERS, ENORA_OCCULARIUM_SCHOLAR_POWERS)
}