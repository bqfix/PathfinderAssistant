package com.example.android.pathfinderassistant.deck

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android.pathfinderassistant.Constants.CARD_KEY
import com.example.android.pathfinderassistant.DiceActivity
import com.example.android.pathfinderassistant.R

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
            detailFragment =
                    CardDetailFragment.newInstance(card!!)
        }
        supportFragmentManager.beginTransaction().replace(R.id.carddetail_detailfragment_container, detailFragment!!).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_activity_menu, menu)
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
