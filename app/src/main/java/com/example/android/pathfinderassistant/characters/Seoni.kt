package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_CORRUPTOR_ID
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_CORRUPTOR_NAME
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_ELEMENTAL_MASTER_ID
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_ELEMENTAL_MASTER_NAME
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_KEY
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_POWER_LIST
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_SORCERESS_ID
import com.example.android.pathfinderassistant.characters.SeoniConstants.SEONI_SORCERESS_NAME
import com.example.android.pathfinderassistant.deck.Card

class Seoni(
    databaseId : Int? = null,
    characterName : String = "Seoni",
    currentSubclassId : Int = SEONI_SORCERESS_ID,
    currentStrengthBonus : Int = 0,
    currentDexterityBonus : Int = 0,
    currentConstitutionBonus : Int = 0,
    currentIntelligenceBonus : Int = 0,
    currentWisdomBonus : Int = 0,
    currentCharismaBonus : Int = 0,
    currentHandSize : Int = 6,
    currentWeapons : Int = 0,
    currentSpells : Int = 5,
    currentArmors : Int = 1,
    currentItems : Int = 2,
    currentAllies : Int = 3,
    currentBlessings : Int = 4,
    proficiencies : List<String> = if (currentSubclassId == SEONI_CORRUPTOR_ID) listOf("-", "Light Armors") else listOf(),
    deck : ArrayList<Card> = arrayListOf(),
    currentPowers : List<Int> = List(SEONI_POWER_LIST[currentSubclassId].size) {0}
) : BaseCharacter(
    databaseId = databaseId,
    characterId = SEONI_KEY,
    characterName = characterName,
    subclassNames = listOf(SEONI_SORCERESS_NAME, SEONI_ELEMENTAL_MASTER_NAME, SEONI_CORRUPTOR_NAME),
    currentSubclassId = currentSubclassId,
    maxStrengthBonus = 1,
    currentStrengthBonus = currentStrengthBonus,
    maxDexterityBonus = 2,
    currentDexterityBonus = currentDexterityBonus,
    maxConstitutionBonus = 2,
    currentConstitutionBonus = currentConstitutionBonus,
    maxIntelligenceBonus = 4,
    currentIntelligenceBonus = currentIntelligenceBonus,
    maxWisdomBonus = 2,
    currentWisdomBonus = currentWisdomBonus,
    maxCharismaBonus = 4,
    currentCharismaBonus = currentCharismaBonus,
    maxHandSize = if (currentSubclassId == SEONI_ELEMENTAL_MASTER_ID) 8 else 7,
    minHandSize = 6,
    currentHandSize = currentHandSize,
    maxWeapons = 1,
    minWeapons = 0,
    currentWeapons = currentWeapons,
    maxSpells = 7,
    minSpells = 5,
    currentSpells = currentSpells,
    maxArmors = 2,
    minArmors = 1,
    currentArmors = currentArmors,
    maxItems = 4,
    minItems = 2,
    currentItems = currentItems,
    maxAllies = 5,
    minAllies = 3,
    currentAllies = currentAllies,
    maxBlessings = 6,
    minBlessings = 4,
    currentBlessings = currentBlessings,
    proficiencies = proficiencies,
    deck = deck,
    characterPowers = SEONI_POWER_LIST[currentSubclassId],
    currentPowers = currentPowers,
    characterSkills = listOf("Knowledge: Intelligence +2", "Perception: Wisdom +2","Arcane: Charisma +2"),
    characterDice = listOf("d6","d4","d6","d8","d6","d12")
)

object SeoniConstants{
    const val SEONI_KEY = "seoni_key"
    const val SEONI_SORCERESS_ID = 0
    const val SEONI_ELEMENTAL_MASTER_ID = 1
    const val SEONI_CORRUPTOR_ID = 2
    const val SEONI_SORCERESS_NAME = "Sorceress"
    const val SEONI_ELEMENTAL_MASTER_NAME = "Elemental Master"
    const val SEONI_CORRUPTOR_NAME = "Corruptor"
    val SEONI_SORCERESS_POWERS = listOf(
        listOf("Before your combat check, you may discard a card to draw a card that has the Arcane trait from your discard pile.",
            "Before your combat check, you may discard a card to draw a card that has the Arcane or Magic trait from your discard pile."),
        listOf("You may automatically succeed at your check to recharge a spell that has the Attack trait.",
            "You may automatically succeed at your check to recharge a spell or an item that has the Attack trait."),
        listOf("When you acquire an ally, you may draw a card.",
            "When you acquire an ally or a spell, you may draw a card.")
    )
    val SEONI_ELEMENTAL_MASTER_POWERS = listOf(
        listOf("For your power feat, you may check any 1 of the traits below. That trait applies in any power that uses the word \"mastered.\""),
        listOf("-","Acid"),
        listOf("-","Cold"),
        listOf("-","Electricity"),
        listOf("-","Fire"),
        listOf("-","You may add 1 mastered trait to your check."),
        listOf("Before your combat check, you may discard a card to draw a card that has the Arcane or mastered trait from your discard pile.",
            "Before your combat check, you may discard a card to draw a card that has the Arcane or Magic or mastered trait from your discard pile."),
        listOf("You may automatically succeed at your check to recharge a spell that has the Attack or mastered trait.",
            "You may automatically succeed at your check to recharge a spell or an item that has the Attack or mastered trait."),
        listOf("When you acquire a card that has a mastered trait or an ally, you may draw a card.",
            "When you acquire a card that has a mastered trait or an ally or a spell, you may draw a card."),
        listOf("-","Add 4 to your check that has a mastered trait."),
        listOf("Reduce damage of a mastered type dealt to you by 2.",
            "Reduce damage of a mastered type dealt to you by 4.")
    )
    val SEONI_CORRUPTOR_POWERS = listOf(
        listOf("Before your combat check, you may discard a card to draw a card that has the Arcane trait from your discard pile.",
            "Before your combat check, you may discard a card to draw a card that has the Arcane or Magic trait from your discard pile.",
            "Before your combat check, you may discard a card to draw a card that has the Arcane or Corrupted trait from your discard pile.",
            "Before your combat check, you may discard a card to draw a card that has the Arcane, Magic, or Corrupted trait from your discard pile."),
        listOf("You may automatically succeed at your check to recharge a spell that has the Attack trait.",
            "You may automatically succeed at your check to recharge a spell or an item that has the Attack trait."),
        listOf("When you acquire an ally, you may draw a card.",
            "When you acquire an ally or a spell, you may draw a card.",
            "When you acquire an ally or a card that has the Corrupted trait, you may draw a card.",
            "When you acquire an ally, a spell, or a card that has the Corrupted trait, you may draw a card."),
        listOf("-",
            "You may treat a card in your hand that has the Corrupted trait as if it has the same powers as the top card in the blessings discard pile. This counts as playing a blessing.",
            "You may treat a card in your hand that has the Corrupted trait as if it has the same powers as any card in the blessings discard pile. This counts as playing a blessing."),
        listOf("-",
            "After the first exploration of your turn, you may examine the top card of your location deck.",
            "After the first exploration of your turn, you may examine the top card and bottom card of your location deck.",
            "After the first exploration of your turn, you may examine the top card of your location deck. You may encounter 1 such card that has the Arcane or Corrupted trait.",
            "After the first exploration of your turn, you may examine the top card and bottom card of your location deck. You may encounter 1 such card that has the Arcane or Corrupted trait.")
    )
    val SEONI_POWER_LIST = listOf(SEONI_SORCERESS_POWERS, SEONI_ELEMENTAL_MASTER_POWERS, SEONI_CORRUPTOR_POWERS)
}