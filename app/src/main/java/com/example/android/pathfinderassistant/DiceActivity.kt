package com.example.android.pathfinderassistant

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dice.*
import java.util.*

class DiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        title = "Dice"

        supportActionBar!!.setHomeButtonEnabled(true)

        makeEditTextVisible()
        setDecrementAndIncrementOnClickListeners()
        setResetAllEditTexts()
        setRollAllDice()


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //A helper function to make all the numbers in the EditTexts visible
    fun makeEditTextVisible() {
        d4_edittext.transformationMethod = null
        d6_edittext.transformationMethod = null
        d8_edittext.transformationMethod = null
        d10_edittext.transformationMethod = null
        d12_edittext.transformationMethod = null
        d20_edittext.transformationMethod = null
    }

    // A helper method to decrement and increment an edit text
    fun setDecrementAndIncrementEditText(minusButton: Button, plusButton: Button, editText: EditText) {
        minusButton.setOnClickListener {
            var editTextValue = editText.text.toString().toInt()
            if (editTextValue > 0) editTextValue -= 1
            else Toast.makeText(this, R.string.cannot_decrement_error, Toast.LENGTH_SHORT).show()
            editText.setText(editTextValue.toString())
        }
        plusButton.setOnClickListener {
            var editTextValue: Int = editText.text.toString().toInt()
            editTextValue += 1
            editText.setText(editTextValue.toString())
        }

    }

    //A helper method to set onClickListeners to each increment/decrement button
    fun setDecrementAndIncrementOnClickListeners() {
        setDecrementAndIncrementEditText(d4_minus_button, d4_plus_button, d4_edittext)
        setDecrementAndIncrementEditText(d6_minus_button, d6_plus_button, d6_edittext)
        setDecrementAndIncrementEditText(d8_minus_button, d8_plus_button, d8_edittext)
        setDecrementAndIncrementEditText(d10_minus_button, d10_plus_button, d10_edittext)
        setDecrementAndIncrementEditText(d12_minus_button, d12_plus_button, d12_edittext)
        setDecrementAndIncrementEditText(d20_minus_button, d20_plus_button, d20_edittext)
    }

    //A helper method to set the onClickListener to reset all EditTexts to 0
    fun setResetAllEditTexts() {
        reset_button.setOnClickListener {
            d4_edittext.setText("0")
            d6_edittext.setText("0")
            d8_edittext.setText("0")
            d10_edittext.setText("0")
            d12_edittext.setText("0")
            d20_edittext.setText("0")
        }
    }

    //A helper method to roll dice for a given EditText
    fun rollDice(editText: EditText, dieSize: Int): Int {
        val numberOfDice = editText.text.toString().toInt()
        var total = 0
        repeat(numberOfDice, { total += (Random().nextInt(dieSize) + 1) })
        return total
    }

    //A helper method to set the onClickListener to roll all dice
    fun setRollAllDice() {
        roll_button.setOnClickListener {
            var grandTotal = 0
            grandTotal += rollDice(d4_edittext, 4)
            grandTotal += rollDice(d6_edittext, 6)
            grandTotal += rollDice(d8_edittext, 8)
            grandTotal += rollDice(d10_edittext, 10)
            grandTotal += rollDice(d12_edittext, 12)
            grandTotal += rollDice(d20_edittext, 20)

            val grandTotalText = getString(R.string.total) + " $grandTotal"

            total_tv.setText(grandTotalText)
        }
    }
}
