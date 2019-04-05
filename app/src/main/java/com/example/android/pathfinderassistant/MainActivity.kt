package com.example.android.pathfinderassistant

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.android.pathfinderassistant.Constants.CHARACTER_KEY
import com.example.android.pathfinderassistant.characterdatabase.CharacterDatabaseUtils
import com.example.android.pathfinderassistant.characterdatabase.CharacterEntry
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.characters.Seoni
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterRecyclerAdapter.CharacterClickHandler {

    var mAdapter : CharacterRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Characters"

        mAdapter = CharacterRecyclerAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        character_list_rv.adapter = mAdapter
        character_list_rv.layoutManager = layoutManager

        setupViewModel()

        add_character_fab.setOnClickListener {
            val intent = Intent(this, AddCharacterActivity::class.java)
            startActivity(intent)}
    }

    //Handling of RecyclerView clicks
    override fun onItemClick(character: BaseCharacter) {
        val intent = Intent(this, CharacterSummaryActivity::class.java)
        intent.putExtra(CHARACTER_KEY, character)
        startActivity(intent)
    }

    //Helper to setup viewmodel
    fun setupViewModel() {
        val viewModel = ViewModelProviders.of(this).get<MainViewModel>(MainViewModel::class.java)
        viewModel.characterEntries!!.observe(this, Observer { characterEntries ->
            val characters : ArrayList<BaseCharacter> = arrayListOf() //Clear mCharacters and begin repopulating
            for (characterEntry in characterEntries!!) {
                characters.add(CharacterDatabaseUtils.characterEntryToCharacter(characterEntry)!!)
            }
            mAdapter!!.updateCharacters(characters)
         })
    }
}
