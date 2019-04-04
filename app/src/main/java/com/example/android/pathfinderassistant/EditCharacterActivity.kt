package com.example.android.pathfinderassistant

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.android.pathfinderassistant.characters.BaseCharacter
import kotlinx.android.synthetic.main.activity_edit_character.*

class EditCharacterActivity : AppCompatActivity() {

    var character : BaseCharacter? = null
    var subclassSpinnerPosition : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_character)

        //Get character
        character = intent.getParcelableExtra(Constants.CHARACTER_KEY)
        if (character == null) finish()

        title = "Editing ${character!!.characterName}"

        edit_name_et.setText(character!!.characterName) //Initialize EditText as current character name

        assignSubclassSpinner()
        assignPrimaryStatSpinners()
        assignPowerSpinners()
        assignCardSpinners()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //Helper function to assign numeric spinners
    fun assignNumericSpinnerValues(spinner: Spinner, maxSize : Int, currentValueOfSpinner : Int, minSize : Int = 0) {
        val numberList = (minSize..maxSize).toMutableList()
        val adapter : ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numberList)
        spinner.adapter = adapter
        val index = adapter.getPosition(currentValueOfSpinner)
        spinner.setSelection(index)
    }

    //Helper method to assign Subclass spinner
    fun assignSubclassSpinner() {
        val adapter :ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, character!!.subclassNames)
        edit_subclass_spinner.adapter = adapter
        edit_subclass_spinner.setSelection(character!!.currentSubclassId) //Set selection via subclass ID
        edit_subclass_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (subclassSpinnerPosition == null) {  //Should only occur when activity begins and this is initially called
                    subclassSpinnerPosition = position
                }
                if (position != subclassSpinnerPosition) { //Only needs to execute if the position of the spinner has changed
                    subclassSpinnerPosition = position
                    character!!.changeSubclass(position)  //Called to update the character's values to reflect the subclass change
                    assignPowerSpinners()  //As powers change when the subclass updates, must be called to repopulate the views accurately
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    //Helper method to assign the stat spinners for the six primary stats
    fun assignPrimaryStatSpinners() {
        assignNumericSpinnerValues(spinner = edit_strength_spinner, maxSize = character!!.maxStrengthBonus, currentValueOfSpinner = character!!.currentStrengthBonus)
        assignNumericSpinnerValues(spinner = edit_dexterity_spinner, maxSize = character!!.maxDexterityBonus, currentValueOfSpinner = character!!.currentDexterityBonus)
        assignNumericSpinnerValues(spinner = edit_constitution_spinner, maxSize = character!!.maxConstitutionBonus, currentValueOfSpinner = character!!.currentConstitutionBonus)
        assignNumericSpinnerValues(spinner = edit_intelligence_spinner, maxSize = character!!.maxIntelligenceBonus, currentValueOfSpinner = character!!.currentIntelligenceBonus)
        assignNumericSpinnerValues(spinner = edit_wisdom_spinner, maxSize = character!!.maxWisdomBonus, currentValueOfSpinner = character!!.currentWisdomBonus)
        assignNumericSpinnerValues(spinner = edit_charisma_spinner, maxSize = character!!.maxCharismaBonus, currentValueOfSpinner = character!!.currentCharismaBonus)
    }

    //Helper method to assign power spinners
    fun assignPowerSpinners() {
        //Hand size (only constant amongst characters, other powers all vary)
        assignNumericSpinnerValues(spinner = edit_hand_size_spinner, maxSize = character!!.maxHandSize, minSize = character!!.minHandSize, currentValueOfSpinner = character!!.currentHandSize)
        //Clear LayoutContainer and programmatically inflate spinners for available powers, cross-referenced with the currentPowers variable
        power_feats_container.removeAllViews()
        for ((index, value) in character!!.characterPowers.withIndex()) { //Create values for each power in CharacterPowers
            val spinner = Spinner(this, Spinner.MODE_DIALOG)
            spinner.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT) //(Width, Height)
            val paddingLeftAndTop : Int = (8 * resources.displayMetrics.density + 0.5f).toInt() //To add reasonable spacing
            val paddingRight : Int = (32 * resources.displayMetrics.density + 0.5f).toInt() //To prevent overlap with arrow
            spinner.setPadding( paddingLeftAndTop, paddingLeftAndTop, paddingRight,0)
            val adapter : ArrayAdapter<String> = ArrayAdapter(this, R.layout.spinner_selection_multiline, value) //Populate the spinner using a custom TextView
            spinner.adapter = adapter
            spinner.setSelection(character!!.currentPowers[index]) //Find the current selection for each power by cross-referencing with the secondary list
            power_feats_container.addView(spinner)
        }
    }

    //Helper method to assign card spinners
    fun assignCardSpinners() {
        assignNumericSpinnerValues(spinner = edit_weapons_spinner, maxSize = character!!.maxWeapons, minSize = character!!.minWeapons, currentValueOfSpinner = character!!.currentWeapons)
        assignNumericSpinnerValues(spinner = edit_spells_spinner, maxSize = character!!.maxSpells, minSize = character!!.minSpells, currentValueOfSpinner = character!!.currentSpells)
        assignNumericSpinnerValues(spinner = edit_armors_spinner, maxSize = character!!.maxArmors, minSize = character!!.minArmors, currentValueOfSpinner = character!!.currentArmors)
        assignNumericSpinnerValues(spinner = edit_items_spinner, maxSize = character!!.maxItems, minSize = character!!.minItems, currentValueOfSpinner = character!!.currentItems)
        assignNumericSpinnerValues(spinner = edit_allies_spinner, maxSize = character!!.maxAllies, minSize = character!!.minAllies, currentValueOfSpinner = character!!.currentAllies)
        assignNumericSpinnerValues(spinner = edit_blessings_spinner, maxSize = character!!.maxBlessings, minSize = character!!.minBlessings, currentValueOfSpinner = character!!.currentBlessings)
    }
}
