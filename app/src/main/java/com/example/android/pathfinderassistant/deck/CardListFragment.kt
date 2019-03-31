package com.example.android.pathfinderassistant.deck

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.pathfinderassistant.Constants.CARD_KEY
import com.example.android.pathfinderassistant.R
import kotlinx.android.synthetic.main.fragment_card_list.view.*


private const val ARG_CARDS = "cards"
private const val ARG_ISTWOPANE = "is_two_pane"

class CardListFragment : Fragment(), CardRecyclerAdapter.CardClickHandler {
    private var cards : List<Card>? = null
    private var isTwoPane : Boolean = false
    private var twoPaneClickListener : TwoPaneItemClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cards = it.getParcelableArrayList(ARG_CARDS)
            isTwoPane = it.getBoolean(ARG_ISTWOPANE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_card_list, container, false)

        val layoutManager = LinearLayoutManager(rootView.context, LinearLayoutManager.VERTICAL, false)
        val recyclerAdapter = CardRecyclerAdapter(this)
        val cardListRecyclerView = rootView.cardlistfragment_rv
        cardListRecyclerView.layoutManager = layoutManager
        cardListRecyclerView.adapter = recyclerAdapter

        recyclerAdapter.updateCards(cards!!)

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        twoPaneClickListener = context as TwoPaneItemClickListener
    }


    companion object {
        @JvmStatic
        fun newInstance(cards : ArrayList<Card>, isTwoPane : Boolean) =
            CardListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_CARDS, cards)
                    putBoolean(ARG_ISTWOPANE, isTwoPane)
                }
            }
    }

    override fun onItemClick(card: Card) {
        //Open new activity using clicked card if not two-pane
        if (!isTwoPane) {
            val intent = Intent(activity, CardDetailActivity::class.java)
            intent.putExtra(CARD_KEY, card)
            startActivity(intent)
        } else { //Pass the click event to the CardListActivity to be handled
            twoPaneClickListener!!.onItemClick(card)
        }

    }

    interface TwoPaneItemClickListener {
        fun onItemClick(card: Card)
    }
}
