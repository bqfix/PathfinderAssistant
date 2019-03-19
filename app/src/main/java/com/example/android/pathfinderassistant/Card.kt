package com.example.android.pathfinderassistant

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Card (var name : String, var description : String) : Parcelable