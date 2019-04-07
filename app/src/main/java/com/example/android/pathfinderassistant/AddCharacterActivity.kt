package com.example.android.pathfinderassistant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.pathfinderassistant.characters.*
import kotlinx.android.synthetic.main.activity_add_character.*

class AddCharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_character)

        title = "New Character"

        //Set each character option to launch EditCharacterActivity with a new instance of that character
        // (Note: While this is repetitive and not modular, the small number of characters and set size does not lend itself to a ListView or RecyclerView)
        seoni_selection_tv.setOnClickListener { launchEditActivity(Seoni()) }
        imrijka_selection_tv.setOnClickListener { launchEditActivity(Imrijka()) }
        seelah_selection_tv.setOnClickListener { launchEditActivity(Seelah()) }
        kyra_selection_tv.setOnClickListener { launchEditActivity(Kyra()) }
        enora_selection_tv.setOnClickListener { launchEditActivity(Enora()) }
    }

    fun launchEditActivity(character : BaseCharacter) {
        val intent = Intent(this, EditCharacterActivity::class.java)
        intent.putExtra(Constants.CHARACTER_KEY, character)
        startActivity(intent)
        finish()
    }
}
