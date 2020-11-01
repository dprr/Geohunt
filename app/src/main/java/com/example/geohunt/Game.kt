package com.example.geohunt

import android.os.Parcel
import android.os.Parcelable

data class Game(
	val name: String,
	val description: String,
	val locationList: MutableList<Location>
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString()!!,
		parcel.readString()!!,
		parcel.createTypedArrayList(Location)!!
	) {
	}

	override fun describeContents(): Int {
		return 0
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(name)
		parcel.writeString(description)
		parcel.writeTypedList(locationList)
	}

	companion object CREATOR : Parcelable.Creator<Game> {
		override fun createFromParcel(parcel: Parcel): Game {
			return Game(parcel)
		}

		override fun newArray(size: Int): Array<Game?> {
			return arrayOfNulls(size)
		}
	}
}