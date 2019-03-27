package com.example.android.pathfinderassistant.characters

import com.example.android.pathfinderassistant.deck.Card

//A standard character to use as a parent for each derivative character
abstract class BaseCharacter(
    val characterName: String,
    val subclassNames: List<String>,
    private val currentSubclassId: Int,
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
    var currentHandSize: Int,
    val maxWeapons: Int,
    val minWeapons: Int,
    var currentWeapons: Int,
    val maxSpells : Int,
    val minSpells: Int,
    var currentSpells: Int,
    val maxArmors : Int,
    val minArmors: Int,
    var currentArmors: Int,
    val maxItems : Int,
    val minItems: Int,
    var currentItems: Int,
    val maxAllies : Int,
    val minAllies: Int,
    var currentAllies: Int,
    val maxBlessings : Int,
    val minBlessings: Int,
    var currentBlessings: Int,
    var proficiencies: List<String>,
    var deck : ArrayList<Card>
    ) {

    //A class that should implement UI changes and variable changes when subclassName is changed
    abstract fun changeSubclass(subclassNumber : Int)
}