package com.example.geohunt

import android.os.Parcel
import android.os.Parcelable

data class Location(
	var Latitude: Double,
	var Longitude: Double,
	var Description: String
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readDouble(),
		parcel.readDouble(),
		parcel.readString()!!
	) {
	}

	override fun describeContents(): Int {
		return 0
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeDouble(Latitude)
		parcel.writeDouble(Longitude)
		parcel.writeString(Description)
	}

	companion object CREATOR : Parcelable.Creator<Location> {
		override fun createFromParcel(parcel: Parcel): Location {
			return Location(parcel)
		}

		override fun newArray(size: Int): Array<Location?> {
			return arrayOfNulls(size)
		}
	}
}
