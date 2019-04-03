package com.example.android.pathfinderassistant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.android.pathfinderassistant.characters.BaseCharacter
import kotlinx.android.synthetic.main.activity_edit_character.*
import kotlin.math.max

class EditCharacterActivity : AppCompatActivity() {

    var character : BaseCharacter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_character)

        //Get character
        character = intent.getParcelableExtra(Constants.CHARACTER_KEY)
        if (character == null) finish()

        assignPrimaryStatSpinners()
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
    fun assignNumericSpinnerValues(spinner: Spinner, maxSize : Int, minSize : Int = 0, currentValueOfSpinner : Int = 0) {
        val numberList = (minSize..maxSize).toMutableList()
        val adapter : ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numberList)
        spinner.adapter = adapter
        val index = adapter.getPosition(currentValueOfSpinner)
        spinner.setSelection(index)
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
}
