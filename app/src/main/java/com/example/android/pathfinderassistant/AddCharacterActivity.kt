package com.example.android.pathfinderassistant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.characters.Seoni
import kotlinx.android.synthetic.main.activity_add_character.*

class AddCharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_character)

        //Set each character option to launch EditCharacterActivity with a new instance of that character
        seoni_selection_tv.setOnClickListener { launchEditActivity(Seoni()) }
    }

    fun launchEditActivity(character : BaseCharacter) {
        val intent = Intent(this, EditCharacterActivity::class.java)
        intent.putExtra(Constants.CHARACTER_KEY, character)
        startActivity(intent)
    }
}
