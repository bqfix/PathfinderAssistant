package com.example.android.pathfinderassistant

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.android.pathfinderassistant.Constants.CHARACTER_KEY
import com.example.android.pathfinderassistant.Constants.DECK_ID_KEY
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.deck.CardListActivity
import kotlinx.android.synthetic.main.activity_character_summary.*

class CharacterSummaryActivity : AppCompatActivity() {

    var character: BaseCharacter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_summary)

        //Get character
        character = intent.getParcelableExtra(CHARACTER_KEY)
        if (character == null) finish()

        title = character!!.characterName

        populateViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.character_summary_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_launch_card -> {
                val intent = Intent(this, CardListActivity::class.java)
                intent.putExtra(DECK_ID_KEY, character!!.databaseId) //Pass the character's database ID to be cross-referenced later
                startActivity(intent)
                return true
            }
            R.id.action_launch_dice -> {
                val intent = Intent(this, DiceActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_launch_edit -> {
                val intent = Intent(this, EditCharacterActivity::class.java)
                intent.putExtra(CHARACTER_KEY, character)
                startActivity(intent)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun populateViews() {
        //Set Main Skills section
        val strengthString = "Strength: ${character!!.characterDice[0]} +${character!!.currentStrengthBonus}"
        val dexterityString = "Dexterity: ${character!!.characterDice[1]} +${character!!.currentDexterityBonus}"
        val constitutionString =
            "Constitution: ${character!!.characterDice[2]} +${character!!.currentConstitutionBonus}"
        val intelligenceString =
            "Intelligence: ${character!!.characterDice[3]} +${character!!.currentIntelligenceBonus}"
        val wisdomString = "Wisdom: ${character!!.characterDice[4]} +${character!!.currentWisdomBonus}"
        val charismaString = "Charisma: ${character!!.characterDice[5]} +${character!!.currentCharismaBonus}"
        strength_tv.setText(strengthString)
        dexterity_tv.setText(dexterityString)
        constitution_tv.setText(constitutionString)
        intelligence_tv.setText(intelligenceString)
        wisdom_tv.setText(wisdomString)
        charisma_tv.setText(charismaString)

        //Set extra Skills
        val skillsString = character!!.characterSkills.joinToString("\n")
        skills_tv.setText(skillsString)

        //Set Powers section
        var powersString = "Hand Size: ${character!!.currentHandSize}\n\n" //Add Hand Size
        val proficiencies = character!!.proficiencies //Add proficiencies
        if (!(proficiencies.isEmpty())) {
            powersString = powersString.plus("Proficient in: ")
            for ((index, proficiencyString) in proficiencies.withIndex()) { //Add proficiencies one by one, add space after last proficiency
                if (index < (proficiencies.size - 1)) {
                    powersString = powersString.plus("$proficiencyString, ")
                } else {
                    powersString = powersString.plus("$proficiencyString\n\n")
                }
            }
        }
        val characterPowers = character!!.characterPowers
        for ((index, powerOptions) in characterPowers.withIndex()) { //Check the list of all characterPowers against the indexes provided in the currentPowers list
            val power = powerOptions[character!!.currentPowers[index]] //Get the current power
            if (!(power.equals("-"))) { //Skip blank powers
                if (index < (characterPowers.size - 1)) {
                    powersString = powersString.plus("$power\n\n")
                } else {
                    powersString = powersString.plus(powerOptions[character!!.currentPowers[index]]) //Final power to be added does not need extra lines beneath
                }
            }
        }
        powers_tv.setText(powersString)

        //Set Cards section
        val weaponsString = "Weapons: ${character!!.currentWeapons}"
        val spellsString = "Spells: ${character!!.currentSpells}"
        val armorsString = "Armors: ${character!!.currentArmors}"
        val itemsString = "Items: ${character!!.currentItems}"
        val alliesString = "Allies: ${character!!.currentAllies}"
        val blessingsString = "Blessings: ${character!!.currentBlessings}"
        weapons_tv.setText(weaponsString)
        spells_tv.setText(spellsString)
        armors_tv.setText(armorsString)
        items_tv.setText(itemsString)
        allies_tv.setText(alliesString)
        blessings_tv.setText(blessingsString)
    }
}
