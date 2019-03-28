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
}
