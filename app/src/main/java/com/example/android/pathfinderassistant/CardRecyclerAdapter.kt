package com.example.android.pathfinderassistant

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.card_recycler_item.view.*

class CardRecyclerAdapter internal constructor(private val cardClickHandler : CardClickHandler) : RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder>() {

    private var mCards : List<Card>? = null

    //Inner ViewHolder Class
    inner class CardViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val mName : TextView

        init {
            mName = itemView.cardrecycler_name
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val card = mCards!![adapterPosition]
            cardClickHandler.onItemClick(card)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.card_recycler_item, viewGroup, false)

        return CardViewHolder(view)
    }

    override fun onBindViewHolder(cardViewHolder: CardViewHolder, position: Int) {
        val currentCard = mCards!![position]
        cardViewHolder.mName.setText(currentCard.name)
    }

    override fun getItemCount(): Int {
        return if (mCards == null) 0 else mCards!!.size
    }

    fun updateCards(cards : List<Card>) {
        mCards = cards
        notifyDataSetChanged()
    }

    interface CardClickHandler {
        fun onItemClick(card:Card)
    }
}