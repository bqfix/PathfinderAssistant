package com.example.android.pathfinderassistant

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.android.pathfinderassistant.Constants.CHARACTER_KEY
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.characters.Seoni
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterRecyclerAdapter.CharacterClickHandler {

    val mCharacters : ArrayList<BaseCharacter> = arrayListOf(Seoni(), Seoni(), Seoni()) //TODO replace fake data with database saved sources
    var mAdapter : CharacterRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = CharacterRecyclerAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        character_list_rv.adapter = mAdapter
        character_list_rv.layoutManager = layoutManager



        mAdapter!!.updateCharacters(mCharacters)

        add_character_fab.setOnClickListener { //TODO update to launch AddEditCharacterActivity
            mCharacters.add(Seoni())
            mAdapter!!.updateCharacters(mCharacters)}
    }

    //Handling of RecyclerView clicks
    override fun onItemClick(character: BaseCharacter) {
        val intent = Intent(this, CharacterSummaryActivity::class.java)
        intent.putExtra(CHARACTER_KEY, character)
        startActivity(intent)
    }
}
