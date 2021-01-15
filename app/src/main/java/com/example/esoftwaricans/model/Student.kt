package com.example.esoftwaricans.model

import android.os.Parcel
import android.os.Parcelable

data class Student(
    val stdId:String? = null,
    val stdName: String? = null,
    val stdAge: String? = null,
    val stdGender: String? = null,
    val stdAddress: String? = null,
    val stdPicture: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(stdId)
        parcel.writeString(stdName)
        parcel.writeString(stdAge)
        parcel.writeString(stdGender)
        parcel.writeString(stdAddress)
        parcel.writeString(stdPicture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}