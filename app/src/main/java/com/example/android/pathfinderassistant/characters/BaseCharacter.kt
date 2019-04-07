package com.example.android.pathfinderassistant.characters

import android.os.Parcelable
import com.example.android.pathfinderassistant.deck.Card
import kotlinx.android.parcel.Parcelize

//A standard character to use as a parent for each derivative character
@Parcelize
open class BaseCharacter(
    val databaseId: Int?,
    val characterId: String,
    var characterName: String,
    val subclassNames: List<String>,
    var currentSubclassId: Int,
    val maxStrengthBonus: Int,
    var currentStrengthBonus: Int,
    val maxDexterityBonus: Int,
    var currentDexterityBonus: Int,
    val maxConstitutionBonus: Int,
    var currentConstitutionBonus: Int,
    val maxIntelligenceBonus: Int,
    var currentIntelligenceBonus: Int,
    val maxWisdomBonus: Int,
    var currentWisdomBonus: Int,
    val maxCharismaBonus: Int,
    var currentCharismaBonus: Int,
    var maxHandSize: Int,
    val minHandSize: Int,
    var currentHandSize: Int,
    val maxWeapons: Int,
    val minWeapons: Int,
    var currentWeapons: Int,
    val maxSpells: Int,
    val minSpells: Int,
    var currentSpells: Int,
    val maxArmors: Int,
    val minArmors: Int,
    var currentArmors: Int,
    val maxItems: Int,
    val minItems: Int,
    var currentItems: Int,
    val maxAllies: Int,
    val minAllies: Int,
    var currentAllies: Int,
    val maxBlessings: Int,
    val minBlessings: Int,
    var currentBlessings: Int,
    var proficiencies: List<String>,
    var deck: ArrayList<Card>,
    var characterPowers: List<List<String>>,
    var currentPowers: List<Int>,
    val characterSkills: List<String>,
    val characterDice: List<String> //Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma in that order
) : Parcelable {

    //Dummy BaseCharacter
    constructor() : this(null,"","",listOf(""),0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
        listOf(""), arrayListOf<Card>(), listOf(listOf("")), listOf(0), listOf(""), listOf(""))

    //For altering the stats accordingly when the subclass of a class is changed
    fun changeSubclass(subclassNumber: Int) {
        when (characterId) {
            SeoniConstants.SEONI_KEY -> {
                when (subclassNumber) {
                    SeoniConstants.SEONI_SORCERESS_ID -> {
                        currentSubclassId = SeoniConstants.SEONI_SORCERESS_ID
                        maxHandSize = 7
                        characterPowers = SeoniConstants.SEONI_SORCERESS_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    SeoniConstants.SEONI_ELEMENTAL_MASTER_ID -> {
                        currentSubclassId = SeoniConstants.SEONI_ELEMENTAL_MASTER_ID
                        maxHandSize = 8
                        characterPowers = SeoniConstants.SEONI_ELEMENTAL_MASTER_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    SeoniConstants.SEONI_CORRUPTOR_ID -> {
                        currentSubclassId = SeoniConstants.SEONI_CORRUPTOR_ID
                        maxHandSize = 7
                        characterPowers = SeoniConstants.SEONI_CORRUPTOR_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    else -> return
                }
            }
            ImrijkaConstants.IMRIJKA_KEY -> {
                when (subclassNumber) {
                    ImrijkaConstants.IMRIJKA_INQUISITOR_ID -> {
                        currentSubclassId = ImrijkaConstants.IMRIJKA_INQUISITOR_ID
                        maxHandSize = 6
                        characterPowers = ImrijkaConstants.IMRIJKA_INQUISITOR_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    ImrijkaConstants.IMRIJKA_WANDERING_JUDGE_ID -> {
                        currentSubclassId = ImrijkaConstants.IMRIJKA_WANDERING_JUDGE_ID
                        maxHandSize = 7
                        characterPowers = ImrijkaConstants.IMRIJKA_WANDERING_JUDGE_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    ImrijkaConstants.IMRIJKA_COLD_IRON_WARDEN_ID -> {
                        currentSubclassId = ImrijkaConstants.IMRIJKA_COLD_IRON_WARDEN_ID
                        maxHandSize = 7
                        characterPowers = ImrijkaConstants.IMRIJKA_COLD_IRON_WARDEN_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    else -> return
                }
            }
            SeelahConstants.SEELAH_KEY -> {
                when (subclassNumber) {
                    SeelahConstants.SEELAH_PALADIN_ID -> {
                        currentSubclassId = SeelahConstants.SEELAH_PALADIN_ID
                        maxHandSize = 6
                        characterPowers = SeelahConstants.SEELAH_PALADIN_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    SeelahConstants.SEELAH_INHERITORS_BLADE_ID -> {
                        currentSubclassId = SeelahConstants.SEELAH_INHERITORS_BLADE_ID
                        maxHandSize = 7
                        characterPowers = SeelahConstants.SEELAH_INHERITORS_BLADE_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    SeelahConstants.SEELAH_WARDENSTONE_SENTRY_ID -> {
                        currentSubclassId = SeelahConstants.SEELAH_WARDENSTONE_SENTRY_ID
                        maxHandSize = 6
                        characterPowers = SeelahConstants.SEELAH_WARDENSTONE_SENTRY_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    else -> return
                }
            }
            KyraConstants.KYRA_KEY -> {
                when (subclassNumber) {
                    KyraConstants.KYRA_CLERIC_ID -> {
                        currentSubclassId = KyraConstants.KYRA_CLERIC_ID
                        maxHandSize = 6
                        characterPowers = KyraConstants.KYRA_CLERIC_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    KyraConstants.KYRA_DAWNFLOWERS_FLARE_ID -> {
                        currentSubclassId = KyraConstants.KYRA_DAWNFLOWERS_FLARE_ID
                        maxHandSize = 6
                        characterPowers = KyraConstants.KYRA_DAWNFLOWERS_FLARE_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    KyraConstants.KYRA_EVERLIGHTS_GRACE_ID -> {
                        currentSubclassId = KyraConstants.KYRA_EVERLIGHTS_GRACE_ID
                        maxHandSize = 7
                        characterPowers = KyraConstants.KYRA_EVERLIGHTS_GRACE_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    else -> return
                }
            }
            EnoraConstants.ENORA_KEY -> {
                when (subclassNumber) {
                    EnoraConstants.ENORA_ARCANIST_ID -> {
                        currentSubclassId = EnoraConstants.ENORA_ARCANIST_ID
                        maxHandSize = 7
                        characterPowers = EnoraConstants.ENORA_ARCANIST_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    EnoraConstants.ENORA_ELDRITCH_SAVANT_ID -> {
                        currentSubclassId = EnoraConstants.ENORA_ELDRITCH_SAVANT_ID
                        maxHandSize = 9
                        characterPowers = EnoraConstants.ENORA_ELDRITCH_SAVANT_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    EnoraConstants.ENORA_OCCULARIUM_SCHOLAR_ID -> {
                        currentSubclassId = EnoraConstants.ENORA_OCCULARIUM_SCHOLAR_ID
                        maxHandSize = 8
                        characterPowers = EnoraConstants.ENORA_OCCULARIUM_SCHOLAR_POWERS
                        currentPowers = List(characterPowers.size) { 0 }
                    }
                    else -> return
                }
            }
        }
    }
}

