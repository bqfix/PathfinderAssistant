package com.example.android.pathfinderassistant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_card_list.*

class CardListActivity : AppCompatActivity(), CardListFragment.TwoPaneItemClickListener {

    var isTwoPane : Boolean = false
    var cardListFragment : CardListFragment? = null
    var cardDetailFragment : CardDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)

        //Initialize a deck of cards
        val deck = arrayListOf(Card(getString(R.string.dazzle_name), getString(R.string.dazzle_descrip)),
            Card(getString(R.string.frigid_blast_name), getString(R.string.frigid_blast_descrip)),
            Card(getString(R.string.fiery_glare_name), getString(R.string.fiery_glare_descrip)),
            Card(getString(R.string.lightning_touch_name), getString(R.string.lightning_touch_descrip)),
            Card(getString(R.string.sagacity_name), getString(R.string.sagacity_descrip)),
            Card(getString(R.string.magic_padded_armor_name), getString(R.string.magic_padded_armor_descrip)),
            Card(getString(R.string.sages_journal_name), getString(R.string.sages_journal_descrip)),
            Card(getString(R.string.wand_of_paralyze_name), getString(R.string.wand_of_paralyze_descrip)),
            Card(getString(R.string.frog_name), getString(R.string.frog_descrip)),
            Card(getString(R.string.teamster_name), getString(R.string.teamster_descrip)),
            Card(getString(R.string.apprentice_name), getString(R.string.apprentice_descrip)),
            Card(getString(R.string.blessing_of_ascension_name), getString(R.string.blessing_of_ascension_descrip)),
            Card(getString(R.string.blessing_of_shax_name), getString(R.string.blessing_of_shax_descrip)))

        //Check if in two-pane mode by seeing if the detail container has been inflated
        isTwoPane = (cardlist_detailfragment_container != null)

        //Populate card list
        if (cardListFragment == null) {
            cardListFragment = CardListFragment.newInstance(deck, isTwoPane)
        }
        supportFragmentManager.beginTransaction().replace(R.id.cardlist_listfragment_container, cardListFragment!!).commit()
    }

    override fun onItemClick(card: Card) {
        cardDetailFragment = CardDetailFragment.newInstance(card)
        supportFragmentManager.beginTransaction().replace(R.id.cardlist_detailfragment_container, cardDetailFragment!!).commit()
    }

}
