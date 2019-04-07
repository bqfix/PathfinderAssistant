package com.example.android.pathfinderassistant

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.android.pathfinderassistant.database.AppDatabase
import com.example.android.pathfinderassistant.database.CharacterEntry

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var characterEntries : LiveData<List<CharacterEntry>>? = null

    init {
        val database = AppDatabase.getInstance(this.getApplication())
        characterEntries = database!!.characterDao().loadAllCharacters()
    }
}