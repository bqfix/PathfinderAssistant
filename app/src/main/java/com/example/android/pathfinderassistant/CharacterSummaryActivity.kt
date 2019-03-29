package com.example.android.pathfinderassistant

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.characters.Seoni
import com.example.android.pathfinderassistant.deck.Card
import com.example.android.pathfinderassistant.deck.CardListActivity
import kotlinx.android.synthetic.main.activity_character_summary.*

val DECK_KEY = "deck"

class CharacterSummaryActivity : AppCompatActivity() {

    //TODO The character should be provided programmatically from a parent activity
    val character : BaseCharacter = Seoni()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_summary)

        character.deck =  arrayListOf(
            Card(
                getString(R.string.dazzle_name),
                getString(R.string.dazzle_descrip)
            ),
            Card(
                getString(R.string.frigid_blast_name),
                getString(R.string.frigid_blast_descrip)
            ),
            Card(
                getString(R.string.fiery_glare_name),
                getString(R.string.fiery_glare_descrip)
            ),
            Card(
                getString(R.string.lightning_touch_name),
                getString(R.string.lightning_touch_descrip)
            ),
            Card(
                getString(R.string.sagacity_name),
                getString(R.string.sagacity_descrip)
            ),
            Card(
                getString(R.string.magic_padded_armor_name),
                getString(R.string.magic_padded_armor_descrip)
            ),
            Card(
                getString(R.string.sages_journal_name),
                getString(R.string.sages_journal_descrip)
            ),
            Card(
                getString(R.string.wand_of_paralyze_name),
                getString(R.string.wand_of_paralyze_descrip)
            ),
            Card(
                getString(R.string.frog_name),
                getString(R.string.frog_descrip)
            ),
            Card(
                getString(R.string.teamster_name),
                getString(R.string.teamster_descrip)
            ),
            Card(
                getString(R.string.apprentice_name),
                getString(R.string.apprentice_descrip)
            ),
            Card(
                getString(R.string.blessing_of_ascension_name),
                getString(R.string.blessing_of_ascension_descrip)
            ),
            Card(
                getString(R.string.blessing_of_shax_name),
                getString(R.string.blessing_of_shax_descrip)
            )
        ) //TODO To be removed

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
                intent.putParcelableArrayListExtra(DECK_KEY, character.deck)
                startActivity(intent)
                return true
            }
            R.id.action_launch_dice -> {
                val intent = Intent(this, DiceActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun populateViews() {
        //Set Main Skills section
        val strengthString = "Strength: ${character.characterDice[0]} +${character.currentStrengthBonus}"
        val dexterityString = "Dexterity: ${character.characterDice[1]} +${character.currentDexterityBonus}"
        val constitutionString = "Constitution: ${character.characterDice[2]} +${character.currentConstitutionBonus}"
        val intelligenceString = "Intelligence: ${character.characterDice[3]} +${character.currentIntelligenceBonus}"
        val wisdomString = "Wisdom: ${character.characterDice[4]} +${character.currentWisdomBonus}"
        val charismaString = "Charisma: ${character.characterDice[5]} +${character.currentCharismaBonus}"
        strength_tv.setText(strengthString)
        dexterity_tv.setText(dexterityString)
        constitution_tv.setText(constitutionString)
        intelligence_tv.setText(intelligenceString)
        wisdom_tv.setText(wisdomString)
        charisma_tv.setText(charismaString)

        //Set extra Skills
        val skillsString = character.characterSkills.joinToString("\n")
        skills_tv.setText(skillsString)

        //Set Powers section
        var powersString :String = ""
        for ((index, powerOptions) in character.characterPowers.withIndex()) { //Check the list of all characterPowers against the indexes provided in the currentPowers list
            powersString = powersString.plus("${powerOptions[character.currentPowers[index]]}\n\n")
        }
        powers_tv.setText(powersString)

        //Set Cards section
        val weaponsString = "Weapons: ${character.currentWeapons}"
        val spellsString = "Spells: ${character.currentSpells}"
        val armorsString = "Armors: ${character.currentArmors}"
        val itemsString = "Items: ${character.currentItems}"
        val alliesString = "Allies: ${character.currentAllies}"
        val blessingsString = "Blessings: ${character.currentBlessings}"
        weapons_tv.setText(weaponsString)
        spells_tv.setText(spellsString)
        armors_tv.setText(armorsString)
        items_tv.setText(itemsString)
        allies_tv.setText(alliesString)
        blessings_tv.setText(blessingsString)
    }
}
