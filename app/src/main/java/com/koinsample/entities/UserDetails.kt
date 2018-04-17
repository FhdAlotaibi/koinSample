package com.koinsample.entities

import com.google.gson.annotations.SerializedName
import java.util.*

class UserDetails {
    @SerializedName("name")
    val name: String? = null
    @SerializedName("dateOfBirthHijri")
    val dateOfBirthHijri: GregorianCalendar? = null
    @SerializedName("dateOfBirthGregorian")
    val dateOfBirthGregorian: GregorianCalendar? = null
    @SerializedName("gender")
    val gender: String? = null
    @SerializedName("registrationDate")
    val registrationDate: String? = null
    @SerializedName("age")
    val age: String? = null
    @SerializedName("nationality")
    val nationality: String? = null
}