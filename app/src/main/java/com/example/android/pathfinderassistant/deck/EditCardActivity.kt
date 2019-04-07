package com.example.android.pathfinderassistant.deck

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.android.pathfinderassistant.AppExecutors
import com.example.android.pathfinderassistant.Constants
import com.example.android.pathfinderassistant.R
import com.example.android.pathfinderassistant.database.AppDatabase
import kotlinx.android.synthetic.main.activity_edit_card.*

class EditCardActivity : AppCompatActivity() {

    var card : Card? = null
    var mDatabase : AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_card)

        //Get card
        card = intent.getParcelableExtra(Constants.CARD_KEY)
        if (card == null) finish()

        //Set up database
        mDatabase = AppDatabase.getInstance(this)

        //Populate views
        card_name_et.setText(card!!.name)
        card_descrip_et.setText(card!!.description)

    }

    //Helper method for saving or updating cards in database
    fun saveOrUpdateCard() {
        if (card_name_et.text.trim().isEmpty()) { //Ensure that at least a name is entered, and not only whitespace
            Toast.makeText(this, R.string.enter_card_name,Toast.LENGTH_SHORT).show()
            return
        }
        card!!.name = card_name_et.text.toString() //Update card
        card!!.description = card_descrip_et.text.toString()

        when (card!!.databaseId) { //Save
            null -> AppExecutors.getInstance()!!.diskIO.execute {
                mDatabase!!.cardDao().insertCard(card!!)
            }
            else -> AppExecutors.getInstance()!!.diskIO.execute {
                mDatabase!!.cardDao().updateCard(card!!)
            }
        }
        Toast.makeText(this, R.string.card_saved_confirmation, Toast.LENGTH_SHORT).show()
        finish()
    }

    //Helper method to delete cards
    fun deleteCard() {
        when (card!!.databaseId) {
            null -> {
                Toast.makeText(this, R.string.card_not_deleted, Toast.LENGTH_SHORT).show()
                finish()
            }
            else -> {
                AppExecutors.getInstance()!!.diskIO.execute {
                    mDatabase!!.cardDao().deleteCard(card!!)
                    finish()
                }
                Toast.makeText(this, R.string.card_deleted, Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.card_edit_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_save_card -> {
                saveOrUpdateCard()
                return true
            }
            R.id.action_delete_card -> {
                deleteCard()
                return true
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun hideKeyboard(view : View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
