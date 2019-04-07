package com.example.android.pathfinderassistant.deck

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.pathfinderassistant.Constants
import com.example.android.pathfinderassistant.Constants.CARD_KEY
import com.example.android.pathfinderassistant.MainViewModel
import com.example.android.pathfinderassistant.R
import com.example.android.pathfinderassistant.characters.BaseCharacter
import com.example.android.pathfinderassistant.database.AppDatabase
import com.example.android.pathfinderassistant.database.CharacterDatabaseUtils
import kotlinx.android.synthetic.main.fragment_card_list.view.*


private const val ARG_DECK_ID = "deckId"
private const val ARG_ISTWOPANE = "is_two_pane"

class CardListFragment : Fragment(), CardRecyclerAdapter.CardClickHandler {
    private var deckId : Int = Constants.DECK_ID_DEFAULT
    private var isTwoPane : Boolean = false
    private var twoPaneClickListener : TwoPaneItemClickListener? = null
    private var mAdapter : CardRecyclerAdapter? = null
    private var mDatabase : AppDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            deckId = it.getInt(ARG_DECK_ID)
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
        mAdapter = CardRecyclerAdapter(this)
        val cardListRecyclerView = rootView.cardlistfragment_rv
        cardListRecyclerView.layoutManager = layoutManager
        cardListRecyclerView.adapter = mAdapter

        mDatabase = AppDatabase.getInstance(activity as Context)

        setupViewModel()

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        twoPaneClickListener = context as TwoPaneItemClickListener
    }


    companion object {
        @JvmStatic
        fun newInstance(deckId: Int, isTwoPane : Boolean) =
            CardListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_DECK_ID, deckId)
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

    //Helper to setup viewmodel
    fun setupViewModel() {
        val factory = CardViewModelFactory(mDatabase!!, deckId)
        val viewModel = ViewModelProviders.of(this,factory).get<CardViewModel>(CardViewModel::class.java)
        viewModel.cards!!.observe(this, Observer { cards ->
            mAdapter!!.updateCards(cards!!)
        })
    }
}
