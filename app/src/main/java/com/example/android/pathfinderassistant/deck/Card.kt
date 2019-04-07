package com.example.android.pathfinderassistant.deck

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "cards")
@Parcelize
data class Card(
    @PrimaryKey(autoGenerate = true)
    val databaseId: Int?,
    val characterId : Int, //To identify which character's deck the card belongs to
    var name: String,
    var description: String
) : Parcelable