package com.example.android.pathfinderassistant.deck

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.android.pathfinderassistant.database.AppDatabase

class CardViewModelFactory(val database: AppDatabase, val characterId: Int) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CardViewModel(database, characterId) as T
    }
}