package com.example.android.pathfinderassistant.deck

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.pathfinderassistant.Constants
import com.example.android.pathfinderassistant.R
import kotlinx.android.synthetic.main.fragment_card_detail.*
import kotlinx.android.synthetic.main.fragment_card_detail.view.*


private const val ARG_CARD = "card"
private const val ARG_ISTWOPANE = "is_two_pane"

class CardDetailFragment : Fragment() {
    private var card: Card? = null
    private var isTwoPane : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            card = it.getParcelable(ARG_CARD)
            isTwoPane = it.getBoolean(ARG_ISTWOPANE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_card_detail, container, false)
        val cardDetailName = rootView.carddetailfragment_name_tv
        val cardDetailDescrip = rootView.carddetailfragment_descrip_tv
        val editCardButton = rootView.edit_card_button

        cardDetailName.setText(card!!.name)
        cardDetailDescrip.setText(card!!.description)

        editCardButton.setOnClickListener {
            val intent = Intent(activity, EditCardActivity::class.java)
            intent.putExtra(Constants.CARD_KEY, card)
            startActivity(intent)
            if (!isTwoPane) activity!!.finish() //Clear the card detail activity if open
        }

        return rootView
    }


    companion object {
        @JvmStatic
        fun newInstance(card : Card, isTwoPane : Boolean) =
            CardDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CARD, card)
                    putBoolean(ARG_ISTWOPANE, isTwoPane)
                }
            }
    }
}
