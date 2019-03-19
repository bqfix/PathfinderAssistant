package com.example.android.pathfinderassistant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity : AppCompatActivity() {

    var card : Card? = null
    var detailFragment : CardDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detail)

        //Get card
        card = intent.getParcelableExtra(CARD_KEY)
        if (card == null) finish()

        //Setup fragment
        if (detailFragment == null) {
            detailFragment = CardDetailFragment.newInstance(card!!)
        }
        supportFragmentManager.beginTransaction().replace(R.id.carddetail_detailfragment_container, detailFragment!!).commit()
    }
}
