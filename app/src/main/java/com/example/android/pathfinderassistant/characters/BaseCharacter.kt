package com.example.android.pathfinderassistant.characters

import android.os.Parcelable
import com.example.android.pathfinderassistant.Constants
import com.example.android.pathfinderassistant.deck.Card
import kotlinx.android.parcel.Parcelize

//A standard character to use as a parent for each derivative character
@Parcelize
open class BaseCharacter(
    val databaseId : Int?,
    val characterId : String,
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
    var deck : ArrayList<Card>,
    var characterPowers : List<List<String>>,
    var currentPowers : List<Int>,
    val characterSkills : List<String>,
    val characterDice : List<String> //Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma in that order
    ) : Parcelable {

    //A class that should implement UI changes and variable changes when subclassName is changed
    open fun changeSubclass(subclassNumber : Int) {}
}

