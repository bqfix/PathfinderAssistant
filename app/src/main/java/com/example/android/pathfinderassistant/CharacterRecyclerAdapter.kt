package com.example.android.pathfinderassistant

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.pathfinderassistant.characters.BaseCharacter
import kotlinx.android.synthetic.main.character_recycler_item.view.*

class CharacterRecyclerAdapter internal constructor(private val characterClickHandler: CharacterClickHandler) :
    RecyclerView.Adapter<CharacterRecyclerAdapter.CharacterViewHolder>() {

    private var mCharacters: List<BaseCharacter>? = null

    //Inner ViewHolder Class
    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val mName: TextView

        init {
            mName = itemView.character_recycler_name_tv
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val character = mCharacters!![adapterPosition]
            characterClickHandler.onItemClick(character)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CharacterRecyclerAdapter.CharacterViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.character_recycler_item, viewGroup, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(characterViewHolder: CharacterViewHolder, position: Int) {
        val currentCharacter = mCharacters!![position]
        characterViewHolder.mName.setText(currentCharacter.characterName)
    }

    override fun getItemCount(): Int {
        return if (mCharacters == null) 0 else mCharacters!!.size
    }

    fun updateCharacters(characters: List<BaseCharacter>) {
        mCharacters = characters
        notifyDataSetChanged()
    }

    interface CharacterClickHandler {
        fun onItemClick(character: BaseCharacter)
    }
}