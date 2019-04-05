package com.example.android.pathfinderassistant

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.android.pathfinderassistant.characterdatabase.CharacterDatabase
import com.example.android.pathfinderassistant.characterdatabase.CharacterEntry

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var characterEntries : LiveData<List<CharacterEntry>>? = null

    init {
        val database = CharacterDatabase.getInstance(this.getApplication())
        characterEntries = database!!.characterDao().loadAllCharacters()
    }
}