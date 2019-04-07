package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_CLERIC_ID
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_CLERIC_NAME
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_DAWNFLOWERS_FLARE_NAME
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_EVERLIGHTS_GRACE_ID
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_EVERLIGHTS_GRACE_NAME
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_KEY
import com.example.android.pathfinderassistant.characters.KyraConstants.KYRA_POWER_LIST
import com.example.android.pathfinderassistant.deck.Card

class Kyra(
    databaseId : Int? = null,
    characterName : String = "Kyra",
    currentSubclassId : Int = KYRA_CLERIC_ID,
    currentStrengthBonus : Int = 0,
    currentDexterityBonus : Int = 0,
    currentConstitutionBonus : Int = 0,
    currentIntelligenceBonus : Int = 0,
    currentWisdomBonus : Int = 0,
    currentCharismaBonus : Int = 0,
    currentHandSize : Int = 5,
    currentWeapons : Int = 1,
    currentSpells : Int = 5,
    currentArmors : Int = 1,
    currentItems : Int = 1,
    currentAllies : Int = 2,
    currentBlessings : Int = 5,
    proficiencies : List<String> = listOf("Heavy Armors", "Light Armors"),
    deck : ArrayList<Card> = arrayListOf(),
    currentPowers : List<Int> = List(KYRA_POWER_LIST[currentSubclassId].size) {0}
) : BaseCharacter(
    databaseId = databaseId,
    characterId = KYRA_KEY,
    characterName = characterName,
    subclassNames = listOf(KYRA_CLERIC_NAME, KYRA_DAWNFLOWERS_FLARE_NAME, KYRA_EVERLIGHTS_GRACE_NAME),
    currentSubclassId = currentSubclassId,
    maxStrengthBonus = 1,
    currentStrengthBonus = currentStrengthBonus,
    maxDexterityBonus = 1,
    currentDexterityBonus = currentDexterityBonus,
    maxConstitutionBonus = 3,
    currentConstitutionBonus = currentConstitutionBonus,
    maxIntelligenceBonus = 2,
    currentIntelligenceBonus = currentIntelligenceBonus,
    maxWisdomBonus = 4,
    currentWisdomBonus = currentWisdomBonus,
    maxCharismaBonus = 4,
    currentCharismaBonus = currentCharismaBonus,
    maxHandSize = if (currentSubclassId == KYRA_EVERLIGHTS_GRACE_ID) 7 else 6,
    minHandSize = 5,
    currentHandSize = currentHandSize,
    maxWeapons = 2,
    minWeapons = 1,
    currentWeapons = currentWeapons,
    maxSpells = 7,
    minSpells = 5,
    currentSpells = currentSpells,
    maxArmors = 2,
    minArmors = 1,
    currentArmors = currentArmors,
    maxItems = 2,
    minItems = 1,
    currentItems = currentItems,
    maxAllies = 4,
    minAllies = 2,
    currentAllies = currentAllies,
    maxBlessings = 8,
    minBlessings = 5,
    currentBlessings = currentBlessings,
    proficiencies = proficiencies,
    deck = deck,
    characterPowers = KYRA_POWER_LIST[currentSubclassId],
    currentPowers = currentPowers,
    characterSkills = listOf("Knowledge: Intelligence +2", "Divine: Wisdom +2", "Diplomacy: Charisma +2"),
    characterDice = listOf("d6","d4","d6","d8","d12","d6")
)

object KyraConstants{
    const val KYRA_KEY = "kyra_key"
    const val KYRA_CLERIC_ID = 0
    const val KYRA_DAWNFLOWERS_FLARE_ID = 1
    const val KYRA_EVERLIGHTS_GRACE_ID = 2
    const val KYRA_CLERIC_NAME = "Cleric"
    const val KYRA_DAWNFLOWERS_FLARE_NAME = "Dawnflower's Flare"
    const val KYRA_EVERLIGHTS_GRACE_NAME = "Everlight's Grace"
    val KYRA_CLERIC_POWERS = listOf(
        listOf("-", "Proficient in: Weapons"),
        listOf("For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits."),
        listOf("When you use the above power or play a blessing that does not have the Corrupted trait on another character's check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check.",
            "When you use the above power or play a blessing that does not have the Corrupted trait on another character's or your check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check.")
    )
    val KYRA_DAWNFLOWERS_FLARE_POWERS = listOf(
        listOf("-", "Proficient in: Weapons"),
        listOf("For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell or blessing to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge or shuffle into your deck a spell or blessing to use your Divine skill + 2d8 and add the Attack, Divine, and Magic traits. You may add an additional 1d8 and the Fire trait."

        ),
        listOf("When you use the above power or play a blessing that does not have the Corrupted trait on another character's check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check.",
            "When you use the above power or play a blessing that does not have the Corrupted trait on another character's or your check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check."),
        listOf("-",
            "When you play a blessing on your check to defeat a bane that has the Demon or Undead trait, you may recharge that blessing."),
        listOf("-",
            "Add 1d4 to your check to recharge a card that has the Attack trait.",
            "Add 1d4 +2 to your check to recharge a card that has the Attack trait."),
        listOf("-",
            "When another character plays a Blessing of Sarenrae on your check, that character may recharge it.",
            "When another character plays a Blessing of Sarenrae on your check, that character may recharge it and a random card from her discard pile.")
    )
    val KYRA_EVERLIGHTS_GRACE_POWERS = listOf(
        listOf("-", "Proficient in: Weapons"),
        listOf("For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 1d8 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell to use your Divine skill + 2d6 and add the Attack, Divine, and Magic traits.",
            "For your check to defeat a bane that has the Demon or Undead trait, you may recharge a spell or blessing to use your Divine skill + 2d6 and add the Attack, Divine, and Magic traits."),
        listOf("When you use the above power or play a blessing that does not have the Corrupted trait on another character's check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check.",
            "When you use the above power or play a blessing that does not have the Corrupted trait on another character's or your check to defeat, a character at your location may shuffle 1 random card from his discard pile into his deck after the check.",
            "When you use the above power or play a blessing that does not have the Corrupted trait on another character's check to defeat, a character at your location may shuffle 1 random card of a type of your choice from his discard pile into his deck after the check.",
            "When you use the above power or play a blessing that does not have the Corrupted trait on another character's or your check to defeat, a character at your location may shuffle 1 random card of a type of your choice from his discard pile into his deck after the check."),
        listOf("-",
            "When you play a boon that has the Healing trait on a character, any armors that would be shuffled into that character's deck may be put into that character's hand instead.",
            "When you play a boon that has the Healing trait on a character, any armors or allies that would be shuffled into that character's deck may be put into that character's hand instead.",
            "When you play a boon that has the Healing trait on a character, any armors that would be shuffled into that character's deck may be put into that character's hand instead. Then you may recharge the boon.",
            "When you play a boon that has the Healing trait on a character, any armors or allies that would be shuffled into that character's deck may be put into that character's hand instead. Then you may recharge the boon."),
        listOf("When you would bury an armor for its power, that character may discard it instead.",
            "When you or a character at your location would bury an armor for its power, that character may discard it instead.")
    )
    val KYRA_POWER_LIST = listOf(KYRA_CLERIC_POWERS, KYRA_DAWNFLOWERS_FLARE_POWERS, KYRA_EVERLIGHTS_GRACE_POWERS)
}