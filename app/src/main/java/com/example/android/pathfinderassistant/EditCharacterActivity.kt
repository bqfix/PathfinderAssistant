package com.example.android.pathfinderassistant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.android.pathfinderassistant.characters.BaseCharacter

class EditCharacterActivity : AppCompatActivity() {

    var character : BaseCharacter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_character)

        //Get character
        character = intent.getParcelableExtra(Constants.CHARACTER_KEY)
        if (character == null) finish()

        //TODO Test Toast
        Toast.makeText(this, character!!.characterName, Toast.LENGTH_LONG).show()
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
}
