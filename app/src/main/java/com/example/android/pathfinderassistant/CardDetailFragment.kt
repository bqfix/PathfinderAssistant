package com.example.android.pathfinderassistant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_CARD = "card"

class CardDetailFragment : Fragment() {
    private var card: Card? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            card = it.getParcelable(ARG_CARD)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(card : Card) =
            CardDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CARD, card)
                }
            }
    }
}
