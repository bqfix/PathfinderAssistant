package com.example.android.pathfinderassistant.deck

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.android.pathfinderassistant.Constants.DECK_ID_DEFAULT
import com.example.android.pathfinderassistant.Constants.DECK_ID_KEY
import com.example.android.pathfinderassistant.DiceActivity
import com.example.android.pathfinderassistant.R
import kotlinx.android.synthetic.main.activity_card_list.*

class CardListActivity : AppCompatActivity(),
    CardListFragment.TwoPaneItemClickListener {

    var isTwoPane : Boolean = false
    var cardListFragment : CardListFragment? = null
    var cardDetailFragment : CardDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)

        //Get deck from intent
        val deckID = intent.getIntExtra(DECK_ID_KEY, DECK_ID_DEFAULT)
        if (deckID == DECK_ID_DEFAULT) {
            finish()
        }

        title = "Deck"

        //Check if in two-pane mode by seeing if the detail container has been inflated
        isTwoPane = (cardlist_detailfragment_container != null)

        //Populate card list
        if (cardListFragment == null) {
            cardListFragment =
                    CardListFragment.newInstance(deckID, isTwoPane)
        }
        supportFragmentManager.beginTransaction().replace(R.id.cardlist_listfragment_container, cardListFragment!!).commit()
    }

    override fun onItemClick(card: Card) {
        cardDetailFragment = CardDetailFragment.newInstance(card)
        supportFragmentManager.beginTransaction().replace(R.id.cardlist_detailfragment_container, cardDetailFragment!!).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.card_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_launch_dice -> {
                val intent = Intent(this, DiceActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
