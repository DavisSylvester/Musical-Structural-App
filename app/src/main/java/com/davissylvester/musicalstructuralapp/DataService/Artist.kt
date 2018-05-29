package com.davissylvester.musicalstructuralapp.DataService

import android.os.Parcel
import android.os.Parcelable


data class Artist(var FirstName: String, var LastName: String, var photo: String,
                  var StageName: String) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(FirstName)
        parcel.writeString(LastName)
        parcel.writeString(photo)
        parcel.writeString(StageName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Artist> {
        override fun createFromParcel(parcel: Parcel): Artist {
            return Artist(parcel)
        }

        override fun newArray(size: Int): Array<Artist?> {
            return arrayOfNulls(size)
        }
    }

}


