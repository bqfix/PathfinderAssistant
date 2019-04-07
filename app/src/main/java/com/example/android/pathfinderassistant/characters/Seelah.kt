package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_POWER_LIST
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_INHERITORS_BLADE_ID
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_INHERITORS_BLADE_NAME
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_KEY
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_PALADIN_ID
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_PALADIN_NAME
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_POWER_LIST
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_WARDENSTONE_SENTRY_ID
import com.example.android.pathfinderassistant.characters.SeelahConstants.SEELAH_WARDENSTONE_SENTRY_NAME
import com.example.android.pathfinderassistant.deck.Card

class Seelah(
    databaseId : Int? = null,
    characterName : String = "Seelah",
    currentSubclassId : Int = SEELAH_PALADIN_ID,
    currentStrengthBonus : Int = 0,
    currentDexterityBonus : Int = 0,
    currentConstitutionBonus : Int = 0,
    currentIntelligenceBonus : Int = 0,
    currentWisdomBonus : Int = 0,
    currentCharismaBonus : Int = 0,
    currentHandSize : Int = 4,
    currentWeapons : Int = 4,
    currentSpells : Int = 1,
    currentArmors : Int = 3,
    currentItems : Int = 1,
    currentAllies : Int = 2,
    currentBlessings : Int = 4,
    proficiencies : List<String> = listOf("Heavy Armors", "Light Armors", "Weapons"),
    deck : ArrayList<Card> = arrayListOf(),
    currentPowers : List<Int> = List(SEELAH_POWER_LIST[currentSubclassId].size) {0}
) : BaseCharacter(
    databaseId = databaseId,
    characterId = SEELAH_KEY,
    characterName = characterName,
    subclassNames = listOf(SEELAH_PALADIN_NAME, SEELAH_INHERITORS_BLADE_NAME, SEELAH_WARDENSTONE_SENTRY_NAME),
    currentSubclassId = currentSubclassId,
    maxStrengthBonus = 4,
    currentStrengthBonus = currentStrengthBonus,
    maxDexterityBonus = 1,
    currentDexterityBonus = currentDexterityBonus,
    maxConstitutionBonus = 2,
    currentConstitutionBonus = currentConstitutionBonus,
    maxIntelligenceBonus = 1,
    currentIntelligenceBonus = currentIntelligenceBonus,
    maxWisdomBonus = 3,
    currentWisdomBonus = currentWisdomBonus,
    maxCharismaBonus = 4,
    currentCharismaBonus = currentCharismaBonus,
    maxHandSize = if (currentSubclassId == SEELAH_INHERITORS_BLADE_ID) 7 else 6,
    minHandSize = 4,
    currentHandSize = currentHandSize,
    maxWeapons = 6,
    minWeapons = 4,
    currentWeapons = currentWeapons,
    maxSpells = 3,
    minSpells = 1,
    currentSpells = currentSpells,
    maxArmors = 4,
    minArmors = 3,
    currentArmors = currentArmors,
    maxItems = 1,
    minItems = 1,
    currentItems = currentItems,
    maxAllies = 4,
    minAllies = 2,
    currentAllies = currentAllies,
    maxBlessings = 7,
    minBlessings = 4,
    currentBlessings = currentBlessings,
    proficiencies = proficiencies,
    deck = deck,
    characterPowers = SEELAH_POWER_LIST[currentSubclassId],
    currentPowers = currentPowers,
    characterSkills = listOf("Melee: Strength+3","Fortitude: Constitution +1", "Divine: Wisdom +1", "Diplomacy: Charisma +1"),
    characterDice = listOf("d8","d4","d8","d4","d8","d10")
)

object SeelahConstants{
    const val SEELAH_KEY = "seelah_key"
    const val SEELAH_PALADIN_ID = 0
    const val SEELAH_INHERITORS_BLADE_ID = 1
    const val SEELAH_WARDENSTONE_SENTRY_ID = 2
    const val SEELAH_PALADIN_NAME = "Paladin"
    const val SEELAH_INHERITORS_BLADE_NAME = "Inheritor's Blade"
    const val SEELAH_WARDENSTONE_SENTRY_NAME = "Wardenstone Sentry"
    val SEELAH_PALADIN_POWERS = listOf(
        listOf("When you attempt a check before you act, you may use your Charisma skill instead of any listed skill."),
        listOf("You may discard the top card of your deck to add 1d6 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card."),
        listOf("When you acquire a boon that has the Corrupted trait, bury it.")
    )
    val SEELAH_INHERITORS_BLADE_POWERS = listOf(
        listOf("When you attempt a check before you act, you may use your Charisma skill instead of any listed skill."),
        listOf("You may discard the top card of your deck to add 1d6 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 to any check by a character at your location. If the top card has the Heavy Armor or Sword trait, recharge it instead of discarding it.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location. If the top card has the Heavy Armor or Sword trait, recharge it instead of discarding it.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card. If the top card has the Heavy Armor or Sword trait, recharge it instead of discarding it."),
        listOf("When you acquire a boon that has the Corrupted trait, bury it.",
            "When you acquire a boon that has the Corrupted trait, bury it. If it does not have that trait, you may give it to a character at your location."),
        listOf("-",
            "You may be dealt 1 Combat damage to reduce Combat damage dealt to a character at your location by 1.",
            "You may be dealt 1 Combat damage to reduce Combat damage dealt to a character at your location by 2.",
            "You may be dealt 1 Combat damage to reduce Combat damage dealt to a character at your location by 3.",
            "You may be dealt 1 Combat damage to reduce any type of damage dealt to a character at your location by 1.",
            "You may be dealt 1 Combat damage to reduce any type of damage dealt to a character at your location by 2.",
            "You may be dealt 1 Combat damage to reduce any type of damage dealt to a character at your location by 3."),
        listOf("-","When you play a blessing that has the Iomedae trait, a character at your location may shuffle an ally in their discard pile into his deck.")
    )

    val SEELAH_WARDENSTONE_SENTRY_POWERS = listOf(
        listOf("When you attempt a check before you act, you may use your Charisma skill instead of any listed skill.",
            "When you attempt a check before you act, you may use your Charisma +2 skill instead of any listed skill.",
            "When you attempt a check before you act, you may use your Charisma +4 skill instead of any listed skill."),
        listOf("You may discard the top card of your deck to add 1d6 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 +2 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 +3 to any check by a character at your location.",
            "You may discard the top card of your deck to add 1d6 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 +1 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 +2 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card.",
            "You may discard the top card of your deck to add 1d6 +3 to any check by a character at your location. If that character defeats a monster on that check, he may draw a card."),
        listOf("When you acquire a boon that has the Corrupted trait, bury it.",
            "When you acquire a boon that has the Corrupted trait, bury it. If it is your turn, you may then explore again."),
        listOf("-",
            "You may add 1d8 and the Magic trait to your check to defeat a bane that has the Demon trait.",
            "You may add 1d8 and the Magic trait to your check to defeat a bane that has the Demon or Undead trait."),
        listOf("-",
            "When another character encounters a monster that has the Cultist or Demon trait, you may immediately move to his location.")
    )
    val SEELAH_POWER_LIST = listOf(SEELAH_PALADIN_POWERS, SEELAH_INHERITORS_BLADE_POWERS,
        SEELAH_WARDENSTONE_SENTRY_POWERS)
}