package com.example.android.pathfinderassistant

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.android.pathfinderassistant.characterdatabase.CharacterDatabase
import com.example.android.pathfinderassistant.characterdatabase.CharacterEntry
import com.example.android.pathfinderassistant.characters.BaseCharacter
import kotlinx.android.synthetic.main.activity_edit_character.*

class EditCharacterActivity : AppCompatActivity() {

    var character : BaseCharacter? = null
    var subclassSpinnerPosition : Int? = null
    var mDatabase : CharacterDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_character)

        //Get character
        character = intent.getParcelableExtra(Constants.CHARACTER_KEY)
        if (character == null) finish()

        title = "Editing ${character!!.characterName}"

        edit_name_et.setText(character!!.characterName) //Initialize EditText as current character name

        mDatabase = CharacterDatabase.getInstance(this)  //Get database

        assignSubclassSpinner()
        assignPrimaryStatSpinners()
        assignPowerSpinners()
        assignCardSpinners()
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

    //Helper method to assign the stat spinners for the six primary stats (Note: Not done as loop on purpose, for visibility/clarity purposes)
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

    //Helper method to assign card spinners (Note: Not done as loop on purpose, for visibility/clarity purposes)
    fun assignCardSpinners() {
        assignNumericSpinnerValues(spinner = edit_weapons_spinner, maxSize = character!!.maxWeapons, minSize = character!!.minWeapons, currentValueOfSpinner = character!!.currentWeapons)
        assignNumericSpinnerValues(spinner = edit_spells_spinner, maxSize = character!!.maxSpells, minSize = character!!.minSpells, currentValueOfSpinner = character!!.currentSpells)
        assignNumericSpinnerValues(spinner = edit_armors_spinner, maxSize = character!!.maxArmors, minSize = character!!.minArmors, currentValueOfSpinner = character!!.currentArmors)
        assignNumericSpinnerValues(spinner = edit_items_spinner, maxSize = character!!.maxItems, minSize = character!!.minItems, currentValueOfSpinner = character!!.currentItems)
        assignNumericSpinnerValues(spinner = edit_allies_spinner, maxSize = character!!.maxAllies, minSize = character!!.minAllies, currentValueOfSpinner = character!!.currentAllies)
        assignNumericSpinnerValues(spinner = edit_blessings_spinner, maxSize = character!!.maxBlessings, minSize = character!!.minBlessings, currentValueOfSpinner = character!!.currentBlessings)
    }

    //Helper method for saving character data as CharacterEntry (Note: Not done as loop on purpose, for visibility/clarity purposes)
    fun updateAndConvertCharacter() : CharacterEntry { //First, update character with the fields provided (subclass is updated on spinner change, and thus does not need to be altered)
        character!!.characterName = edit_name_et.text.toString()
        //Primary Stats
        character!!.currentStrengthBonus = edit_strength_spinner.selectedItem as Int
        character!!.currentDexterityBonus = edit_dexterity_spinner.selectedItem as Int
        character!!.currentConstitutionBonus = edit_constitution_spinner.selectedItem as Int
        character!!.currentIntelligenceBonus = edit_intelligence_spinner.selectedItem as Int
        character!!.currentWisdomBonus = edit_wisdom_spinner.selectedItem as Int
        character!!.currentCharismaBonus = edit_charisma_spinner.selectedItem as Int

        //Power Feats
        character!!.currentHandSize = edit_hand_size_spinner.selectedItem as Int
        //Loop to get each spinner from the container
        val newPowers = character!!.currentPowers.toMutableList() //Necessary as the currentPowers variable is not inherently mutable
        for (index in 0..(power_feats_container.childCount - 1)) {
            val spinner = power_feats_container.getChildAt(index) as Spinner
            newPowers.set(index, spinner.selectedItemPosition)
        }
        character!!.currentPowers = newPowers

        //Card Feats
        character!!.currentWeapons = edit_weapons_spinner.selectedItem as Int
        character!!.currentSpells = edit_spells_spinner.selectedItem as Int
        character!!.currentArmors = edit_armors_spinner.selectedItem as Int
        character!!.currentItems = edit_items_spinner.selectedItem as Int
        character!!.currentAllies = edit_allies_spinner.selectedItem as Int
        character!!.currentBlessings = edit_blessings_spinner.selectedItem as Int

        return CharacterEntry(character!!)
    }

    //Helper method for saving or updating character in database
    fun saveOrUpdateCharacter(characterEntry: CharacterEntry) {
        when (character!!.databaseId) {
            null -> AppExecutors.getInstance()!!.diskIO.execute {
                mDatabase!!.characterDao().insertCharacter(characterEntry)
            }
            else -> AppExecutors.getInstance()!!.diskIO.execute {
                mDatabase!!.characterDao().updateCharacter(characterEntry)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.character_edit_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_save_character -> {
                val characterEntry = updateAndConvertCharacter()
                saveOrUpdateCharacter(characterEntry)
                Toast.makeText(this, R.string.character_saved_confirmation, Toast.LENGTH_SHORT).show()
                return true //TODO finish activity?  To where?
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
