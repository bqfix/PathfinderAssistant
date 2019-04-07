package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_COLD_IRON_WARDEN_NAME
import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_INQUISITOR_ID
import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_INQUISITOR_NAME
import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_KEY
import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_POWER_LIST
import com.example.android.pathfinderassistant.characters.ImrijkaConstants.IMRIJKA_WANDERING_JUDGE_NAME
import com.example.android.pathfinderassistant.deck.Card

class Imrijka(
    databaseId : Int? = null,
    characterName : String = "Imrijka",
    currentSubclassId : Int = IMRIJKA_INQUISITOR_ID,
    currentStrengthBonus : Int = 0,
    currentDexterityBonus : Int = 0,
    currentConstitutionBonus : Int = 0,
    currentIntelligenceBonus : Int = 0,
    currentWisdomBonus : Int = 0,
    currentCharismaBonus : Int = 0,
    currentHandSize : Int = 5,
    currentWeapons : Int = 5,
    currentSpells : Int = 1,
    currentArmors : Int = 1,
    currentItems : Int = 2,
    currentAllies : Int = 1,
    currentBlessings : Int = 5,
    proficiencies : List<String> = listOf("Light Armors", "Weapons"),
    deck : ArrayList<Card> = arrayListOf(),
    currentPowers : List<Int> = List(IMRIJKA_POWER_LIST[currentSubclassId].size) {0}
) : BaseCharacter(
    databaseId = databaseId,
    characterId = IMRIJKA_KEY,
    characterName = characterName,
    subclassNames = listOf(IMRIJKA_INQUISITOR_NAME, IMRIJKA_WANDERING_JUDGE_NAME, IMRIJKA_COLD_IRON_WARDEN_NAME),
    currentSubclassId = currentSubclassId,
    maxStrengthBonus = 4,
    currentStrengthBonus = currentStrengthBonus,
    maxDexterityBonus = 3,
    currentDexterityBonus = currentDexterityBonus,
    maxConstitutionBonus = 2,
    currentConstitutionBonus = currentConstitutionBonus,
    maxIntelligenceBonus = 1,
    currentIntelligenceBonus = currentIntelligenceBonus,
    maxWisdomBonus = 4,
    currentWisdomBonus = currentWisdomBonus,
    maxCharismaBonus = 1,
    currentCharismaBonus = currentCharismaBonus,
    maxHandSize = if (currentSubclassId == IMRIJKA_INQUISITOR_ID) 6 else 7, //If base class, only 6. else 7
    minHandSize = 5,
    currentHandSize = currentHandSize,
    maxWeapons = 7,
    minWeapons = 5,
    currentWeapons = currentWeapons,
    maxSpells = 3,
    minSpells = 1,
    currentSpells = currentSpells,
    maxArmors = 2,
    minArmors = 1,
    currentArmors = currentArmors,
    maxItems = 3,
    minItems = 2,
    currentItems = currentItems,
    maxAllies = 2,
    minAllies = 1,
    currentAllies = currentAllies,
    maxBlessings = 8,
    minBlessings = 5,
    currentBlessings = currentBlessings,
    proficiencies = proficiencies,
    deck = deck,
    characterPowers = IMRIJKA_POWER_LIST[currentSubclassId],
    currentPowers = currentPowers,
    characterSkills = listOf("Ranged: Strength+1","Knowledge: Wisdom +2", "Divine: Wisdom +1"),
    characterDice = listOf("d10","d8","d6","d4","d8","d6")
)

object ImrijkaConstants{
    const val IMRIJKA_KEY = "imrijka_key"
    const val IMRIJKA_INQUISITOR_ID = 0
    const val IMRIJKA_WANDERING_JUDGE_ID = 1
    const val IMRIJKA_COLD_IRON_WARDEN_ID = 2
    const val IMRIJKA_INQUISITOR_NAME = "Inquisitor"
    const val IMRIJKA_WANDERING_JUDGE_NAME = "Wandering Judge"
    const val IMRIJKA_COLD_IRON_WARDEN_NAME = "Cold Iron Warden"
    val IMRIJKA_INQUISITOR_POWERS = listOf(
        listOf("-",
            "You gain the skill Perception: Wisdom +2."),
        listOf("You may recharge a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster.",
            "You may recharge or reveal a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster."),
        listOf("When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location.")
    )
    val IMRIJKA_WANDERING_JUDGE_POWERS = listOf(
        listOf("-",
            "You gain the skill Perception: Wisdom +2."),
        listOf("You may recharge a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster.",
            "You may recharge or reveal a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster."),
        listOf("When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location and before you explore, you may draw a card.",
            "When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location.  Add 1d4 to your checks during this exploration.",
            "When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location and before you explore, you may draw a card.  Add 1d4 to your checks during this exploration.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location and before you explore, you may draw a card.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location.  Add 1d4 to your checks during this exploration.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location and before you explore, you may draw a card.  Add 1d4 to your checks during this exploration."

        ),
        listOf("-","Recharge a card that has the Ranged or Divine trait to add 1d4 to a combat check at another location.",
            "Recharge a card that has the Ranged or Divine trait to add 1d4 +1 to a combat check at another location.",
            "Recharge a card that has the Ranged or Divine trait to add 1d4 +2 to a combat check at another location."),
        listOf("-",
            "When you play a non-Basic blessing that matches the top card of the blessings discard pile, you may shuffle the top card of the blessings discard pile into the blessings deck."),
        listOf("-",
            "Add 2 to your check to acquire an ally or blessing.")
    )
    val IMRIJKA_COLD_IRON_WARDEN_POWERS = listOf(
        listOf("-",
        "You gain the skill Perception: Wisdom +2."),
        listOf("You may recharge a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster.",
            "You may recharge or reveal a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster.",
            "You may recharge a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster. If the monster has the Cultist trait, add another 1d8.",
            "You may recharge or reveal a card that has the Divine or Ranged trait to add 1d4 and the Divine and Magic traits to your check against a monster. If the monster has the Cultist trait, add another 1d8."),
        listOf("When you defeat a monster on your turn, you may roll d6; on a 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may roll d6; on a 3, 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may examine the top card of your location deck, and if it is not a monster, put it on the bottom of location deck, then, you may roll d6; on a 4, 5, or 6, explore your location.",
            "When you defeat a monster on your turn, you may examine the top card of your location deck, and if it is not a monster, put it on the bottom of location deck, then, you may roll d6; on a 3, 4, 5, or 6, explore your location."),
        listOf("-",
            "When you attempt a Diplomacy check, you may use your Strength skill instead of your Diplomacy skill."),
        listOf("-",
            "When you play a blessing that has the Basic trait on any check to defeat a bane, you may recharge it instead of discarding it.",
            "When you play a blessing that has the Basic trait on any check to defeat a bane, you may recharge it or put it on top of your deck instead of discarding it."),
        listOf("-",
            "You may evade a barrier you encounter.",
            "You may evade a barrier you encounter and you may put it on the bottom of its location deck.")
    )
    val IMRIJKA_POWER_LIST = listOf(IMRIJKA_INQUISITOR_POWERS, IMRIJKA_WANDERING_JUDGE_POWERS, IMRIJKA_COLD_IRON_WARDEN_POWERS)
}