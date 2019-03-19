package com.example.android.pathfinderassistant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_CARDS = "cards"

class CardListFragment : Fragment() {
    private var cards: List<Card>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cards = it.getParcelableArrayList(ARG_CARDS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_list, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(cards : ArrayList<Card>) =
            CardListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_CARDS, cards)
                }
            }
    }
}
