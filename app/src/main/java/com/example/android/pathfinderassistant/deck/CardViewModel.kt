package com.example.android.pathfinderassistant.deck

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.android.pathfinderassistant.database.AppDatabase

class CardViewModel(database: AppDatabase, characterId: Int) : ViewModel() {

    var cards : LiveData<List<Card>>? = null

    init {
        cards = database.cardDao().loadCardsByCharacterId(characterId)
    }
}